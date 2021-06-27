package com.djt;

import com.djt.Times.Task;

public class Main {

	/*
	 * 0 1 2 3 4 5 6 7  ....
	 * 0 1 1 2 3 5 8 13 ....  
	 * 求第n个斐波那契数
	 */
	
	public static int fib1(int n) {
		if(n <= 1) {
			return n;
		}
		return fib1(n - 1) + fib1(n - 2);
	}
	
	
	private static int fib2(int n) {
		// TODO Auto-generated method stub
		if (n <= 1) {
			return n;
		}
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Times.test("fib1", new Task() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib1(40));
			}
		});

		Times.test("fib2", new Task() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println(fib2(40));
			}
		});
	}

}
