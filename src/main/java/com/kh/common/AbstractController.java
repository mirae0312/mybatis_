package com.kh.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {

	public String doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, MethodNotAllowedException
	{
		throw new MethodNotAllowedException("GET");
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MethodNotAllowedException
	{
		throw new MethodNotAllowedException("POST");
	}
}
