package first_java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] dp = new int[n + 1][k + 1];
		System.out.println(solve(n, k, dp));
	}

	public static int solve(int n, int k, int[][] dp) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = -1;
			}
		}
		int res = inversion(n, k, dp);
		return res % 10000;
	}

	public static int inversion(int n, int k, int[][] dp) {
		if (dp[n][k] != -1) {
			return dp[n][k];
		}
		if (k == 0) {
			dp[n][k] = 1;
			return 1;
		}
		if (n == 0) {
			dp[n][k] = 0;
			return 0;
		}
		int sum = 0;
		for (int j = 0; j < n && k - j >= 0; j++) {		
				sum += inversion(n - 1, k - j, dp);			
		}
		dp[n][k] = sum;
		return sum;

	}
}
