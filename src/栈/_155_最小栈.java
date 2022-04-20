package 栈;

// 设计一个支持push、pop、top操作，并能在常数时间内检索到最小元素的栈
// push(x)          ---- 将元素x推入栈中
// pop()            ---- 删除栈顶的元素
// top()            ---- 获取栈顶元素
// getMin()         ---- 检索栈中的最小元素


// 正常栈   ---->    最小栈

import java.util.Stack;

public class _155_最小栈 {

}

// 1 - 双栈实现
class MinStack {

    /*用来存放正常数据*/
    private Stack<Integer> stack;
    /*用来存放最小数据*/
    private Stack<Integer> minStack;

    /*initialize your data structure here.*/
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        }else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


// 2 - 链表
class MinStack2 {
    private Node head;

    public MinStack2() {
        // 虚拟头节点
        head = new Node(0, Integer.MAX_VALUE, null);
    }

    public void push(int val) {
        // 插入最前边
        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        public int val;
        public int min;
        public Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}