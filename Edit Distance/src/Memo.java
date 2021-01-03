public class Memo {
    // increase i (index of word1) and j (index of word2) are increasing.

    String word1, word2;
    int[][] memo; // or using a map

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return findDistance(0, 0);
    }

    private int findDistance(int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        // i, j may out of bound
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = findDistance(i + 1, j + 1);
        } else {
            // add, delete, replace, all on word1
            int add = 1 + findDistance(i, j + 1);
            int delete = 1 + findDistance(i + 1, j);
            int replace = 1 + findDistance(i + 1, j + 1);
            memo[i][j] =  Math.min(add, Math.min(delete, replace));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new Recursion().minDistance(word1, word2));

    }
}
