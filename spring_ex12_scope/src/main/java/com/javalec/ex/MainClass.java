package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		GenericXmlApplicationContext 클래스에서만 존재하는 메서드인가 보다 => ctx.load("classpath:applicationCTX.xml");
//		ctx.refresh();

		Student student1 = ctx.getBean("student", Student.class);
		System.out.println(student1);

		Student student2 = ctx.getBean("student", Student.class);
		student2.setAge(40);
		student2.setName("홍길자");
		System.out.println(student2);

		System.out.println("student1 => " + student1);
		System.out.println("student2 => " + student2);
		if (student1 == student2) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}
		
		ctx.close();
	}
}
