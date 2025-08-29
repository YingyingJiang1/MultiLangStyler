public static void main(String[] args) {
	int score = 78; // 可以改成其他分数测试

	for (int i = 0; i < 10; i++) {
		if ( score >= 90|| score >= 80 && score < 90) {
			System.out.println("优秀");
			continue;
		}
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		if ( a > b|| a + b < 50) {
			++i;
		}
	}
}