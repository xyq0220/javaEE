package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/classicformula/add")
public class ClassicformulaAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ClassicformulaAddServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//从servletContext中获取applicationContext对象
		String url = "/WEB-INF/jsp/classicformula/add.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
