package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import po.Classicformula;
import service.ClassicformulaService;

@WebServlet("/classicformula/list")
public class ClassicformulaListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public ClassicformulaListServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�������
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		//����service��ѯ
		//StudentService service = new StudentService();
		// ��servletContext�л�ȡapplicationContext����
		ServletContext sc = request.getServletContext();
		String key="org.springframework.web.context.WebApplicationContext.ROOT";
		WebApplicationContext ctx = (WebApplicationContext)sc.getAttribute(key);
		ClassicformulaService service = (ClassicformulaService)ctx.getBean("claService");
		List<Classicformula> claList = null;
		if(name==null||name.equals("")) {
			claList = service.query();
		}else {
			claList = service.queryList(name);
		}
		//�����ѯ���
		request.setAttribute("claList", claList);
		//��ת��list.jspչʾ��ѯ���
		String url = "/WEB-INF/jsp/classicformula/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}


}
