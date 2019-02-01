package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.CourseDao;
import dto.Course;

public class UpdateCourse extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateCourse() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=request.getParameter("cid");
		CourseDao dao=new CourseDao();
		Course c=new Course();
		c=dao.selectCourseById(cid);
		request.setAttribute("courses", c);
		request.getRequestDispatcher("updateCourse.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cid=request.getParameter("cid");
		String cname=Decode.decode(request.getParameter("cname"));
		String ctime=Decode.decode(request.getParameter("ctime"));
		String cweektime=Decode.decode(request.getParameter("cweektime"));
		String ctype=Decode.decode(request.getParameter("ctype"));
		String cscore=Decode.decode(request.getParameter("cscore"));
		String cdepartment=Decode.decode(request.getParameter("cdepartment"));
		String cexam=Decode.decode(request.getParameter("cexam"));
		String cdescribe=Decode.decode(request.getParameter("cdescribe"));
		String cterm=Decode.decode(request.getParameter("cterm"));
		String cteacher=Decode.decode(request.getParameter("cteacher"));
		String cshangke=Decode.decode(request.getParameter("cshangke"));
		String[] cjieshu=request.getParameterValues("cjieshu");		
		String[] cweekday=request.getParameterValues("cweekday");		
		for(int i=0;i<cjieshu.length;i++){		
			cjieshu[i]=Decode.decode(cjieshu[i]);
		}
		for(int j=0;j<cweekday.length;j++){			
			cweekday[j]=Decode.decode(cweekday[j]);
		}
		CourseDao dao=new CourseDao();
		Course c=new Course();
		c.setCid(cid);
		c.setCname(cname);
		c.setCtime(ctime);
		c.setCweektime(cweektime);
		c.setCtype(ctype);
		c.setCscore(cscore);
		c.setCdepartment(cdepartment);
		c.setCexam(cexam);
		c.setCdescribe(cdescribe);
		c.setCterm(cterm);
		c.setCteacher(cteacher);		
		c.setCshangke(cshangke);		
		c.setCjieshu(cjieshu);		
		c.setCweekday(cweekday);
		if(cweekday.length==1){
			int i=dao.updateCourse1(c);
			if(i>0){
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息成功');");	
				out.println("window.location.href='SelectAllCoursesServlet'");
				out.println("</script>");
			}else
			{
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息失败');");	
				out.println("window.location.href='updateCourse.jsp'");
				out.println("</script>");
			}
		}else if(cweekday.length==2){
			int i=dao.updateCourse2(c);
			if(i>0){
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息成功');");	
				out.println("window.location.href='SelectAllCoursesServlet'");
				out.println("</script>");
			}else{
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息失败');");	
				out.println("window.location.href='updateCourse.jsp'");
				out.println("</script>");			
			}
		}else if(cweekday.length==3){
			int i=dao.updateCourse3(c);
			if(i>0){
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息成功');");	
				out.println("window.location.href='SelectAllCoursesServlet'");
				out.println("</script>");
			}else
			{
				out.println("<script language=javascript>");				
				out.println("alert('更新课程信息失败');");	
				out.println("window.location.href='updateCourse.jsp'");
				out.println("</script>");
			}
		}
		out.flush();
		out.close();
	}

}
