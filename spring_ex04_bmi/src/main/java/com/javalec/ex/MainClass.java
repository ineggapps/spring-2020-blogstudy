package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLocation = "classpath:com/javalec/ex/applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		try {
			MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
			myInfo.getInfo();
		} finally {
			ctx.close();
		}
	}
}
