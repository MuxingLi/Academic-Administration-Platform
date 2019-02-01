package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.CourseArrangeDao;
import dao.CourseDao;
import dao.StudentCourseDao;
import dto.Course;
import dto.CourseArrange;
import dto.Student;
import dto.StudentCourse;

public class DeleteStudentCourse extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DeleteStudentCourse() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("userinfo");
		String cid=Decode.decode(request.getParameter("cid"));	
		String ct=Decode.decode(request.getParameter("cterm"));
		String cyear = ct.substring(0,9);
		String cterm = ct.substring(10);
		StudentCourseDao scdao = new StudentCourseDao();
		StudentCourse sc = new StudentCourse();
		sc.setId(stu.getId());
		sc.setCid(cid);
		sc.setCterm(cterm);
		sc.setCyear(cyear);
		int i=scdao.deleteStudentCourseById(sc);
		if(i==0){
			out.println("<script language=javascript>");				
			out.println("alert('删除失败');");	
			out.println("window.location.href='SelectStudentCourse'");
			out.println("</script>");
		}else {
//			deleteCA(CourseArrange ca)[id,term,year]
			CourseArrange ca = new CourseArrange();
			CourseArrangeDao cadao = new CourseArrangeDao();
			ca.setId(stu.getId());
			ca.setCaterm(cterm);
			ca.setCayear(cyear);
			CourseDao cdao = new CourseDao();
			Course c = new Course();
			c=cdao.selectCourseById(cid);
			ca.setCourse(c);
			cadao.deleteCA(ca);
			out.println("<script language=javascript>");				
			out.println("alert('删除成功');");	
			out.println("window.location.href='SelectStudentCourse'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
