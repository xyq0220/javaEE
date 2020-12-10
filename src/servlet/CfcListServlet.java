package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Classicformula;
import po.Classicformulacomposition;
import service.ClassicformulaService;
import service.ClassicformulacompositionService;
import service.TraditionalchinesemedicineService;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/cfc/list")
public class CfcListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CfcListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	boolean empty(String x) {
		return x==null||x.equals("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String cfid = request.getParameter("cfid");
		//int cfid = Integer.parseInt(request.getParameter("cfid"));
		//调用service查询
		//StudentService service = new StudentService();
		// 从servletContext中获取applicationContext对象
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
		ClassicformulacompositionService service = (ClassicformulacompositionService)ctx.getBean("cfcService");
		ClassicformulaService claService = (ClassicformulaService)ctx.getBean("claService");
		TraditionalchinesemedicineService tcmService = (TraditionalchinesemedicineService)ctx.getBean("tcmService");
		String cfname = claService.queryById(Integer.parseInt(cfid)).getName();
		List<Classicformulacomposition> cfcList=null;
		List<String>tcnameList = new ArrayList<String>();
		if(empty(cfid)) {
			cfcList=service.query();
		}else {
			cfcList=service.queryList(Integer.parseInt(cfid));
			for(int i=0;i<cfcList.size();i++) {
				Classicformulacomposition cla = cfcList.get(i);
				String tcname = tcmService.queryById(cla.getTcmid()).getName();
				tcnameList.add(tcname);
			}
		}
		
		//保存查询结果
		request.setAttribute("cfcList", cfcList);
		request.setAttribute("cfid", cfid);
		request.setAttribute("cfname", cfname);
		request.setAttribute("tcnameList", tcnameList);
		//跳转到list.jsp展示查询结果
		String url = "/WEB-INF/jsp/cfc/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
