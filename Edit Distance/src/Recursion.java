public class Recursion {

    String word1, word2;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return findDistance(0, 0);
    }

    private int findDistance(int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return findDistance(i + 1, j + 1);
        }
        // add, delete, replace, all on word1
        int add = 1 + findDistance(i, j + 1);
        int delete = 1 + findDistance(i + 1, j);
        int replace = 1 + findDistance(i + 1, j + 1);
        return Math.min(add, Math.min(delete, replace));
    }

    public static void main(String[] args) {
        String word1 = "bcd";
        String word2 = "abc";
        System.out.println(new Recursion().minDistance(word1, word2));
    }
}
