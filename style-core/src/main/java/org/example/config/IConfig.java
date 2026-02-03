package org.example.config;

import org.example.style.StylerContainer;

import java.util.List;

public interface IConfig {
	Class<?> getMyParserClass(String lang);

	Class<?> getTreeNodeFactoryClass(String lang);

	Class<?> getASTRewriterClass(String lang);

	String getEquivalencesConfig(String lang);

	Class<?> getNodeSearcherFactory(String lang);

	String getLLMUrl();
	String getLLMApiKey();
	String getLLMModel();
	double getLLMTemperature();
	double getLLMMaxTokens();

	MyConfiguration.ProjectConfig getProjectConfig();



	/**
	 * Create StylerContainer for specific language with all stylers.
	 * @param lang
	 */
	StylerContainer creasteStylerContainer(String lang);

	/**
	 * Set enabled stylers for specific language.
	 */
	void SetEnabledStylers(String lang, List<Class<?>> stylerClasses);

	Class<?> getPlaceholderParser(String lang);

	Class<?> getSymbolResolver(String lang);

	Class<?> getTypeResolver(String lang);
}
