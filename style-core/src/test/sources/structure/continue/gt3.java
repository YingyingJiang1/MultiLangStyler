import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Contest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			scanner.nextLine();
			int MAX = 311;
			//Queue

			int[][] mask = new int[MAX][MAX];

			int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
			int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

			Set<Integer> curQueue = new HashSet<Integer>();
			curQueue.add(getStatus(MAX / 2, MAX / 2, 0));
			for (int i = 1; i <= k; i++) {
				int next = scanner.nextInt();
				Set<Integer> newQueue = new HashSet<Integer>();
				for (int cur : curQueue) {
					int curDirection = cur & 0x7;
					int curY = (cur >> 3) & 0x1FF;
					int curX = (cur >> 12) & 0x1FF;
					int j = 1;
					while (true) {
						curX += dx[curDirection];
						curY += dy[curDirection];
						mask[curX][curY] = 1;
						if ( j == next) { newQueue.add(getStatus(curX, curY, (curDirection + 1) % 8));
							int newDir = (curDirection - 1) % 8;
							if ( newDir < 0) { newDir = 8 + newDir;
							newQueue.add(getStatus(curX, curY, (newDir) % 8));
							break;
						} else { newQueue.add(getStatus(curX, curY, (newDir) % 8));
							break;
						} j++;
					} else { j++;
					} }
					curQueue = newQueue;
				}

				int res = 0;
				for (int i = 0; i < MAX; i++) {
					for (int j = 0; j < MAX; j++) {
						if (mask[i][j] == 1) res++;
					}
				}
				System.out.println(res);
			}
		}
	}

		public static int getStatus ( int x, int y, int direction){
			int result = 0;
			result = x;
			result = (result << 9) | y;
			result = (result << 3) | direction;
			return result;
		}
	}
