package 高频;

import java.util.Iterator;

// 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
// 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
// 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]
// 示例：
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
// 输出： [3,9]
public class _16_16_部分排序 {

	public int[] subSort(int[] nums) {
		if (nums.length == 0) {
			return new int[] {-1, -1};
		}
		// 从左扫描到右寻找逆序对（正序：逐渐变大）
		int max = nums[0];
		// 用来记录最右的那个逆序对位置
		int r = -1;
		for (int i = 1; i < nums.length; i++) {
			int v = nums[i];
			if (v >= max) {
				max = v;
			}else {
				r = i;
			}
		}
		
		if (r == -1) {
			return new int[] {-1, -1};
		}
		
		// 从右扫描到左寻找逆序对（正序：逐渐变小）
		int min = nums[nums.length - 1];
		// 用来记录最左的那个逆序对位置
		int l = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int v = nums[i];
			if (v <= min) {
				min = v;
			}else {
				l = i;
			}
		}
		
		return new int[] {l, r};
	}
}
