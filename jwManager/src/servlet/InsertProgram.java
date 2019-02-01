package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.CourseDao;
import dao.ProgramDao;
import dto.Program;

public class InsertProgram extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertProgram() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String dept=Decode.decode(request.getParameter("dept"));
		String term=Decode.decode(request.getParameter("term"));
		String[] cid=request.getParameterValues("cid");
		String[] cp=request.getParameterValues("cp");
		for(int i=0;i<cid.length;i++){
			cid[i]=Decode.decode(cid[i]);
		}
		for(int z=0;z<cid.length;z++){
			cid[z]=Decode.decode(cid[z]);
		}
		Program p = new Program();
		ProgramDao pdao = new ProgramDao();
		p.setDept(dept);
		p.setTerm(term);
		p.setCid(cid);
		p.setCp(cp);
		CourseDao cdao = new CourseDao();
		ArrayList<String> idlist = cdao.selectCid();

		int m=0,j=0;
			for(int n=0;n<idlist.size();n++){
				for(int i=0;i<cid.length;i++){
					if(cid[i].equals(idlist.get(n))){
						j++;
					}
				}
			}
			if(j==cid.length){
				if(cid.length==1){
					m=pdao.insertProgram1(p);
				}else if(cid.length==2){
					m=pdao.insertProgram2(p);
				}else if(cid.length==3){
					m=pdao.insertProgram3(p);
				}else if(cid.length==4){
					m=pdao.insertProgram4(p);
				}else{
					out.println("<script language=javascript>");
					out.println("alert('已超过4门课程');");
					out.println("window.location='insertProgram.jsp'");
					out.println("</script>");
				}
			}else{
				out.println("<script language=javascript>");
				out.println("alert('查无此课程');");
				out.println("window.location='insertProgram.jsp'");
				out.println("</script>");
			}
		if(m>0){
			out.println("<script language=javascript>");				
			out.println("alert('增添教学计划成功');");	
			out.println("window.location.href='SelectAllPrograms'");
			out.println("</script>");
		}else{
			out.println("<script language=javascript>");				
			out.println("alert('添加失败');");	
			out.println("window.location.href='insertProgram.jsp'");
			out.println("</script>");
		
		}
	}
}
