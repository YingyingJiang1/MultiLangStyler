public class NamingStyleTestB {

	public static int calculateTotalScore(int stuCnt, int bnsPts) {
		int ttlScr = 0;
		int bsScr = 60;

		for (int idx = 0; idx < stuCnt; idx++) {
			int cur = bsScr + bnsPts;
			ttlScr += cur;
		}

		return ttlScr;
	}
}