import java.util.*;

public class DynamicProgramMaxiPathRowWise {

    static int n;
    static int[][] mat;
    static long[] dp;

    static long solve(int col, int mask) {

        if (col == n)
            return 0;

        if (dp[mask] != -1)
            return dp[mask];

        long ans = Long.MIN_VALUE;

        for (int row = 0; row < n; row++) {

            if ((mask & (1 << row)) == 0) {

                ans = Math.max(
                    ans,
                    mat[row][col] +
                    solve(col + 1, mask | (1 << row))
                );
            }
        }

        return dp[mask] = ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        dp = new long[1 << n];
        Arrays.fill(dp, -1);

        System.out.println(solve(0, 0));
        sc.close();
    }
}