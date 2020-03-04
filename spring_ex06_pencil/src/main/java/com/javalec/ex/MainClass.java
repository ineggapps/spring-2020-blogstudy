package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String contextLocation="classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(contextLocation);
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		ctx.close();
	}
}
