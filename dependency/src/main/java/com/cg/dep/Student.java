package com.cg.dep;

public class Student {
	
	private String StudentName;
	private int id;
	

	public void setId(int id) {
		this.id = id;
	}

	public void display() 
	{
		System.out.println("The student name is "+StudentName+" and this is id "+id);
	}
	
	public void setStudentName(String name) 
	{
		this.StudentName = name;
	}

}
