package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.StudentCourseDao;
import dto.StudentCourse;

public class UpdateMark2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateMark2() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=Decode.decode(request.getParameter("cid"));
		StudentCourseDao scdao = new StudentCourseDao();
		ArrayList<StudentCourse> sc= scdao.selectAllStudentsByCid(cid);
		StudentCourse sc1 = new StudentCourse();
		sc1.setCid(cid);
		request.setAttribute("mark", sc);
		request.setAttribute("mark1", sc1);		
		request.getRequestDispatcher("updateStudentMark2.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cid=request.getParameter("cid");
		StudentCourse sc = new StudentCourse();
		sc.setCid(cid);
		String[] scmark = request.getParameterValues("scmark");
		String[] id1 = request.getParameterValues("id");
		for(int j=0;j<scmark.length;j++){
			sc.setId(id1[j]);
			scmark[j]=Decode.decode(scmark[j]);
			sc.setScmark(scmark[j]);
			StudentCourseDao scdao = new StudentCourseDao();
			int i=scdao.updateScmark(sc);
			if(i>0){
				out.println("<script language=javascript>");				
				out.println("alert('上传成绩成功');");	
				out.println("window.location.href='SelectAllCoursesMark2'");			
				out.println("</script>");
			}else
			{
				out.println("<script language=javascript>");				
				out.println("alert('上传成绩失败');");	
				out.println("window.location.href='SelectAllCoursesMark2'");			
				out.println("</script>");			}
		}
		out.flush();
		out.close();
	}
}
