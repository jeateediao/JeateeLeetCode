package 排序;

import java.util.Random;

// 快速排序详解：https://mp.weixin.qq.com/s/8ZTMhvHJK_He48PpSt_AmQ

public class _KuaiPai_快速排序 {

    public static void sort(int[] nums) {
        // 为了避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 对 nums[low..high] 进行切分
        // 使得 nums[low..p-1] <= nums[p] < nums[p+1..high]
        int p = partition(nums, low, high);
        // 去左右子数组进行切分
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    // 对 nums[low..high] 进行切分
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        // 关于区间的边界控制需要格外小心，稍有不慎就会出错
        int i = low + 1;
        int j = high;
        while (i <= j) {
            // 此while循环结束时，恰好 nums[i] > pivot
            while (i < high && nums[i] <= pivot) {
                i++;
            }
            // 此while循环结束时，恰好 nums[j] <= pivot
            while (j > low && nums[j] > pivot) {
                j--;
            }
            // 此时 [low, i) <= pivot && (j, high] > pivot
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }

        swap(nums, low, j);

        return j;
    }

    // 洗牌算法，将输入的数组随机打乱
    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
