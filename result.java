	import java.util.Scanner;



	public class Chessboard {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			while (true) {

				int H = sc.nextInt();

				int W = sc.nextInt();

				if (H == 0 && W == 0) break;

				for (int I = 0; I < H; I++) {

					for (int J = 0; J < W; J++) {

						if ((I + J) % 2 == 0) {

							System.out.print("#");

						} else {

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