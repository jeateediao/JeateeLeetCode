package 高频;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	
	private Map<Integer, Node> map;
	private int capacity;
	// 虚拟头节点
	private Node first;
	// 虚拟尾节点
	private  Node last;
	
	public LRUCache(int capacity) {
		map = new HashMap<>(capacity);
		first = new Node();
		last = new Node();
		first.next = last;
		last.prev = first;
		
		this.capacity = capacity;
	}
	
	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		// 删除节点
		removeNode(node);
		// 把最近访问的节点添加到头虚拟节点后边
		addAfterFirst(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node != null) {
			node.value = value;
			removeNode(node);
			addAfterFirst(node);
		}else {
			// 添加一对新的key-value
			if (map.size() == capacity) {
				// 淘汰最近最少使用的node
				Node lastNode = map.remove(last.prev.key); 	 // 1.删除Hash表里的key
				removeNode(lastNode);						 // 2.删除双向链表最后一个node
			}
			
			// 1.添加新节点到Hash表
			Node newNode = new Node(key, value);
			map.put(key, newNode);
			// 2.添加新节点到双向链表头节点
			addAfterFirst(newNode);
		}
	}
	
	// 从双向链表中删除node节点
		private void removeNode(Node node) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		
		// 将node节点插入到first节点的后边
		private void addAfterFirst(Node node) {
			// node 与 first.next
			node.next = first.next;
			first.next.prev = node;
			
			// node 与 first
			first.next = node;
			node.prev = first;
		}
	
	
	private static class Node {
		public int key;
		public int value;
		public Node prev;
		public Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		// 空的构造方法，给虚拟头节点使用
		public Node() {}

	}
}
