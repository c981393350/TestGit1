package com.qfedu_a_practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过Class类对象获取当前类的所有构造方法
 * @author 刘晓磊
 *
 */
public class GetConstructorObject {
	public static void main(String[] args) 
			throws ClassNotFoundException, NoSuchMethodException, 
			SecurityException, InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException {
		/*
		 * 加载需要使用的.class文件 获取Class对象
		 * 是JVM通过包名.类名找到对应的Java文件，把这个Java文件对应.class加载带内存的【代码】
		 */
		Class cls = Class.forName("com.qfedu_a_practice.Person");
		
		/*
		 * Constructor[] getConstructors();
		 * 获取当前类内所有非私有化的构造方法
		 */
		Constructor[] allCons = cls.getConstructors();
		
		for (Constructor constructor : allCons) {
			System.out.println(constructor);
		}
		System.out.println();
		System.out.println();
		/*
		 * 暴力反射
		 * Constructor[] getDeclaredConstructors();
		 * 获取当类的所有构造方法，包括私有化方法
		 */
		Constructor[] cons = cls.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
		System.out.println();
		System.out.println();
	
		/*
		 * Constructor getConstructor(Class... parameterTypes);
		 * 根据指定参数获取对应的非私有化构造方法
		 * Class... 不定长参数列表，需要的数据类型都是Class类型，但是参数的个数不受限制
		 * 如果要获取一个类的Class对象，这里通常采用 数据类型.class
		 * 例如:
		 * 		int.class ==> Integer.class
		 * 		String.class == java.lang.String
		 */
		Constructor nullCon = cls.getConstructor(null);
		System.out.println(nullCon);
		
		Constructor intCon = cls.getConstructor(int.class);
		System.out.println(intCon);
		
		Constructor intAndStringCon = cls.getConstructor(int.class, String.class);
		System.out.println(intAndStringCon);
		
		/*
		 * 通过暴力反射来获取指定参数类型的私有化构造方法	
		 * Constructor getDeclaredConstructor(Class... paramterTypes);
		 */
		Constructor stringCon = cls.getDeclaredConstructor(String.class);
		System.out.println(stringCon);
		
		System.out.println();
		System.out.println();
		/*
		 * 已经获取了对应Constructor类对象，就要考虑使用的问题
		 * Object newInstance(Object... initargs);
		 * 调用构造方法，需要传入指定的初始化参数，数据类型不统一，所以采用Object数据类型
		 * 数据个数页无法确定，所以采用不定长参数
		 */
		Person p1 = (Person) nullCon.newInstance(null);
		System.out.println(p1.test);
		
		Person p2 = (Person) intAndStringCon.newInstance(1, "Hello World");
		System.out.println(p2.getName());
		System.out.println(p2.getId());
		
		/*
		 * 给予私有化构造方法访问权限
		 * setAccessible(boolean access);
		 */
		stringCon.setAccessible(true);
		Person p3 = (Person) stringCon.newInstance("你猜能不能用？");
		System.out.println(p3.getName());
		
	}
}
