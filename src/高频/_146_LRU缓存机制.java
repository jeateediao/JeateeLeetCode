package 高频;

import com.djt.Asserts;
import 高频.LRUCache;

public class _146_LRU缓存机制 {

	//哈希表 + 双向链表
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);	// 缓存容量 2
		cache.put(1, 1);
		cache.put(2, 2);
		Asserts.test(cache.get(1)== 1); 	// 返回 1
		cache.put(3, 3);					// 该操作会使得密钥 2 作废
		Asserts.test(cache.get(2) == -1); 	// 返回 -1，未找到
		cache.put(4, 4);				 	// 该操作会使得密钥 1 作废
		Asserts.test(cache.get(1) == -1);	// 返回 -1, 未找到
		Asserts.test(cache.get(3) == 3); 	// 返回 3
		Asserts.test(cache.get(4) == 4); 	// 返回 4
	}
}
