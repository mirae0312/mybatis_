package com.kh.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentDao implements IStudentDao {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		// namespace.tagId, 정상적으로 반환됬다면 1
		return session.insert("student.insertStudent", student); 
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> studentMap) {
		// TODO Auto-generated method stub
		return session.insert("student.insertStudentMap", studentMap); // 아이디값이 겹치면안됨
	}

	@Override
	public int selectStudentTotalCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("student.selectStudentTotalCount");
	}

	@Override
	public Student selectOneStudent(SqlSession session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("student.selectOneStudent", no);
	}

	@Override
	public int updateStudent(SqlSession session, Student student) {
		// TODO Auto-generated method stub
		return session.update("student.updateStudent", student);
	}
	
	@Override
	public int deleteStudent(SqlSession session, int no) {
		// TODO Auto-generated method stub
		return session.delete("student.deleteStudent", no);
	}
	
	@Override
	public Map<String, Object> selectOneStudentMap(SqlSession session, int no) {
		return session.selectOne("student.selectOneStudentMap", no);
	}

	/**
	 * selectList는 조회된 행이 없는 경우에도 null을 리턴하지 않는다.
	 * 빈 list객체를 리턴한다.
	 */
	@Override
	public List<Student> selectStudentList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("student.selectStudentList");
	}

	@Override
	public List<Map<String, Object>> selectStudentMapList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("student.selectStudentMapList");
	}



}
