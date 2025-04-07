import org.junit.jupiter.api.Test;

public class ComplexityTest extends IntegrationTest{

	@Test
	public void textComplexity() {
		batchTest(2, "code_complexity", "");
	}

	@Test
	public void testExpressionComplexity() {
		batchTest(2, "expression_complexity", "002");
	}

	@Test
	public void testMethodComplexity() {
		batchTest(2, "method_complexity", "");
	}
}
