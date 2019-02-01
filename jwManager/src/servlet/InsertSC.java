package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.CourseArrangeDao;
import dao.CourseDao;
import dto.Course;
import dto.CourseArrange;
import dto.Student;
import dto.StudentCourse;

public class InsertSC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public InsertSC() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=Decode.decode(request.getParameter("crid"));
		String cname=Decode.decode(request.getParameter("crname"));
		StudentCourse c1 = new StudentCourse();
		c1.setCid(cid);
		c1.setCname(cname);
		request.setAttribute("c1",c1);
		
		Calendar d=Calendar.getInstance();
		int month = d.get(Calendar.MONTH)+1;
		String cterm="";
		if(month>5){
			cterm="秋季";
		}else{
			cterm="春季";
		}		
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		//course 中有同样选修分页 故用courseDao中的 查询courseDao中都有
		CourseDao dao= new CourseDao();
		rowCount=dao.sumData3(cname,cid,cterm);
		sumPageCount=dao.sumPageCount3( cname,cid,cterm);
		ArrayList<Course> slist = dao.fenye3(currentCount,cname,cid,cterm);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
//		CourseArrange ca=new CourseArrange();
//		HttpSession session=request.getSession();
//		Student stu=(Student)session.getAttribute("userinfo");
//		ca.setId(stu.getId());
//		CourseArrangeDao dao2=new CourseArrangeDao();
//		if(dao2.panduan(stu.getId())==null){
//			dao2.insertCourseArrange(ca);
//		}
		request.getRequestDispatcher("select-insertSC.jsp").forward(request, response);
	}
}
