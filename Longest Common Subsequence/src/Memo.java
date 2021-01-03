public class Memo {

    String text1, text2;
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return find(text1.length() - 1, text2.length() - 1);
    }

    private int find(int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] =  1 + find(i - 1, j - 1);
        } else {
            memo[i][j] =  Math.max(find(i - 1, j), find(i, j - 1));
        }
        return memo[i][j];

    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "bce";
        System.out.println(new Memo().longestCommonSubsequence(text1, text2));
    }
}
