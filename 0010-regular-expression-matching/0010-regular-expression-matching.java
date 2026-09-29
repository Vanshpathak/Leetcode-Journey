class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] means s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty pattern matches empty text
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, or a*b*c* matching empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);
                
                if (pChar == '*') {
                    // Case 1: Match zero occurrences of the char before '*'
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match one or more occurrences if characters match
                    char prevPChar = p.charAt(j - 2);
                    if (prevPChar == '.' || prevPChar == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pChar == '.' || pChar == s.charAt(i - 1)) {
                    // Direct character match or '.'
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}