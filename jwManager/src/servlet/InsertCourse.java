package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.poi.hssf.util.HSSFColor.GOLD;

import common.Decode;
import dao.CourseDao;
import dao.TeacherDao;
import dto.Course;

public class InsertCourse extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertCourse() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		Teacher tech=(Teacher)session.getAttribute("userinfo");
//		String id=tech.getId();
//		TeacherDao tdao = new TeacherDao();
//		Teacher t = new Teacher();
//		t=tdao.selectTeacherById(id);
//		request.setAttribute("teachers", t);
//		request.getRequestDispatcher("insertCourse.jsp").forward(request, response);

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
		String cplace=Decode.decode(request.getParameter("cplace"));

		String[] cjieshu=request.getParameterValues("cjieshu");		
		String[] cweekday=request.getParameterValues("cweekday");
		for(int i=0;i<cjieshu.length;i++){
			cjieshu[i]=Decode.decode(cjieshu[i]);
		}
		for(int j=0;j<cweekday.length;j++){
			cweekday[j]=Decode.decode(cweekday[j]);
		}
		for(int k=0;k<cjieshu.length;k++){
			for(int l=0;l<cweekday.length;l++){
				if((k!=l)&&(cjieshu[k].equals(cjieshu[l]))&&(cweekday[k].equals(cweekday[l]))){
				out.println("<script language=javascript>");				
				out.println("alert('课程时间重复');");	
				out.println("window.location='insertCourse.jsp'");
				out.println("</script>");
				return;
				}
			}
		}
		CourseDao dao=new CourseDao();
		Course c=new Course();
		c.setCweekday(cweekday);
		c.setCjieshu(cjieshu);
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
		c.setCplace(cplace);
		TeacherDao teacher = new TeacherDao();
		ArrayList<String> namelist = teacher.selectTeacherName();
		for(int m=0;m<namelist.size();m++){
			if(cteacher.equals(namelist.get(m))){
				int i=0;
				if(cjieshu.length==1){
					i=dao.insertCourse1(c);					
				}else if(cjieshu.length==2){
					i=dao.insertCourse2(c);
				}else if(cjieshu.length==3){
					i=dao.insertCourse3(c);
				}else {
					out.println("<script language=javascript>");				
					out.println("alert('每周最多三节课！');");	
					out.println("window.location='insertCourse.jsp'");
					out.println("</script>");
				}				
				if(i>0){
					out.println("<script language=javascript>");				
					out.println("alert('增添课程信息成功');");	
					out.println("window.location.href='SelectAllCoursesServlet'");
					out.println("</script>");
				}else
				{
					out.println("<script language=javascript>");				
					out.println("alert('该课程已存在');");	
					out.println("window.location.href='insertCourse.jsp'");
					out.println("</script>");
				}
				break;
			}else if(m==namelist.size()-1){
				out.println("<script language=javascript>");
				out.println("alert('查无此授课教师');");
				out.println("window.location='insertCourse.jsp'");
				out.println("</script>");
			}
		}		
		out.flush();
		out.close();
	}
}

