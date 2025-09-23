package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.TypeResolver;
import org.example.semantic.intf.symbol.ClassSym;
import org.example.semantic.intf.symbol.FunctionSym;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.PrimitiveType;
import org.example.semantic.intf.type.ReferenceType;
import org.example.semantic.intf.type.Type;

import java.util.*;

public class TypeResolverImpl implements TypeResolver {
	private static Map<Integer, String> literalTypeMap =  null;


	@Override
	public Type getType(ExtendContext node, MyParser parser) {
		if (parser.isIdentifier(node)) {
			return getIdentifierType(node, parser);
		} else if (parser.isExpression(node)) {
			return getExpressionType(node, parser);
		} else {
			return null;
		}
	}

	/**
	 *
	 * @return The wider type of t1 and t2. If t1 and t2 are not primitive type, return null.
	 */
	@Override
	public Type calculateType(Type t1, Type t2, String operator, MyParser parser) {
		if (parser.belongToAssignOp(operator)|| operator.equals("<<") || operator.equals(">>") || operator.equals(">>>")) {
			return t1;
		}
		if (t1 instanceof PrimitiveType p1 && t2 instanceof PrimitiveType p2) {
			if (parser.belongToCompareOp(operator)) {
				return new PrimitiveType(null, "boolean");
			}
			return p1.isWider(p2) ? t1 : t2;
		}
		return null;
	}

	private Type getIdentifierType(ExtendContext identifier, MyParser parser) {
		Symbol sym = GlobalInfo.getResolver().resolve(identifier, parser);
		if (sym instanceof VarSym varSym) {
			return varSym.getType();
		} else if (sym instanceof FunctionSym functionSym) {
			return functionSym.getRetType();
		}
		return null;
	}

	private Type getExpressionType(ExtendContext expression, MyParser parser) {
		List<Type> types = new ArrayList<>();
		String operator = "";

		Type type = null;
		for (ParseTree child : expression.children) {
			if (parser.isIdentifier(child)) {
				types.add(getIdentifierType((ExtendContext) child, parser));
			} else if(parser.isExpression(child)) {
				types.add(getExpressionType((ExtendContext) child, parser));
			} else if (parser.belongToOperator(child.getText())) {
				operator += child.getText();
			} else if (parser.isLiteral(child)) {
				types.add(getLiteralType((ExtendContext) child, parser));
			}
		}

		for (Type t : types) {
			if (t == null || t instanceof ReferenceType) {
				return null;
			}
		}
		if (types.contains(null)) {
			return null;
		}

		type = null;
		Queue<Type> queue = new ArrayDeque<>(types);
		while (!queue.isEmpty()) {
			if (type == null) {
				type = queue.poll();
			} else {
				type = calculateType(type, queue.poll(), operator, parser);
				if (type == null) {
					return null;
				}
			}
		}

		return type;
	}


	private Type getLiteralType(ExtendContext literal, MyParser parser) {
		if (literalTypeMap == null) {
			literalTypeMap = new HashMap<>();
			literalTypeMap.put(parser.getRuleIntegerLiteral(), "int");
			literalTypeMap.put(parser.getRuleFloatLiteral(), "double");
			literalTypeMap.put(parser.getRuleCharLiteral(), "char");
			literalTypeMap.put(parser.getRuleStringLiteral(), "String");
			literalTypeMap.put(parser.getRuleBoolLiteral(), "boolean");
			literalTypeMap.put(parser.getRuleTextBlockLiteral(), "String");
		}

		String typeName = literalTypeMap.get(((ExtendContext)literal.getChild(0)).getRuleIndex());
		// 在这里进行类型提升不合适！
		if (typeName != null) {
			if (typeName.equals("String")) {
				return new ReferenceType(null, new ClassSym(typeName));
			}
			if (typeName.equals("int") && (literal.getText().toUpperCase().endsWith("L"))) {
				typeName = "long";
			}
			if (typeName.equals("double") && (literal.getText().toUpperCase().endsWith("F"))) {
				typeName = "float";
			}
			return new PrimitiveType(null, typeName);
		}
		return null;
	}

}
