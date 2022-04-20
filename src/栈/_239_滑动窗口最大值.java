package 栈;

import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <1) {
            return null;
        }
        if (k == 1) {
            return nums;
        }
        // 窗口个数
        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        // 遍历数组中的元素，right表示滑动窗口右边界
        for (int right = 0; right < nums.length; right++) {
            // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除
            // 直到队列为空或当前考察元素小于新的队尾元素
            while(!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            // 存储元素下标
            queue.offerLast(right);
            // 计算窗口左侧边界
            int left = right - k + 1;
            // 检查窗口的索引是否合法
            if (left < 0) {
                continue;
            }
            // 检查队头的合法性
            // 当队首元素的下标小于滑动窗口左侧边界left时
            // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
            if (queue.peekFirst() < left) {
                // 队头不合法（失效，不在滑动窗口索引范围内），这也是存索引的原因
                queue.pollFirst();
            }

            // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
            // 意味着窗口形成，此时队首元素就是该窗口内的最大值
            if (right + 1 >= k) {
                maxes[left] = nums[queue.peekFirst()];
            }

        }
        return maxes;
    }

}
