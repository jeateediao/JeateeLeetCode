package String;

public class _415_字符串相加 {

	public String addStrings(String num1, String num2) {
		
		// 思路：定义两个指针i和j，分别指向num1和num2的末尾，即最低位，同时定义一个变量add维护当前是否有进位，
		// 然后从末尾到开头逐位相加；两个数字位数不同怎么处理？这里可以统一在指针当前下标处于负数的时候返回0，
		// 等价于对位数较短的数字进行了补零操作，这样就可以除去两个数字位数不同的情况的处理
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int add = 0;
		StringBuffer ans = new StringBuffer();
		
		while(i >= 0 || j >= 0 || add != 0) {
			int x = (i >= 0 ? num1.charAt(i) - '0' : 0);
			int y = (j >= 0 ? num2.charAt(j) - '0' : 0);
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i --;
			j --;
		}
		// 计算完成的字符串需要反转过来
		ans.reverse();
		return ans.toString();
		
	}
	
	public String addString2(String num1, String num2) {
		
		StringBuffer ans = new StringBuffer();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int add = 0;
		while (i != 0 || j != 0 || add != 0) {
			int x = ( i >= 0 ) ? num1.charAt(i) - '0' : 0;
			int y = ( j >= 0 ) ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		ans.reverse();
		return ans.toString();
	}
}







