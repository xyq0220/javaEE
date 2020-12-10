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

import po.Tcmrelation;
import po.Traditionalchinesemedicine;
import service.TcmrelationService;
import service.TraditionalchinesemedicineService;

/**
 * Servlet implementation class TraditionalchinesemedicineListServlet
 */
@WebServlet("/traditionalchinesemedicine/list")
public class TraditionalchinesemedicineListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraditionalchinesemedicineListServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String numString=request.getParameter("num");
		
		int num = 1;
		if(!empty(numString)) num=Integer.parseInt(numString);
		num=Math.max(num, 1);
		String submit = request.getParameter("submit");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		//StudentService service = new StudentService();
		if(!empty(submit)) {
			if(submit.equals("上一页")) {
				if(num>1) num--;
			}else if(submit.equals("下一页")) {
				num++;
			}
		}
		
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
		TraditionalchinesemedicineService service = (TraditionalchinesemedicineService)ctx.getBean("tcmService");
		List<Traditionalchinesemedicine> tcmlist=null;
		int tot,numPerPage=10;
		if(empty(name)&&empty(type)) {
			tot=service.queryNum();
			int pageNum=(tot+numPerPage-1)/numPerPage;
			num=Math.min(num, pageNum);
			int l=(num-1)*numPerPage;
			int r=Math.min(numPerPage,tot-l);
			tcmlist=service.query(l,r);
		}else if(empty(name)) {
			tot=service.queryNumByType(type);
			int pageNum=(tot+numPerPage-1)/numPerPage;
			num=Math.min(num, pageNum);
			int l=(num-1)*numPerPage;
			int r=Math.min(numPerPage,tot-l);
			tcmlist=service.queryByType(type,l,r);			
		}else if(empty(type)) {
			tot=service.queryNumByName(name);
			int pageNum=(tot+numPerPage-1)/numPerPage;
			num=Math.min(num, pageNum);
			int l=(num-1)*numPerPage;
			int r=Math.min(numPerPage,tot-l);
			tcmlist=service.queryByName(name,l,r);			
		}else {
			tot=service.queryNumByNameAndType(name,type);
			int pageNum=(tot+numPerPage-1)/numPerPage;
			num=Math.min(num, pageNum);
			int l=(num-1)*numPerPage;
			int r=Math.min(numPerPage,tot-l);
			tcmlist=service.queryByNameAndType(name,type,l,r);			
		}
		TcmrelationService trService = (TcmrelationService)ctx.getBean("tcmrelationService");
		List< List<Tcmrelation> > trlists = new ArrayList<>();
		for(int i=0;i<tcmlist.size();i++) {
			Traditionalchinesemedicine tcm = tcmlist.get(i);
			List<Tcmrelation> trlist = trService.queryByTcmId(tcm.getId()); 
			trlists.add(trlist);
		}
		request.setAttribute("num", String.valueOf(num));
		request.setAttribute("name", name);
		request.setAttribute("type", type);
		request.setAttribute("tcmlist", tcmlist);
		request.setAttribute("trlists", trlists);
		String url = "/WEB-INF/jsp/traditionalchinesemedicine/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	boolean empty(String x) {
		return x==null||x.equals("");
	}
}
