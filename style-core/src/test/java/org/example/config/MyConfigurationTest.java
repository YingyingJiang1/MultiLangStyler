package org.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyConfigurationTest {

	@Autowired
	private MyConfiguration configManager;

	@Test
	void testLLMConfig() {
		assertNotNull(configManager.getLlmConfig(), "LLMConfig 应该被注入");
		assertEquals("your-api-key", configManager.getLlmConfig().getApikey());
		assertEquals("url of platform providing model services", configManager.getLlmConfig().getUrl());
		assertEquals("gpt-5", configManager.getLlmConfig().getModel());
		assertEquals(64, configManager.getLlmConfig().getIdentifierLengthLimit());
		assertEquals(0.6, configManager.getLlmConfig().getTemperature());
		assertEquals(1024, configManager.getLlmConfig().getMaxNewTokens());
	}

	@Test
	void testLangConfig() {
		assertNotNull(configManager.getLanguageConfigs(), "AllLanguageConfigs 应该被注入");
		assertEquals(10, configManager.getLanguageConfigs().getAll().size());
	}
}