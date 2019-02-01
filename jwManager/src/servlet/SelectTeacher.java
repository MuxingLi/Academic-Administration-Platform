package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.TeacherDao;
import dto.Teacher;

public class SelectTeacher extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public SelectTeacher() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=Decode.decode(request.getParameter("tid"));
		String name=Decode.decode(request.getParameter("tname"));
		String techzhicheng=Decode.decode(request.getParameter("tzhicheng"));
		String techdepartment=Decode.decode(request.getParameter("tdepartment"));
		TeacherDao dao = new TeacherDao();
		Teacher t1 = new Teacher();
		t1.setId(id);
		t1.setName(name);
		t1.setTechzhicheng(techzhicheng);
		t1.setTechdepartment(techdepartment);
		request.setAttribute("t1",t1);
		ArrayList<Teacher> teachersdept=dao.depart();		
		request.setAttribute("dept", teachersdept);
		ArrayList<Teacher> teachers2=dao.zhicheng();//分职称
		request.setAttribute("zhicheng", teachers2);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		System.out.println(strPage);
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		System.out.println(currentCount);
		rowCount=dao.sumData1(id, name, techzhicheng, techdepartment);
		sumPageCount=dao.sumPageCount1(id, name, techzhicheng, techdepartment);
		ArrayList<Teacher> slist = dao.fenye1(currentCount, id, name, techzhicheng, techdepartment);
		if(slist.size()==0){
			slist=null;
		}request.setAttribute("ttry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);		
		
		
		request.getRequestDispatcher("selectTeacher.jsp").forward(request, response);
	}

}
