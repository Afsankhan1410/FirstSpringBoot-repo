package com.excelr.firstapp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.excelr.firstapp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

//	@Query(value="select * from Student where name like ?1",nativeQuery = true)
//	List<Student> findStudentByStudentName(String studname);
	
	List<Student> findByName(String x);
	
	@Query(value="select * from Student where per>=85",nativeQuery = true)
	List<Student> findStudentByPercentage();
	
	
//	@Query(value="select * from Student where per>=?1",nativeQuery = true)
//	List<Student> findStudentByClientPercentage(double per);
	
	List<Student> findByPerGreaterThan(double a);
	
//	@Query(value="select * from Student where per>=70 and per<=90",nativeQuery = true)
//	List<Student> findStudentByPercentageBetween70To90();
	
	List<Student> findByPerBetween(double a, double z);
	
	@Modifying
	@Query (value="delete from Student where name = ?1",nativeQuery = true)
	void deleteStudentByName(String sname);
}