public class Recursion {

    String text1, text2;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        return find(text1.length() - 1, text2.length() - 1);
    }

    private int find(int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + find(i - 1, j - 1);
        } else {
            return Math.max(find(i - 1, j), find(i, j - 1));
        }

    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "bce";
        System.out.println(new Recursion().longestCommonSubsequence(text1, text2));
    }

}
