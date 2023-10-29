package dev.mouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

//@WebServlet("/mice/add")
public class MouseInsertController implements Controller {
	private MouseService mouseService = new MouseService();

//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String country = request.getParameter("country");
//		String address = request.getParameter("address");
//		
//		Mouse mouse = new Mouse(name, country, address);
//		MouseService mouseService = new MouseService();
//		mouseService.add(mouse);
//		System.out.println(mouse.toString());
//		response.sendRedirect("/frontcontroller/mice");
//		
//	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		Mouse mouse = new Mouse(name, country, address);
		mouseService.add(mouse);
		response.sendRedirect("/frontcontroller/mouse-api/mice");
	}
	
}
