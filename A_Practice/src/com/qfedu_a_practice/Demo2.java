package com.qfedu_a_practice;

import java.lang.reflect.Constructor;

public class Demo2 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("com.qfedu_a_practice");
		
		Constructor[] allcons = cls.getConstructors();
		
		for (Constructor constructor : allcons) {
			System.out.println(constructor);
			
		}
		System.out.println();
		System.out.println();
		
		Constructor[] cons = cls.getDeclaredConstructors();
		
		for (Constructor constructor : cons) {
			System.out.println(constructor);
			
		}
		System.out.println();
		System.out.println();
		
	}
}
