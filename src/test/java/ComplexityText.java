import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ComplexityText extends IntegrationTest{

	@Test
	public void textComplexity() {
		batchTest(2, "code_complexity", "002");
	}
}
