package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ProgramDao;
import dto.Program;


public class DeleteProgram extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteProgram() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=Decode.decode(request.getParameter("id"));
		Program p = new Program();
		ProgramDao dao = new ProgramDao();
		p.setId(id);
		int i = dao.deleteProgram(id);
		if(i==0){
			out.println("<script language=javascript>");				
			out.println("alert('删除失败');");	
			out.println("window.location.href='SelectAllPrograms'");
			out.println("</script>");
		}else {
			out.println("<script language=javascript>");				
			out.println("alert('删除成功');");	
			out.println("window.location.href='SelectAllPrograms'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
