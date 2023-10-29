package dev.syntax.step01helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 2. Annotation(@) 기반 맵핑
 * XML을 통한 관리 방식의 번거로움
 * 추상화되고 직관적인 Annotation으로 간소화
 * 
 * @WebServlet 
 * ref. https://javaee.github.io/javaee-spec/javadocs/javax/servlet/annotation/WebServlet.html
 * 
 */

@WebServlet(name = "SecondServlet", urlPatterns = "/servlets/secondservlet")
/*
 * web.xml의 아래 설정과 동일함 <servlet-name> SecondServlet </servlet-name>
 * 
 * <url-pattern> /servlets/secondservlet </url-pattern>
 */
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello Second World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Second World!</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}