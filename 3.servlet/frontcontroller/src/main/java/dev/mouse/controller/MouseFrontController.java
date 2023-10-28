package dev.mouse.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.service.MouseService;

// 모든 HTTP 요청을 전달받은 유일한 서블릿
@WebServlet("/mouse-api/*")
public class MouseFrontController extends HttpServlet {
	/*
	 * 각각의 하위 controller의 url 정보를 알고 있어야 함. 
	 * Mouse 등록 요청 
	 * Mouse 조회 요청
	 */
	private Map<String, Controller> mappedControllerMap = new HashMap<>();
	
	public MouseFrontController() {
		mappedControllerMap.put("/mice", new MouseListController()); // 조회 요청
		mappedControllerMap.put("/mice/add", new MouseInsertController()); // 등록 요청
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통 처리 로직
		request.setCharacterEncoding("UTF-8");

		//String url = request.getRequestURI();
		//String contextPath = request.getContextPath();
		String pathInfo = request.getPathInfo();
		
		Controller controller = mappedControllerMap.get(pathInfo);
		if (controller !=null) {
			controller.process(request, response);
		}
	}
	
}
