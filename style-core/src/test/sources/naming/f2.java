public class NamingStyleTestB {

	public static int calculateTotalScore(int stu_cnt, int bns_pts) {
		int ttl_scr = 0;
		int bs_scr = 60;

		for (int idx = 0; idx < stu_cnt; idx++) {
			int cur = bs_scr + bns_pts;
			ttl_scr += cur;
		}

		return ttl_scr;
	}
}