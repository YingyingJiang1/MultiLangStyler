public class Test {
	public void mytest(boolean flag) {
		Data d = new Data();
		incData(d);

		int x = d.a + d.c, y = 4;
		if (x > y) {
			System.out.println("x is greater than y");
		} else {
			System.out.println("y is greater than x");
		}
	}

	public void incData(Data d, boolean flag) {
		if (flag) {
			d.a += 1;
			d.c += 4;
		}
	}
}


class Data {
	int a = 1;
	int c = 2;
}