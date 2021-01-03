public class DP_Table {
    String text1, text2;
    int[][] dp;
    // dp[i][j] is the length of longest common subsequence of text1[0..i] and text2[0..j]
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int l1 = text1.length();
        int l2 = text2.length();
        dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "bce";
        System.out.println(new DP_Table().longestCommonSubsequence(text1, text2));
    }
}
