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

			if (h == 0 && w == 0)

				break;

			System.out.println();

			for (int i = 0; i < h; i++) {

				for (int j = 0; j < w; j++) {

					if ((i + j) % 2 == 0) {

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