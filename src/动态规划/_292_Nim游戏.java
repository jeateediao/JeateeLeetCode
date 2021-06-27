package 动态规划;

public class _292_Nim游戏 {

	public boolean canWinNim(int n) {
		if (n <= 3) return true;
		if (n == 4) return false;
		boolean dp[] = new boolean[n + 1];
		dp[1] = true;
		dp[2] = true;
		dp[3] = true;
		for (int i = 4; i <= n; i++) {
			if (canWinNim(i - 1)&&canWinNim(i-2)&&canWinNim(i-3)) {
				return false;
			}else {
				dp[i] = true;
			}
		}
		return dp[n];
	}
	
}
