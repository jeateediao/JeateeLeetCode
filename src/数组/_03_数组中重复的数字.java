package 数组;

import java.util.HashSet;
import java.util.Set;

public class _03_数组中重复的数字 {
	// 方法一：哈希表/Set
	// 时间复杂度：O(n)
	// 空间复杂度：O(n)
	public int findRepeatNumber01(int[] nums) {
		Set<Integer> dic = new HashSet<Integer>();
		for(int num : nums) {
			if (dic.contains(num)) {
				return num;
			}
			dic.add(num);
		}
		return -1;
    } 
	
	
	// 方法二：原地交换
	// 题目说 在一个长度为n的数组nums里的所有数字都在0~n-1的范围内，说明数组元素的索引和值是一对多的关系
	// 遍历中，第一次遇到数字x时，将其交换至索引x处；而当第二次遇到数字x时，一定有nums[x]=x，此时即可得到一组重复的数字。
	
	public int findRepeatNumber02(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			// 此时数字已在对应索引位置，无需交换，跳过；
			if (nums[i] == i) {
				i++;
				continue;
			}
			// 代表索引i处的元素和索引nums[i]处的元素值都为nums[i]，即找到一组重复值，返回nums[i]
			if (nums[i] == nums[nums[i]]) {
				return nums[i];
			}
			// 否则交换索引为i和nums[i]的元素值，将此数字交换至对应索引位置。
			int tmp = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tmp;
		}
		return -1;
    } 
	
}
