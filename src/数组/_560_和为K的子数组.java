package 数组;

public class _560_和为K的子数组 {
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
               // 子数组 nums[j..i-1] 的元素和

            }
        }


    }



}
