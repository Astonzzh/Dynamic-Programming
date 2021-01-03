public class DP_Table {

    String word1, word2;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        dp = new int[word1.length() + 1][word2.length() + 1];
        return findDistance();
    }

    private int findDistance() {
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // add, delete, replace, all on word1
                    int add = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] =  Math.min(add, Math.min(delete, replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }

    public static void main(String[] args) {
        String word1 = "bcd";
        String word2 = "abc";
        System.out.println(new Recursion().minDistance(word1, word2));
    }
}
