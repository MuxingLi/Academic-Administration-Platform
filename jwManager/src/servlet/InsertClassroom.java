package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ClassroomDao;
import dto.Classroom;

public class InsertClassroom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InsertClassroom() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String rbuilding=Decode.decode(request.getParameter("rbuilding"));
		String rno=request.getParameter("rno");
		String rtype=Decode.decode(request.getParameter("rtype"));
		String rseat=Decode.decode(request.getParameter("rseat"));
		String rmedia=Decode.decode(request.getParameter("rmedia"));
		String rremark=Decode.decode(request.getParameter("rremark"));
		String[] ravailable=request.getParameterValues("ravailable");		
		for(int i=0;i<ravailable.length;i++){
			ravailable[i]=Decode.decode(ravailable[i]);
		}
		ClassroomDao dao=new ClassroomDao();
		Classroom cl=new Classroom();

		cl.setRbuilding(rbuilding);
		cl.setRno(rno);
		cl.setRtype(rtype);
		cl.setRseat(rseat);
		cl.setRmedia(rmedia);
		cl.setRavailable(ravailable);
		cl.setRremark(rremark);
		int i=dao.insertClassroom(cl);
		if(i>0){
			out.println("<script language=javascript>");				
			out.println("alert('增添教室信息成功');");	
			out.println("window.location.href='SelectAllClassroomsServlet'");
			out.println("</script>");
		}else{
			out.println("<script language=javascript>");				
			out.println("alert('增添教室信息失败');");	
			out.println("window.location.href='insertClassroom.jsp'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

}
