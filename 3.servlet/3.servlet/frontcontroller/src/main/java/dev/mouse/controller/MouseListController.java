package dev.mouse.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

//@WebServlet("/mice")
public class MouseListController implements Controller{
	private MouseService mouseService = new MouseService();

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		MouseService mouse = new MouseService();
//		List<Mouse> mice = mouse.findAll();
//		request.setAttribute("mice", mice);
//
//		final String path = "/WEB-INF/mouseList.jsp";
//	
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
//		
//	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Mouse> mice = mouseService.findAll();
		request.setAttribute("mice", mice);
		
		final String path = "/WEB-INF/mouseList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
}
