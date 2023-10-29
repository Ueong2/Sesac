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

@WebServlet("/mice/add")
public class MouseInsertController implements Controller{
	
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");

		Mouse newmem = new Mouse(name, country, address);
		
		MouseService mouse = new MouseService();
		mouse.add(newmem);

		response.sendRedirect("/frontcontroller/mice");
		
//		List<Mouse> mice = mouse.findAll();
//		request.setAttribute("mice", mice);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mouseList.jsp");
//		dispatcher.forward(request, response);
}
