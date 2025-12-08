package org.example.lang;

import org.example.MyEnvironment;
import org.example.lang.base.CodeContextPredicateBase;
import org.example.lang.base.FormatUnitGrouperBase;
import org.example.lang.cpp.CppASTNodeEditor;
import org.example.lang.intf.*;
import org.example.lang.java.JavaCodeContextPredicate;
import org.example.lang.java.JavaASTNodeEditor;
import org.example.lang.python.PythonAstNodeEditor;
import org.example.lang.base.PlaceholderParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class LangAdapterCreator {

	private static final Logger logger = LoggerFactory.getLogger(LangAdapterCreator.class);

	// 缓存 getInstance 方法，避免重复反射，提升效率
	private static final ConcurrentHashMap<Class<?>, Method> GET_INSTANCE_CACHE = new ConcurrentHashMap<>();

	/**
	 * 通用创建逻辑：通过 getInstance() 创建实例（带缓存）
	 */
	@SuppressWarnings("unchecked")
	private static <T> T createByGetInstance(Class<?> clazz, String lang) {
		try {
			// 从缓存获取方法，不存在则放入缓存
			Method method = GET_INSTANCE_CACHE.computeIfAbsent(clazz, c -> {
				try {
					Method m = c.getMethod("getInstance");
					m.setAccessible(true);
					return m;
				} catch (Exception e) {
					logger.warn("No getInstance() method found in class: {}", c.getName(), e);
					return null;
				}
			});

			if (method == null) {
				return null;
			}

			return (T) method.invoke(null);

		} catch (Exception e) {
			logger.warn("Failed to create instance via getInstance() for class: {}, lang: {}",
					clazz.getName(), lang, e);
			return null;
		}
	}

	// ------------ 业务类构造 ------------

	public static MyParser createParser(String lang) {
		Class<?> parserClass = MyEnvironment.getIConfig().getMyParserClass(lang);
		try {
			return (MyParser) parserClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			logger.warn("Failed to create parser instance via constructor for class: {}",
					parserClass.getName(), e);
			return null;
		}
	}

	public static TreeNodeFactory createTreeNodeFactory(String lang) {
		Class<?> factoryClass = MyEnvironment.getIConfig().getTreeNodeFactoryClass(lang);
		return createByGetInstance(factoryClass, lang);
	}

	public static ASTRewriter createASTRewriter(String lang) {
		Class<?> rewriterClass = MyEnvironment.getIConfig().getASTRewriterClass(lang);
		return createByGetInstance(rewriterClass, lang);
	}

	public static INodeSearcherFactory createNodeSearcherFactory(String lang) {
		Class<?> searcherClass = MyEnvironment.getIConfig().getNodeSearcherFactory(lang);
		return createByGetInstance(searcherClass, lang);
	}

	public static CodeContextPredicate createCodeContextPredicate(String lang) {
		return switch (lang) {
			case "java" -> JavaCodeContextPredicate.getInstance();
			default -> CodeContextPredicateBase.getInstance();
		};
	}

	public static FormatUnitGrouper createFormatUnitGrouper(String lang) {
		return switch (lang) {
			default -> FormatUnitGrouperBase.getInstance();
		};
	}


	public static ASTNodeEditor createASTNodeEditor(String lang) {
		return switch (lang) {
			case "java" -> JavaASTNodeEditor.getInstance();
			case "cpp" -> CppASTNodeEditor.getInstance();
			case "python" -> PythonAstNodeEditor.getInstance();
			default -> null;
		};
	}

	public static PlaceholderParser createPlaceholderParser(String lang) {
		Class<?> parserClass = MyEnvironment.getIConfig().getPlaceholderParser(lang);
		try {
			return (PlaceholderParser) parserClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			logger.warn("Failed to create parser instance via constructor for class: {}",
					parserClass.getName(), e);
			return null;
		}
	}
}


