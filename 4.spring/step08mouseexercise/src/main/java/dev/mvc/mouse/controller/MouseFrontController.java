package dev.mvc.mouse.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 HTTP 요청을 전달받은 유일한 서블릿
@WebServlet("/mouse-api/*")
public class MouseFrontController extends HttpServlet {

	/*
	 * Mouse 등록 요청 Mouse 조회 요청
	 */

	private Map<String, Controller> mappedControllerMap = new HashMap<>();

	public MouseFrontController() {
		mappedControllerMap.put("/mice", new MouseListController()); // 전체 Mouse 목록 조회 요청에 대한 mapping
//		mappedControllerMap.put("mice/add", ??);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통 처리 로직
		request.setCharacterEncoding("UTF-8");

		String path = request.getPathInfo();
		System.out.println(path);
		
		Controller controller = mappedControllerMap.get(path);
		controller.process(request, response);
	}

}
