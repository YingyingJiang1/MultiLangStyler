
import org.example.parser.common.MyParser;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.semantic.intf.DefUseGetter;
import org.example.semantic.java.JavaDefUseGetter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaieTest {
	public static void main(String[] args) throws IOException {
		DefUseGetter getter = new JavaDefUseGetter();
		MyParser parser = new MyJavaParser();
		parser.parse(Paths.get("src\\test\\sources\\sa\\Test.java"));

		getter.getAllDefsBefore(null, parser);

	}
}
