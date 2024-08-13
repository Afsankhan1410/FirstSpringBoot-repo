package com.excelr.firstapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.firstapp.model.Student;
import com.excelr.firstapp.service.StudentService;

@RestController
public class StudentController {
	
	//RequestParam
	//PathVariable
	//RequestBody
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/addStudent")
	public String addStudent()
	{
		Student s1=new Student();
		s1.setName("Ben");
		s1.setPer(88.5);
		s1.setEmail("ben@gmail.com");
		
		studentService.addStudent(s1);
		return "Record Inserted Successfully";
	}
	
	@PostMapping("/addStudentByRequestParam")
	public Student addStudentByRequestParam(@RequestParam("studname") String sname,
			@RequestParam("studper") double per,
			@RequestParam("studemail") String semail)		
	{
		Student s1=new Student();
		s1.setName(sname);
		s1.setPer(per);
		s1.setEmail(semail);	
		return studentService.addStudent(s1);	
	}
	
	
	@PostMapping("/addStudentByPathVariable/{studname}/{studper}/{studemail}")
	public Student addStudentByPathVariable(@PathVariable("studname") String sname,
			@PathVariable("studper") double per,
			@PathVariable("studemail") String semail)		
	{
		Student s1=new Student();
		s1.setName(sname);
		s1.setPer(per);
		s1.setEmail(semail);	
		return studentService.addStudent(s1);	
	}
	
	
	@PostMapping("/addStudentByRequestBody")
	public Student addStudentByRequestBody(@RequestBody Student student)		
	{
	return studentService.addStudent(student);	
	}
	
	@GetMapping("/getStudentByRno/{rno}")  //Single Object
	public Student getStudentByRno(@PathVariable("rno") int studentRollNo)
	{
		return studentService.getStudent(studentRollNo);
	}
	
	@GetMapping("/getStudentsByStudentName/{sname}")
	public List<Student> getStudentsByStudentName(@PathVariable("sname") String sname)
	{
		return studentService.getStudentsByStudentName(sname);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudentsByPercentageAbove85")
	public List<Student> getStudentsByPercentage()
	{
		return studentService.getStudentsByPercentage();
	}
	
	@GetMapping("/getStudentsByClientPercentage/{cper}")
	public List<Student> getStudentsByClientPercentage(@PathVariable("cper") double per)
	{
		return studentService.getStudentsByClientPercentage(per);
	}
	
	@GetMapping("/getStudentsPercentageBetween70To90")
	public List<Student> getStudentsPercentageBetween70To90()
	{
		return studentService.getStudentsPercentageBetween70To90();
	}
	
//	@DeleteMapping("/deleteStudent/{rno}")
//	public String deleteStudent(@PathVariable("rno") int rno)
//	{
//		studentService.deleteStudent(rno);
//		return "Record Deleted";
//	}
	
	@DeleteMapping("/deleteStudentByName/{sname}")
	public String deleteStudentByName(@PathVariable("sname") String sname)
	{
		studentService.deleteStudentByName(sname);
		return "Record Deleted";
	}
	
	@PutMapping("/updateStudent/{rno}")
	public String updateStudent(@RequestBody Student newStudentValues, @PathVariable("rno") int rno)
	{
		studentService.updateStudent(rno,newStudentValues);
		return "Record Updated";
	}
	

}