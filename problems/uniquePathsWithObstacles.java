//https://leetcode.com/problems/unique-paths-ii/
class Solution {
	public int uniquePathsWithObstacles(int[][] dp) {
		int m = dp.length, n = dp[0].length;
		if (dp == null || dp[0].length == 0 || dp[0][0] == 1)
			return 0;

		dp[0][0] = 1;

		for (int i = 1; i < m; i++) {
			if (dp[i][0] == 0 && dp[i - 1][0] == 1) {
				dp[i][0] = 1;
			} else
				dp[i][0] = 0;
		}
		for (int j = 1; j < n; j++) {
			if (dp[0][j] == 0 && dp[0][j - 1] == 1)
				dp[0][j] = 1;
			else
				dp[0][j] = 0;
		}
		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++) {
				if (dp[r][c] == 0) {
					dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				} else
					dp[r][c] = 0;
			}
		}
		return dp[m - 1][n - 1];
	}

}