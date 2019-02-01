package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;

import dao.TeacherCourseDao;
import dao.TeacherDao;
import dto.Teacher;
import dto.TeacherCourse;

public class SelectCourseMark2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectCourseMark2() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cterm=Decode.decode(request.getParameter("crterm"));
		String cyear=Decode.decode(request.getParameter("cryear"));
		String cexam=Decode.decode(request.getParameter("crexam"));
		HttpSession session=request.getSession();
		Teacher tech=(Teacher)session.getAttribute("userinfo");
		TeacherDao tdao= new TeacherDao();
		Teacher t=new Teacher();
		t=tdao.selectTeacherById(tech.getId());
		String tname=t.getName();
		TeacherCourseDao tcdao = new TeacherCourseDao();
		ArrayList<TeacherCourse> term = tcdao.term();
		ArrayList<TeacherCourse> year = tcdao.term1();
		request.setAttribute("term", term);
		request.setAttribute("year", year);
		TeacherCourse c1=new TeacherCourse();
		c1.setCterm(cterm);
		c1.setCyear(cyear);
		c1.setCexam(cexam);
		request.setAttribute("c1",c1);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=tcdao.sumData1(cexam, cyear, cterm,tname);
		sumPageCount=tcdao.sumPageCount1(cexam, cyear, cterm,tname);
		ArrayList<TeacherCourse> slist = tcdao.fenye1(currentCount,cexam, cyear, cterm,tname);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);				
		request.getRequestDispatcher("selectCourseMark2.jsp").forward(request, response);
	}

}
