public class LIS {

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
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LIS().lengthOfLIS(nums));

    }
}
