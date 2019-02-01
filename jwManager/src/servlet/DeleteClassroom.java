package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ClassroomDao;
import dto.Classroom;

public class DeleteClassroom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DeleteClassroom() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String rno=Decode.decode(request.getParameter("rno"));
		String rbuilding=Decode.decode(request.getParameter("rbuilding"));		
		ClassroomDao dao=new ClassroomDao();
		Classroom cl=new Classroom();
		cl.setRno(rno);
		cl.setRbuilding(rbuilding);
		int i=dao.deleteClassroomById(cl);
		if(i==0){
			out.println("<script language=javascript>");				
			out.println("alert('删除失败');");	
			out.println("window.location.href='SelectAllClassroomsServlet'");
			out.println("</script>");
		}else {
			out.println("<script language=javascript>");				
			out.println("alert('删除成功');");	
			out.println("window.location.href='SelectAllClassroomsServlet'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
