package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Traditionalchinesemedicine;
import service.TraditionalchinesemedicineService;


/**
 * Servlet implementation class TraditionalchinesemedicineAddProcServlet
 */
@WebServlet("/traditionalchinesemedicine/addProc")
public class TraditionalchinesemedicineAddProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraditionalchinesemedicineAddProcServlet() {
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

		int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		int type = Integer.parseInt(request.getParameter("type"));
		String bjyw=request.getParameter("bjyw");
		String zhuzhi=request.getParameter("zhuzhi");
		String xingwei=request.getParameter("xingwei");
		String chandi=request.getParameter("chandi");
		String dosage=request.getParameter("dosage");
		String taboo=request.getParameter("taboo");
		String processing=request.getParameter("processing");
		String note=request.getParameter("note");
		Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
		tcm.setNumber(number);
		tcm.setAlias(alias);
		tcm.setBjyw(bjyw);
		tcm.setChandi(chandi);
		tcm.setDosage(dosage);
		tcm.setName(name);
		tcm.setTaboo(taboo);
		tcm.setType(type);
		tcm.setXingwei(xingwei);
		tcm.setZhuzhi(zhuzhi);
		tcm.setProcessing(processing);
		tcm.setNote(note);
	    //StudentService stuService = new StudentService();
		
		//从servletContext中获取applicationContext对象
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
        TraditionalchinesemedicineService tcmService = (TraditionalchinesemedicineService)ctx.getBean("tcmService");

	    tcmService.add(tcm);

		response.sendRedirect("list");
	}

}
