package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.TeacherDao;
import dto.Teacher;

public class SelectTeacherDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectTeacherDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String techid=request.getParameter("id");
		TeacherDao tdao=new TeacherDao();
		Teacher t=new Teacher();
		t=tdao.selectTeacherById(techid);
		request.setAttribute("teachers", t);
		request.getRequestDispatcher("selectTeacherDetail.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String techid=request.getParameter("techid");
	String techname=Decode.decode(request.getParameter("techname"));
	String techsex=Decode.decode(request.getParameter("techsex"));
	String techbirth=request.getParameter("techbirth");
	String techlook=Decode.decode(request.getParameter("techlook"));
	String technation=Decode.decode(request.getParameter("technation"));
	String techtel=request.getParameter("techtel");
	String techidentity=request.getParameter("techidentity");
	String techenterdate=request.getParameter("techenterdate");
	String techdepartment=Decode.decode(request.getParameter("techdepartment"));
	String techzhicheng=Decode.decode(request.getParameter("techzhicheng"));
	String techaddress=Decode.decode(request.getParameter("techaddress"));
	String techeducation=Decode.decode(request.getParameter("techeducation"));
	String techaward=Decode.decode(request.getParameter("techaward"));
	String techkeyan=Decode.decode(request.getParameter("techkeyan"));
	String techremark=Decode.decode(request.getParameter("techremark"));

	TeacherDao dao=new TeacherDao();
	Teacher t=new Teacher();
	
	t.setId(techid);
	t.setName(techname);
	t.setTechsex(techsex);
	t.setTechbirth(techbirth);
	t.setTechlook(techlook);
	t.setTechnation(technation);
	t.setTechtel(techtel);
	t.setTechidentity(techidentity);
	t.setTechenterdate(techenterdate);
	t.setTechdepartment(techdepartment);
	t.setTechzhicheng(techzhicheng);
	t.setTechaddress(techaddress);
	t.setTecheducation(techeducation);
	t.setTechaward(techaward);
	t.setTechkeyan(techkeyan);
	t.setTechremark(techremark);	
	request.getRequestDispatcher("SelectAllTeachersServlet").forward(request, response);
	}

}
