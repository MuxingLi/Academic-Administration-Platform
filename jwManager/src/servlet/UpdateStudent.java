package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.StudentDao;
import dto.Student;
import dto.Teacher;
import dto.User;

public class UpdateStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateStudent() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuid=request.getParameter("id");
		StudentDao sdao=new StudentDao();
		Student s=new Student();
		s=sdao.selectStudentById(stuid);
		request.setAttribute("students", s);
		request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String role=Decode.decode(request.getParameter("role"));
		String stuid=request.getParameter("stuid");
		String stuname=Decode.decode(request.getParameter("stuname"));
		String stusex=Decode.decode(request.getParameter("stusex"));
		String stubirth=request.getParameter("stubirth");
		String stunation=Decode.decode(request.getParameter("stunation"));
		String stuidentity=request.getParameter("stuidentity");
		String stulook=Decode.decode(request.getParameter("stulook"));
		String stubirthplace=Decode.decode(request.getParameter("stubirthplace"));
		String stutel=request.getParameter("stutel");
		String stucontacter=Decode.decode(request.getParameter("stucontacter"));
		String stuhometel=request.getParameter("stuhometel");
		String stuaddress=Decode.decode(request.getParameter("stuaddress"));
		String stuemail=request.getParameter("stuemail");
		String stuenterdate=request.getParameter("stuenterdate");
		String stuleavedate=request.getParameter("stuleavedate");
		String studepartment=Decode.decode(request.getParameter("studepartment"));
		String stumajor=Decode.decode(request.getParameter("stumajor"));
		String stuclassid=request.getParameter("stuclassid");
		String stustatus=Decode.decode(request.getParameter("stustatus"));
		String sturoomid=Decode.decode(request.getParameter("sturoomid"));
		String stusum=request.getParameter("stusum");
		String stumust=request.getParameter("stumust");
		String stuselect=request.getParameter("stuselect");
		String sturemark=Decode.decode(request.getParameter("sturemark"));
		StudentDao dao=new StudentDao();
		Student s=new Student();
		s.setId(stuid);
		s.setName(stuname);
		s.setStusex(stusex);
		s.setStubirth(stubirth);
		s.setStunation(stunation);
		s.setStuidentity(stuidentity);
		s.setStulook(stulook);
		s.setStubirthplace(stubirthplace);
		s.setStutel(stutel);
		s.setStucontacter(stucontacter);
		s.setStuhometel(stuhometel);
		s.setStuaddress(stuaddress);
		s.setStuemail(stuemail);
		s.setStuenterdate(stuenterdate);
		s.setStuleavedate(stuleavedate);
		s.setStudepartment(studepartment);
		s.setStumajor(stumajor);
		s.setStuclassid(stuclassid);
		s.setStustatus(stustatus);
		s.setSturoomid(sturoomid);
		s.setStusum(stusum);
		s.setStumust(stumust);
		s.setStuselect(stuselect);
		s.setSturemark(sturemark);	
		int i=dao.updateStudent(s);
		if(i>0){
			if("管理员".equals(role)){
				out.println("<script language=javascript>");				
				out.println("alert('更新学生信息成功');");	
				out.println("window.location.href='SelectAllStudentsServlet'");
				out.println("</script>");
			}else if("学生".equals(role)){
				out.println("<script language=javascript>");				
				out.println("alert('更新学生信息成功');");	
				out.println("window.location.href='blank.jsp'");
				out.println("</script>");
			}
								
		}else
		{
			out.println("<script language=javascript>");				
			out.println("alert('更新信息失败');");	
			out.println("window.location.href='updateStudent.jsp'");
			out.println("</script>");					
		}
		out.flush();
		out.close();
	}

}
