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

@WebServlet("/classicformula/editProc")
public class ClassicformulaEditProServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ClassicformulaEditProServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String usage = request.getParameter("usage");
		String comment = request.getParameter("comment");

		Classicformula cla = new Classicformula();
		cla.setId(id);
		cla.setName(name);
		cla.setUsage(usage);
		cla.setComment(comment);

		 //StudentService stuService = new StudentService();
	    //从servletContext中获取applicationContext对象
	  	ServletContext sc = request.getServletContext();
	  	String key="org.springframework.web.context.WebApplicationContext.ROOT";
	  	WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
	  	ClassicformulaService claService = (ClassicformulaService)ctx.getBean("classicformulaService");

	  	claService.updateClassicformul(cla);

		response.sendRedirect("list");
	}

}
