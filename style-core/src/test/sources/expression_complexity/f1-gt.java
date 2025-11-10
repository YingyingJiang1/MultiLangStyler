class Main {
	int ffffffff() {
		return 0;
	}

	void longStyle() {
		int literalExpr = 123 + 456 * 789 - 321 / 7 + 98765 % 4321 + 11111 * 22222 - 33333 / 444 + 55555;

		// 定义一些 primitive type 变量
		int a = 10, b = 20, c = 30, d = 40, e = 50;
		double x = 1.5, y = 2.5;
		boolean flag = true;

		// 包含 primitive type 的长表达式
		double primitiveExpr = a + b * c - d / 2 + e % 3 + ffffffff() * b * c - d * e + (a + c) * (b - e)
				+ x * y + (flag ? a : e);

		System.out.println("Literal expression result: " + literalExpr);
		System.out.println("Primitive type expression result: " + primitiveExpr);

	}
}

