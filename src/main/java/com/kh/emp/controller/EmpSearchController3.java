package com.kh.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.common.MethodNotAllowedException;
import com.kh.emp.model.service.EmpService;

/**
 * 
 * interface - 구현클래스
 * 1. IStudentService - StudentService
 * 2. StudentService - StudentServiceImpl
 *
 */
public class EmpSearchController3 extends AbstractController {

	private EmpService empService;

	public EmpSearchController3(EmpService empService) {
		this.empService = empService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MethodNotAllowedException {
		// 1. 사용자입력값 처리
		// 반복접근 가능한 객체 : T[], List<T>, Set<T>, Map<K, V>
		Map<String, Object> param = new HashMap<>();
		param.put("jobCode", request.getParameterValues("jobCode"));
		param.put("deptCode", request.getParameterValues("deptCode"));
		System.out.println("[EmpSearchController3] param = " + param);
		
		// 2. 업무로직
		// 직급코드 - 직급명 조회
		List<Map<String, String>> jobList = empService.selectJobList();
		System.out.println("[EmpSearchController3] jobList = " + jobList);
		
		List<Map<String, String>> deptList = empService.selectDeptList();
		System.out.println("[EmpSearchController3] deptList = " + deptList);
		
		// 검색
		List<Map<String, Object>> list = empService.search3(param);
		System.out.println("[EmpSearchController3] list = " + list);
		
		// 3. jsp 위임
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("list", list);
		
		return "emp/search3";
	}

	
}
