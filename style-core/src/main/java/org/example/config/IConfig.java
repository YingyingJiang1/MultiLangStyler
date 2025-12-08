package org.example.config;

import org.example.controller.StylerContainer;
import org.example.lang.intf.MyParser;
import org.example.styler.Styler;

import java.util.List;

public interface IConfig {
	Class<?> getMyParserClass(String lang);

	Class<?> getTreeNodeFactoryClass(String lang);

	Class<?> getASTRewriterClass(String lang);

	String getJavaEquivalencesConfig();

	String getCPPEquivalencesConfig();

	String getPythonEquivalencesConfig();

	Class<?> getNodeSearcherFactory(String lang);


	double getMinDominantRatio();

	String getLLMUrl();
	String getLLMApiKey();
	String getLLMModel();
	double getLLMTemperature();
	double getLLMMaxTokens();

	int getIdentifierLengthLimit();

	/**
	 * Get StylerContainer for specific language with all stylers.
	 * @param lang
	 */
	StylerContainer getStylerContainer(String lang);

	/**
	 * Set enabled stylers for specific language.
	 */
	void SetEnabledStylers(String lang, List<Class<?>> stylerClasses);

	Class<?> getPlaceholderParser(String lang);
}
