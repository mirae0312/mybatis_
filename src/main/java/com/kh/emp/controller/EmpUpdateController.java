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

public class EmpUpdateController extends AbstractController {

	private EmpService empService;

	public EmpUpdateController(EmpService empService) {
		this.empService = empService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MethodNotAllowedException {
		// 1. 사용자 입력값 : empId
		Map<String, Object> param = new HashMap<>();
		param.put("empId",request.getParameter("empId"));
		System.out.println("[EmpUpdateController] param = " + param);
		
		// 2. 업무로직 : 사원1명정보
		Map<String, Object> empMap = empService.selectOneEmpMap(param);
		System.out.println("[EmpUpdateController] empMap = " + empMap);
		
		// 직급코드 목록
		List<Map<String, String>> jobCodeList = empService.selectJobList();
		System.out.println("[EmpUpdateController] jobCodeList = " + jobCodeList);
		// 부서코드 목록
		List<Map<String, String>> deptList = empService.selectDeptList();
		System.out.println("[EmpUpdateController] deptList = " + deptList);
		
		// 3. jsp위임
		request.setAttribute("empMap", empMap);
		request.setAttribute("jobList", jobCodeList);
		request.setAttribute("deptList", deptList);
		
		return "emp/empUpdate";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MethodNotAllowedException {
		// 1. 사용자 입력값
		Map<String, Object> param = new HashMap<>();
		param.put("empId", request.getParameter("empId"));
		param.put("jobCode", request.getParameter("jobCode"));
		param.put("deptCode", request.getParameter("deptCode"));
		System.out.println("[EmpUpdateController] param = " + param);
		
		// 2. 업무로직 : 수정
		int result = empService.updateEmp(param);
		System.out.println("[EmpUpdateController] result = " + result);
		
		return "redirect:/emp/empUpdate.do?empId=" + param.get("empId");
	}
	
	
}
