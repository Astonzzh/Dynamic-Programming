public class RDE {

    public int maxEnvelopes(int[][] envelopes) {
        quick_sort(envelopes, 0, envelopes.length - 1);
        int[] second = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            second[i] = envelopes[i][1];
        }
        return lengthOfLIS(second);
    }

    private void quick_sort(int[][] a, int l, int r)
    {
        if (l < r) {
            int q = partition(a, l, r);
            quick_sort(a, l, q - 1);
            quick_sort(a, q + 1, r);
        }
    }

    private void swap(int[][] a, int i, int k) {
        int temp = a[i][0];
        a[i][0] = a[k][0];
        a[k][0] = temp;

        temp = a[i][1];
        a[i][1] = a[k][1];
        a[k][1] = temp;
    }

    private static int get_value(int[][] a, int k) {
        return 10000 * a[k][0] - a[k][1];
    }

    private int partition(int[][] a, int l, int r) {
        int first = get_value(a, r);
        int i = l - 1;
        for (int k = l; k <= r - 1; k++) {
            if (get_value(a, k) <= first) {
                i = i + 1;
                swap(a, i, k);
            }
        }
        swap(a, i + 1, r);
        return i+1;

    }

    int lengthOfLIS(int[] nums) {
        // dp[i] is the length of longest increasing subsequence end with nums[i]
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i <nums.length; i++) {
            int max = 0;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            if (max != 0) {
                dp[i] = max + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] a = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        new RDE().quick_sort(a, 0, 3);
        for (int[] ints : a) {
//            System.out.println(ints[0] + " " + ints[1]);
        }
        System.out.println(new RDE().maxEnvelopes(a));
    }
}
