package com.qfedu_a_practice;

public class Demo1 {
	//成员变量 Field
	private int id;
	private String name;
	
	public int test;
	public static int testStatic = 10;
	
	//构造方法 Constructor
	public Demo1() {}
	
	public Demo1(int id) {
		this.id = id;
	}
	
	public Demo1(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Demo1(String name) {
		this.name = name;
	}
	
	
	//成员方法 Method
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void game() {
		System.out.println("大吉大利，腾讯倒闭");
	}
	
	public void game(String name) {
		System.out.println("玩" + name);
	}
	
	private void testPrivate() {
		System.out.println("类内私有化成员方法!!!");
	}
}

