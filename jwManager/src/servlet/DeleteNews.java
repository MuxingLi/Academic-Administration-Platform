package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ClassroomDao;
import dao.NewsDao;
import dto.Classroom;
import dto.News;

public class DeleteNews extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteNews() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String nid=Decode.decode(request.getParameter("nid"));
		NewsDao dao = new NewsDao();
		News n = new News();
		n.setNid(nid);
		int i = dao.deleteNews(nid);
		if(i==0){
			out.println("<script language=javascript>");				
			out.println("alert('删除失败');");	
			out.println("window.location.href='SelectAllNewsServlet'");
			out.println("</script>");
		}else {
			out.println("<script language=javascript>");				
			out.println("alert('删除成功');");	
			out.println("window.location.href='SelectAllNewsServlet'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
