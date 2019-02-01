package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import common.DBUtil;
import common.Decode;
import dao.StudentDao;
import dto.Student;

public class SelectStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectStudent() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=Decode.decode(request.getParameter("sid"));
		String name=Decode.decode(request.getParameter("sname"));
		String stuclassid=Decode.decode(request.getParameter("sclassid"));
		String studepartment=Decode.decode(request.getParameter("sdepartment"));
		StudentDao dao= new StudentDao();
		ArrayList<Student> students1=dao.depart();//分院系
		request.setAttribute("students1", students1);
		Student s1 = new Student();
		s1.setId(id);
		s1.setName(name);
		s1.setStuclassid(stuclassid);
		s1.setStudepartment(studepartment);
		request.setAttribute("s1",s1);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData1(id, name, stuclassid, studepartment);
		sumPageCount=dao.sumPageCount1(id, name, stuclassid, studepartment);
		ArrayList<Student> slist = dao.fenye1(currentCount, id, name, stuclassid, studepartment);
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("stry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);			
		request.getRequestDispatcher("selectStudent.jsp").forward(request, response);
		}
}
