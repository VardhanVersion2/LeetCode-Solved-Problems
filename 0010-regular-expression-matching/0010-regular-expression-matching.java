class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] means if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Base case: dealing with patterns like a*, a*b*, or .* that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentP = p.charAt(j - 1);
                
                if (currentP == '*') {
                    // Case 1: Count '*' and its preceding element as 0 occurrences
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Count '*' as 1 or more occurrences
                    char prevP = p.charAt(j - 2);
                    if (prevP == s.charAt(i - 1) || prevP == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // If current pattern character is a letter or '.'
                    if (currentP == s.charAt(i - 1) || currentP == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}