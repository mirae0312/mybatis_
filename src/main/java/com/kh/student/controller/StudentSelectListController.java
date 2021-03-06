package com.kh.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.common.MethodNotAllowedException;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class StudentSelectListController extends AbstractController {
	
	private IStudentService studentService;
	
	public StudentSelectListController(IStudentService studentService) {
		super();
		this.studentService = studentService;
		System.out.println("[StudentSelectListController] studentService = " + studentService);
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MethodNotAllowedException {
		
		// 1. 업무로직
		List<Student> list = studentService.selectStudentList();
		System.out.println("[StudentSelectListController] list = " + list);
		
		List<Map<String, Object>> maplist = studentService.selectStudentMapList();
		System.out.println("[StudentSelectListController] maplist = " + maplist);
		
		// 2. jsp 위임
		request.setAttribute("list", list);
		request.setAttribute("maplist", maplist);
		
		return "student/selectList";
	}

	
}
