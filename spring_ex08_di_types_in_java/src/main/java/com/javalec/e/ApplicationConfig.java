package com.javalec.e;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("¼ö¿µ");
		hobbys.add("¿ä¸®");

		Student student = new Student("È«±æµ¿", 20, hobbys);
		student.setHeight(198);
		student.setWeight(90);
		return student;
	}

	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("µ¶¼­");
		hobbys.add("À½¾Ç°¨»ó");

		Student student = new Student("È«±æ¼ø", 18, hobbys);
		student.setHeight(170);
		student.setWeight(55);
		return student;
	}
}
