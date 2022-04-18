package 高频;

import java.text.SimpleDateFormat;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

public class _75_颜色分类 {

	
	
	// 一个只包含0、1、2的整形数组，要求对它进行【原地】排序
	// 你能想出一个仅使用常数空间的一趟扫描算法吗？
	// 根据题目要求，空间复杂度O(1)，时间复杂度O(n)
	public void sortColors(int[] nums) {
		int i = 0; 				 // 红色指针，用来遍历所有的元素
		int l = 0; 				 // 绿色指针，指向数组左边
		int r = nums.length - 1; // 紫色指针，指向数组右边
		
		// 遇到1: 跳过，红色指针++
		// 遇到0: 跟绿色指针交换值，绿色指针++、红色指针++
		// 遇到2: 跟紫色指针交换值，紫色指针--，再次对红色指针的值进行判断
		while (i <= r) {
			int v = nums[i];
			if (v == 0) {
				swap(nums, i++, l++);
			} else if (v == 1) {
				i++;
			} else {
				swap(nums, i, r--);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
