package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Classicformulacomposition;
import po.Traditionalchinesemedicine;
import service.ClassicformulacompositionService;
import service.TraditionalchinesemedicineService;

/**
 * Servlet implementation class AddProcServlet
 */
@WebServlet("/cfc/addProc")
public class CfcAddProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CfcAddProcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String tcmid = request.getParameter("tcmid");
		int cfid = Integer.parseInt(request.getParameter("cfid"));
		String dosage = request.getParameter("dosage");
		String usage = request.getParameter("usage");
		

		
		//从servletContext中获取applicationContext对象
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
		ClassicformulacompositionService cfcService = (ClassicformulacompositionService)ctx.getBean("cfcService");
	    TraditionalchinesemedicineService tcmService = (TraditionalchinesemedicineService)ctx.getBean("tcmService");
	    Traditionalchinesemedicine tcm = tcmService.queryOne(tcmid);
		Classicformulacomposition cfc = new Classicformulacomposition();
		if(tcm!=null) {
			System.out.println(1);
			cfc.setTcmid(tcm.getId());
			cfc.setCfid(cfid);
			cfc.setDosage(dosage);
			cfc.setUsage(usage);
			cfcService.addClassicformulacomposition(cfc);
		}
		response.sendRedirect("list?cfid="+cfid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
