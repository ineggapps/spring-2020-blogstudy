package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		GenericXmlApplicationContext Ŭ���������� �����ϴ� �޼����ΰ� ���� => ctx.load("classpath:applicationCTX.xml");
//		ctx.refresh();

		Student student1 = ctx.getBean("student", Student.class);
		System.out.println(student1);

		Student student2 = ctx.getBean("student", Student.class);
		student2.setAge(40);
		student2.setName("ȫ����");
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
