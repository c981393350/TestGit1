package com.qfedu_a_practice;

public class Demo4 {
	public static void main(String[] args) {
		System.out.println(new Demo4().test());
	}
	static int test() {
		int x= 1;
		try {
			return x;
		} finally {
			x++;
		}
		
	}
}
