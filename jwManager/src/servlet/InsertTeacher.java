package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.TeacherDao;
import dto.Teacher;

public class InsertTeacher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InsertTeacher() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
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
		String password=Decode.decode(request.getParameter("password"));
		String role=Decode.decode(request.getParameter("role"));
		
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
		t.setPassword(password);	
		t.setRole(role);	

		int i=dao.insertTeacher(t);
		if(i>0){
			out.println("<script language=javascript>");
			out.println("alert('增添教师信息成功');");
			out.println("window.location.href='SelectAllTeachersServlet'");
			out.println("</script>");
		}else
		{
			out.println("<script language=javascript>");
			out.println("alert('增添教师信息失败');");
			out.println("window.location.href='insertTeacher.jsp'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

}
