package com.javalec.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		//#1. .properties������ �ҷ��� Ȱ���ϱ�
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		}
		catch(IOException e) {}
		
		//#2. Ŭ������ bean��ü�� �����Ͽ� �������� (Ŭ���� �ȿ��� Environment ��ü Ȱ��)
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection",AdminConnection.class);
		System.out.println("adminID:" + adminConnection.getAdminId());
		System.out.println("adminPW:" + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}
}
