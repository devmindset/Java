


public class DistinctSubsequences {

    /**
     * Define dp[i][j] as total distinct strings [0,j] of T in [0,i] of S, then there are two cases:
     * 1. dp[i][j] = dp[i-1][j], which means we can find T(0, j) --- [0,j] in S(0, i-1) -- [0,i-1].
     * 2. dp[i][j] = dp[i-1][j] + dp[i-1][j-1] if T[j] = S[i], either we can find [0,j] in [0,i-1], or find [0,j-1] in [0,i-1] with T[i] = S[i].
     *
     * @param S
     * @param T
     * @return
     */
    public static int numDistinct(String s, String t) {

        if (s.length() == 0) return t.length() == 0 ? 1 : 0;
        if (t.length() == 0) return 1;

        // If the T is empty, we have only one way, just delete every character from S
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // If S(i-1) != T(j-1), just replicate the number of ways of previous S, which is dp[i - 1][j]
                // If S(i-1) == T(j-1), we have two independent options, a) same as above, b) remove the same character in both S and T.
                // Add the two independent options due to the counting problems.
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ?
                        dp[i - 1][j - 1] + dp[i - 1][j] :
                        dp[i - 1][j];
            }
        }
        
        for(int i=0;i<(s.length() + 1);i++){
        	for(int j=0;j<(t.length()+1);j++){
        		System.out.print(dp[i][j]+",");
        	}
        	System.out.println();
        }
        
        return dp[s.length()][t.length()];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(numDistinct("aabb","aab"));
	}
    
}


