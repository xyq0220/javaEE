package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Tcmrelation;
import service.TcmrelationService;


/**
 * Servlet implementation class TraditionalchinesemedicineAddProcServlet
 */
@WebServlet("/tcmrelation/addProc")
public class TcmrelationAddProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TcmrelationAddProcServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int tcmid = Integer.parseInt(request.getParameter("tcmid"));
		String chuchu = request.getParameter("chuchu");
		String content = request.getParameter("content");

		Tcmrelation tr = new Tcmrelation();
		tr.setTcmid(tcmid);
		tr.setChuchu(chuchu);
		tr.setContent(content);
	    //StudentService stuService = new StudentService();
		
		//从servletContext中获取applicationContext对象
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
        TcmrelationService trService = (TcmrelationService)ctx.getBean("tcmrelationService");
	    trService.add(tr);
	  
		response.sendRedirect("../tcmrelation/add?tcmid="+tcmid);
	}	

}
