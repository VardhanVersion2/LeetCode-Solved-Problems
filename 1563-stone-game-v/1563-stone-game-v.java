import java.util.Arrays;

public class Solution {
    private int[][] memo;
    private int[] pref;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }

        return dp(0, n - 1);
    }

    private int dp(int i, int j) {
    
        if (i == j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxScore = 0;

        for (int k = i; k < j; k++) {
            int leftSum = pref[k + 1] - pref[i];
            int rightSum = pref[j + 1] - pref[k + 1];

            if (leftSum < rightSum) {
            
                maxScore = Math.max(maxScore, leftSum + dp(i, k));
            } else if (leftSum > rightSum) {
            
                maxScore = Math.max(maxScore, rightSum + dp(k + 1, j));
            } else {

                int chooseLeft = leftSum + dp(i, k);
                int chooseRight = rightSum + dp(k + 1, j);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }

        return memo[i][j] = maxScore;
    }
}
