package com.inegg.spring;

public class MainClass {
	public static void main(String[] args) {
		Calculation c = new Calculation();
		c.setFirstNum(10);
		c.setSecondNum(2);
		c.add();
		c.sub();
		c.multi();
		c.div();
	}
}
