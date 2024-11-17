package pair2;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return dfs(piles, 0, 1, suffixSum, memo);
    }

    private int dfs(int[] piles, int i, int m, int[] suffixSum, int[][] memo) {
        if (i == piles.length) {
            return 0;
        }
        if (2 * m >= piles.length - i) {
            return suffixSum[i];
        }
        if (memo[i][m] != 0) {
            return memo[i][m];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= 2 * m; j++) {
            min = Math.min(min, dfs(piles, i + j, Math.max(m, j), suffixSum, memo));
        }
        int res = suffixSum[i] - min;
        memo[i][m] = res;
        return res;
    }
}
