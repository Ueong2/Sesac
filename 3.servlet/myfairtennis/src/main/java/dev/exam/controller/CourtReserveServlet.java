package dev.exam.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.exam.model.Reservation;


@WebServlet("/tennis/reserve")
public class CourtReserveServlet extends HttpServlet{

	/*
	 * tennis/reserve 경로로 요청 시, 
	 * "Hello" 콘솔에 출력되도록 구현
	 */
	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

	/*
	 * HttpServletRequest - HTTP 요청 객체, HTTP 요청 메시지에 대한 정보 조회 가능
	 * HttpServletResponse - HTTP 응답 객체, HTTP 응답 메시지로 활용 가능
	 */	
	
	// http://localhost:8090/frontcontroller1/tennis/reserve?center=YCS&court=2&datetime=2023-10-05T18%3A01 로 접근 시 doGet이 동작한다.
	// get은 파라미터의 정보를 url에 그대로 노출하기 때문이며, 사용자가 악용하는 것을 방지하기 위해 post로 데이터를 넘겨준다.
	// 따라서 doGet의 동작으로 인해 error code가 동작한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			final String errorpath = "/WEB-INF/unauthorized.jsp";

			//위 경로의 페이지로 이동하도록 코드 구현
			RequestDispatcher dispatcher = request.getRequestDispatcher(errorpath);
			dispatcher.forward(request, response);
	} 


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// courtList.jsp 내 폼에서 입력받은 값 추출
		String reservedTimeString = request.getParameter("datetime");
		LocalDateTime reservedTime = LocalDateTime.parse(reservedTimeString, FORMATTER);
		
		int courtNumber = Integer.parseInt(request.getParameter("court"));
		String centerName = request.getParameter("center");
		
		// 예매 처리 로직이 수행되었다고 가정
		Reservation reservation = new Reservation(centerName, courtNumber, reservedTime);
		
		request.setAttribute("reservation", reservation);
		
		final String path = "/WEB-INF/success.jsp";
		
		//위 경로의 페이지로 이동하도록 코드 구현
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
	
	
	
	
	
	

}
