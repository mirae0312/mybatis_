package com.kh.student.model.service;

import java.util.List;
import java.util.Map;

import com.kh.student.model.vo.Student;

public interface IStudentService {

	int insertStudent(Student student);

	int insertStudent(Map<String, Object> studentMap); // 추상메소드, 매개변수이름, 타입이 다르기에 문제없음(overloading)

	int selectStudentTotalCount();

	Student selectOneStudent(int no);

	int updateStudent(Student student);
	
	int deleteStudent(int no);
	
	Map<String, Object> selectOneStudentMap(int no);

	List<Student> selectStudentList();

	List<Map<String, Object>> selectStudentMapList();

}
