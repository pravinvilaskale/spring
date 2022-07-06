package com.cg.dep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student obj = new Student();
		
		obj.display();
		
		obj.setStudentName("Pravin");
		
		obj.display();
		
	}

}
