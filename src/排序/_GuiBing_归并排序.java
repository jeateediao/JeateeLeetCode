package 排序;

public class _GuiBing_归并排序 {

    // 用于辅助合并有序数组
    private static int[] temp;

    public static void sort(int[] nums) {
        // 先给辅助数组开辟内存空间
        temp = new int[nums.length];
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int low, int high) {
        if (low == high) {
            // 单个元素不用排序
            return;
        }
        // 这样写是为了防止溢出，效果等同于 (high + low) / 2
        int mid = low + (high - low) / 2;
        // 先对左半部分数组 nums[low..mid] 进行排序
        sort(nums, low, mid);
        // 再对右半部分数组 nums[mid..high] 进行排序
        sort(nums, mid + 1, high);
        // 将两部分有序数组合并成一个有序数组
        merge(nums, low, mid, high);
    }

    // 将 nums[low..mid] 和 nums[mid + 1, high] 这两个有序数组合并成一个有序数组
    private static void merge(int[] nums, int low, int mid, int high) {
        // 先把 nums[low..high] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        // 数组双指针技巧，合并两个有序数组
        int leftStart = low;
        int rightStart = mid + 1;
        for (int p = low; p <= high; p++) {
            if (leftStart == mid + 1) {
                // 左半边数组已经全部被合并
                nums[p] = temp[rightStart];
                rightStart++;
            }else if(rightStart == high + 1) {
                // 右半边数组已经全部被合并
                nums[p] = temp[leftStart];
                leftStart++;
            }else if (temp[leftStart] > temp[rightStart]) {
                nums[p] = temp[rightStart];
                rightStart++;
            } else {
                nums[p] = temp[leftStart];
                leftStart++;
            }
        }
    }
}
