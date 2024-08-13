package com.excelr.firstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.firstapp.model.Student;
import com.excelr.firstapp.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentReposiotry;
	
	public Student addStudent(Student s1) {
		return studentReposiotry.save(s1);
	}

	public Student getStudent(int studentRollNo) {
//		Optional<Student> optionalStudent= studentReposiotry.findById(studentRollNo);
//		Student student=null;
//		if(optionalStudent.isPresent())
//		{
//			student=optionalStudent.get();
//		}
//		
//		return student;
		
		return studentReposiotry.findById(studentRollNo).get();
	}

	public List<Student> getStudentsByStudentName(String sname) {
		
		return studentReposiotry.findByName(sname);
	}

	public List<Student> getStudentsByPercentage() {
		return studentReposiotry.findStudentByPercentage();
	}

	public List<Student> getStudentsByClientPercentage(double per) {
		return studentReposiotry.findByPerGreaterThan(per);
	}

	public List<Student> getStudentsPercentageBetween70To90() {
		return studentReposiotry.findByPerBetween(70,90);
	}

	public void deleteStudent(int rno) {
		studentReposiotry.deleteById(rno);
		
	}

	public void deleteStudentByName(String sname) {
		studentReposiotry.deleteStudentByName(sname);	
	}

	public void updateStudent(int rno, Student newStudentValues) {
		Student currentDbValues=studentReposiotry.findById(rno).get();
		currentDbValues.setEmail(newStudentValues.getEmail());
		currentDbValues.setName(newStudentValues.getName());
		currentDbValues.setPer(newStudentValues.getPer());
		studentReposiotry.save(currentDbValues);
	}

	public List<Student> getAllStudents() {
		return studentReposiotry.findAll();
	}

}