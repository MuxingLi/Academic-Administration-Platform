package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.ProgramDao;
import dto.Program;

public class UpdateProgram extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateProgram() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		ProgramDao pdao = new ProgramDao();
		Program p = new Program();
		p=pdao.selectProgramById(id);
		request.setAttribute("program", p);
		request.getRequestDispatcher("updateProgram.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String dept=Decode.decode(request.getParameter("dept"));
		String term=Decode.decode(request.getParameter("term"));
		String cid1=Decode.decode(request.getParameter("cid1"));
		String cid2=Decode.decode(request.getParameter("cid2"));
		String cid3=Decode.decode(request.getParameter("cid3"));
		String cid4=Decode.decode(request.getParameter("cid4"));
		String cp1=Decode.decode(request.getParameter("cp1"));
		String cp2=Decode.decode(request.getParameter("cp2"));
		String cp3=Decode.decode(request.getParameter("cp3"));
		String cp4=Decode.decode(request.getParameter("cp4"));
		Program p = new Program();
		ProgramDao pdao = new ProgramDao();
		p.setDept(dept);
		p.setTerm(term);
		p.setCid1(cid1);
		p.setCid2(cid2);
		p.setCid3(cid3);
		p.setCid4(cid4);
		p.setCp1(cp1);
		p.setCp2(cp2);
		p.setCp3(cp3);
		p.setCp4(cp4);
		int i=pdao.updateProgram4(p);
		if(i>0){
			out.println("<script language=javascript>");				
			out.println("alert('更新教学计划成功');");	
			out.println("window.location.href='SelectAllPrograms'");
			out.println("</script>");
		}else
		{
			out.println("<script language=javascript>");				
			out.println("alert('更新教学计划失败');");	
			out.println("window.location.href='updateProgram.jsp'");
			out.println("</script>");
		}
	}

}
