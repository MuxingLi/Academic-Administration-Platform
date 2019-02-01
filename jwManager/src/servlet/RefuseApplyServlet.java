package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.ClassroomDao;
import dao.RoomApplyDao;
import dto.Classroom;
import dto.RoomApply;

public class RefuseApplyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RefuseApplyServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String building = Decode.decode(request.getParameter("building"));
		String no = Decode.decode(request.getParameter("no"));
		String jieshu = Decode.decode(request.getParameter("jieshu"));
		String usetime = Decode.decode(request.getParameter("usetime"));
		String status = "已拒绝";
		String reply = Decode.decode(request.getParameter("reply"));
		RoomApplyDao dao = new RoomApplyDao();
		RoomApply ra = new RoomApply();
		ra.setId(id);
		ra.setBuilding(building);
		ra.setNo(no);
		ra.setJieshu(jieshu);
		ra.setUsetime(usetime);
		ra.setStatus(status);
		ra.setReply(reply);
		int i=dao.updateStatusRefuse(ra);
		if(i>0){
			out.println("<script language=javascript>");				
			out.println("alert('拒绝申请成功');");	
			out.println("window.location.href='SelectAllApplyAdmin'");			
			out.println("</script>");
			ClassroomDao cdao = new ClassroomDao();
			Classroom cl = new Classroom();
			int day=new Date(usetime).getDay();
			if(day==1){
			if(jieshu.equals("1-2节")){
				cl.setRbuilding(building);
				cl.setRno(no);
				cl.setA12(status);
				cdao.updateStatus1(cl);
			}else if(jieshu.equals("3-4节")){
				cl.setRbuilding(building);
				cl.setRno(no);
				cl.setA34(status);
				cdao.updateStatus2(cl);
			}else if(jieshu.equals("5-6节")){
				cl.setRbuilding(building);
				cl.setRno(no);
				cl.setA56(status);
				cdao.updateStatus3(cl);
			}else if(jieshu.equals("7-8节")){
				cl.setRbuilding(building);
				cl.setRno(no);
				cl.setA78(status);
				cdao.updateStatus4(cl);
			}else if(jieshu.equals("9-10节")){
				cl.setRbuilding(building);
				cl.setRno(no);
				cl.setA90(status);
				cdao.updateStatus5(cl);
			}
			}else if(day==2){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setB12(status);
					cdao.updateStatus6(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setB34(status);
					cdao.updateStatus7(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setB56(status);
					cdao.updateStatus8(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setB78(status);
					cdao.updateStatus9(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setB90(status);
					cdao.updateStatus10(cl);
				}
			}else if(day==3){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setC12(status);
					cdao.updateStatus11(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setC34(status);
					cdao.updateStatus12(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setC56(status);
					cdao.updateStatus13(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setC78(status);
					cdao.updateStatus14(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setC90(status);
					cdao.updateStatus15(cl);
				}
			}else if(day==4){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setD12(status);
					cdao.updateStatus16(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setD34(status);
					cdao.updateStatus17(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setD56(status);
					cdao.updateStatus18(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setD78(status);
					cdao.updateStatus19(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setD90(status);
					cdao.updateStatus20(cl);
				}
			}else if(day==5){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setE12(status);
					cdao.updateStatus21(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setE34(status);
					cdao.updateStatus22(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setE56(status);
					cdao.updateStatus23(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setE78(status);
					cdao.updateStatus24(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setE90(status);
					cdao.updateStatus25(cl);
				}
			}else if(day==6){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setF12(status);
					cdao.updateStatus26(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setF34(status);
					cdao.updateStatus27(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setF56(status);
					cdao.updateStatus28(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setF78(status);
					cdao.updateStatus29(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setF90(status);
					cdao.updateStatus30(cl);
				}
			}else if(day==0){
				if(jieshu.equals("1-2节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setG12(status);
					cdao.updateStatus31(cl);
				}else if(jieshu.equals("3-4节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setG34(status);
					cdao.updateStatus32(cl);
				}else if(jieshu.equals("5-6节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setG56(status);
					cdao.updateStatus33(cl);
				}else if(jieshu.equals("7-8节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setG78(status);
					cdao.updateStatus34(cl);
				}else if(jieshu.equals("9-10节")){
					cl.setRbuilding(building);
					cl.setRno(no);
					cl.setG90(status);
					cdao.updateStatus35(cl);
				}
			}
		}else
		{
			out.println("<script language=javascript>");				
			out.println("alert('拒绝申请失败');");	
			out.println("window.location.href='SelectAllApplyAdmin'");			
			out.println("</script>");
		}
		out.flush();
		out.close();
		request.getRequestDispatcher("SelectAllApplyAdmin").forward(request, response);
	}

}
