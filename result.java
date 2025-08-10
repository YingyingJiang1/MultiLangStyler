	import java.util.Scanner;

	public class Chessboard {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while (true) {
				int h = sc.nextInt();

				int w = sc.nextInt();

				if (h == 0 && w == 0) {
					break;
				}

				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if ((i + j) % 2 == 0) {
							System.out.print("#");
						} 
						else {
							System.out.print(".");
						}
					}
					System.out.println();
				}
				System.out.println();
			}
			sc.close();
		}

	}


	public static void drawPlayException(TableElement table, ObjectVO throwableVO) {
		// 执行失败:输出失败状态table.row("IS-RETURN", ""+false);table.row("IS-EXCEPTION", ""+true);// 执行失败:输出失败异常信息Throwable cause;Throwable t = (Throwable) throwableVO.getObject();if (t instanceof InvocationTargetException) {cause = t.getCause();} else {cause = t;}if (throwableVO.needExpand()) {table.row("THROW-EXCEPTION", new ObjectView(cause, throwableVO.expandOrDefault()).draw());} else {StringWriter stringWriter = new StringWriter();PrintWriter printWriter = new PrintWriter(stringWriter);try {cause.printStackTrace(printWriter);table.row("THROW-EXCEPTION", stringWriter.toString());}finally {printWriter.close();}}}
	}