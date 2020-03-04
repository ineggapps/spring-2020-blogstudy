package com.javalec.e;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		ctx.close();
		/*
		 Spring 3.0 ������ Ȱ���ϴٰ� CGLIB is required to process @Configuration classes Exception �߻�
			��ó: https://java.ihoney.pe.kr/138 [��ϸ�(Honeymon)�� �ڹ�guru]
			external jar ÷�� �� ����
		 * */
	}
}
