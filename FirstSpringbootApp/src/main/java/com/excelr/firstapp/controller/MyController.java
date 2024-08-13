package com.excelr.firstapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.firstapp.model.Student;

@Controller
public class MyController {
	

	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Welcome to Afternoon Batch of ExcelR";
	}
	
	@RequestMapping("/getSingleStudent")
	public Student getSingleStudent()
	{
		Student s1=new Student();
		s1.setRno(1);
		s1.setName("Alice");
		s1.setPer(78.5);
		return s1;
	}
	
	@RequestMapping("/getMultipleStudent")
	public List<Student> getMultipleStudent()
	{
		List<Student> students=new ArrayList();
		
		Student s1=new Student();
		s1.setRno(1);
		s1.setName("Alice");
		s1.setPer(78.5);
		
		Student s2=new Student();
		s2.setRno(2);
		s2.setName("Ben");
		s2.setPer(88.5);
		
		students.add(s1);
		students.add(s2);
		return students;
	}
	
	
}