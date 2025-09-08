package org.example.controller;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.example.TestBase;
import org.example.Utils;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenAugmentorTest extends TestBase {

	@Test
	void process() throws IOException {

		String[] srcFiles = {"src/test/sources/format/newline/f2.java", "src/test/sources/format/newline/f1.java"};
		for (String srcFile : srcFiles) {
			MyParser parser = MyParserFactory.createParser("java");
			try {
				parser.parse(Paths.get(srcFile));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			String expected = Files.readString(Paths.get(srcFile));


			List<Token> tokens = new ArrayList<>();
			Utils.generateTokens(parser.getRoot(), tokens, parser);
			StringBuilder actual = new StringBuilder();
			tokens.forEach(t -> actual.append(t.getText()));

			assertEquals(expected, actual.toString());
		}

	}
}