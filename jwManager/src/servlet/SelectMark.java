package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hdf.extractor.data.DOP;

import common.Decode;

import dao.StudentCourseDao;
import dto.Student;
import dto.StudentCourse;

public class SelectMark extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public SelectMark() {
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
		StudentCourseDao scdao = new StudentCourseDao();
		StudentCourse c1=new StudentCourse();
		c1.setCterm(cterm);
		c1.setCyear(cyear);
		request.setAttribute("c1",c1);
		//id
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("userinfo");
		c1.setId(stu.getId());
		String id= c1.getId();
		//分页
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=scdao.sumData4(id,cterm,cyear);
		sumPageCount=scdao.sumPageCount4(id,cterm,cyear);
		ArrayList<StudentCourse> slist = scdao.fenye4(currentCount,id,cterm,cyear);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);			
		//年份及学期
		ArrayList<StudentCourse> term = scdao.term();
		ArrayList<StudentCourse> year = scdao.term1();
		request.setAttribute("term", term);
		request.setAttribute("year", year);
		request.getRequestDispatcher("selectMark.jsp").forward(request, response);
	}

}
