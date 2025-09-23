class Main {
	int ffffffff() {
		return 0;
	}

	void longStyle() {
		int tmp1 = 456*789;
int tmp = 11111*22222;
int tmp2 = 98765%4321;
int tmp3 = 123+tmp1;
int tmp4 = 33333/444;
int tmp5 = 321/7;
int tmp6 = tmp3-tmp5+tmp2;
int tmp7 = tmp6+tmp-tmp4;
int literalExpr = tmp7 + 55555;

		// 定义一些 primitive type 变量
		int a = 10, b = 20, c = 30, d = 40, e = 50;
		double x = 1.5, y = 2.5;
		boolean flag = true;

		// 包含 primitive type 的长表达式
		int tmp8 = (b-e);
int tmp9 = (a+c);
int tmp10 = e%3;
int tmp11 = a+b*c;
int tmp12 = d/2;
int tmp13 = (flag?a:e);
int tmp14 = tmp11-tmp12+tmp10;
double primitiveExpr = tmp14 + ffffffff() * b * c - d * e + tmp9 * tmp8 + x * y + tmp13 ;

		System.out.println("Literal expression result: " + literalExpr);
		System.out.println("Primitive type expression result: " + primitiveExpr);

	}
}

