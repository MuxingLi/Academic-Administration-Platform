package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;

public class DeleteCourseById extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DeleteCourseById() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cid=request.getParameter("cid");
		CourseDao dao=new CourseDao();
		int i=dao.deleteCourseById(cid);
		if(i==0){
			out.println("<script language=javascript>");				
			out.println("alert('删除失败');");	
			out.println("window.location.href='SelectAllCoursesServlet'");
			out.println("</script>");
		}else {
			out.println("<script language=javascript>");				
			out.println("alert('删除成功');");	
			out.println("window.location.href='SelectAllCoursesServlet'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
