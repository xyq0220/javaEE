package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Classicformula;
import service.ClassicformulaService;

@WebServlet("/classicformula/edit")
public class ClassicformulaEditServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) 
					 throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		//获取请求参数
		int id = Integer.parseInt(request.getParameter("id"));
		
		//调用service查询
		//StudentService stuService = new StudentService();
		//从servletContext中获取applicationContext对象
	  	ServletContext sc = request.getServletContext();
	  	String key="org.springframework.web.context.WebApplicationContext.ROOT";
	  	WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
	  	ClassicformulaService claService = (ClassicformulaService)ctx.getBean("classicformulaService");

	  	Classicformula cla = claService.queryById(id);
		
		//保存查询结果
		request.setAttribute("classicformula", cla);
		
		//跳转到list.jsp展示查询结果
		String url = "/WEB-INF/jsp/edit.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	

}
