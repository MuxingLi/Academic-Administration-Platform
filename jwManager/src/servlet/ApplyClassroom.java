package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import common.Decode;
import dao.ClassroomDao;
import dao.RoomApplyDao;
import dto.Classroom;
import dto.RoomApply;
import dto.Teacher;

public class ApplyClassroom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ApplyClassroom() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rbuilding=Decode.decode(request.getParameter("rbuilding"));
		String rno=Decode.decode(request.getParameter("rno"));
		ClassroomDao dao=new ClassroomDao();
		Classroom cl=new Classroom();
		cl.setRno(rno);
		cl.setRbuilding(rbuilding);
		cl=dao.selectClassroomById(cl);
		String[] m=cl.getRavailable();
		request.setAttribute("classrooms", cl);
		request.setAttribute("m", m);
		request.getRequestDispatcher("applyClassroom.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String building=Decode.decode(request.getParameter("building"));
		String no=Decode.decode(request.getParameter("no"));
		String type=Decode.decode(request.getParameter("type"));
		String seat=Decode.decode(request.getParameter("seat"));
		String media=Decode.decode(request.getParameter("media"));
		String time=Decode.decode(request.getParameter("time"));
		String jieshu=Decode.decode(request.getParameter("jieshu"));
		String week=Decode.decode(request.getParameter("week"));		
		String status=Decode.decode(request.getParameter("status"));		
		String remark=Decode.decode(request.getParameter("remark"));
		
		RoomApplyDao dao = new RoomApplyDao();
		RoomApply ra = new RoomApply();
		HttpSession session=request.getSession();
		Teacher tech=(Teacher)session.getAttribute("userinfo");
		ra.setBuilding(building);
		ra.setNo(no);
		ra.setId(tech.getId());
		ra.setType(type);
		ra.setSeat(seat);
		ra.setMedia(media);
		ra.setTime(time);
		ra.setJieshu(jieshu);
		ra.setUsetime(week);
		ra.setStatus(status);
		ra.setRemark(remark);

		int i=dao.insertApply(ra);
		if(i>0){
			out.println("<script language=javascript>");				
			out.println("alert('提交申请成功');");	
			out.println("window.location.href='SelectAllClassroomsServlet'");			
			out.println("</script>");
			ClassroomDao cdao = new ClassroomDao();
			Classroom cl1 = new Classroom();
			int day=new Date(week).getDay();
			if(day==1){
			if(jieshu.equals("1-2节")){
				cl1.setRbuilding(building);
				cl1.setRno(no);
				cl1.setA12(status);
				cdao.updateStatus1(cl1);
			}else if(jieshu.equals("3-4节")){
				cl1.setRbuilding(building);
				cl1.setRno(no);
				cl1.setA34(status);
				cdao.updateStatus2(cl1);
			}else if(jieshu.equals("5-6节")){
				cl1.setRbuilding(building);
				cl1.setRno(no);
				cl1.setA56(status);
				cdao.updateStatus3(cl1);
			}else if(jieshu.equals("7-8节")){
				cl1.setRbuilding(building);
				cl1.setRno(no);
				cl1.setA78(status);
				cdao.updateStatus4(cl1);
			}else if(jieshu.equals("9-10节")){
				cl1.setRbuilding(building);
				cl1.setRno(no);
				cl1.setA90(status);
				cdao.updateStatus5(cl1);
			}
			}else if(day==2){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setB12(status);
					cdao.updateStatus6(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setB34(status);
					cdao.updateStatus7(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setB56(status);
					cdao.updateStatus8(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setB78(status);
					cdao.updateStatus9(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setB90(status);
					cdao.updateStatus10(cl1);
				}
			}else if(day==3){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setC12(status);
					cdao.updateStatus11(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setC34(status);
					cdao.updateStatus12(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setC56(status);
					cdao.updateStatus13(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setC78(status);
					cdao.updateStatus14(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setC90(status);
					cdao.updateStatus15(cl1);
				}
			}else if(day==4){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setD12(status);
					cdao.updateStatus16(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setD34(status);
					cdao.updateStatus17(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setD56(status);
					cdao.updateStatus18(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setD78(status);
					cdao.updateStatus19(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setD90(status);
					cdao.updateStatus20(cl1);
				}
			}else if(day==5){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setE12(status);
					cdao.updateStatus21(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setE34(status);
					cdao.updateStatus22(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setE56(status);
					cdao.updateStatus23(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setE78(status);
					cdao.updateStatus24(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setE90(status);
					cdao.updateStatus25(cl1);
				}
			}else if(day==6){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setF12(status);
					cdao.updateStatus26(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setF34(status);
					cdao.updateStatus27(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setF56(status);
					cdao.updateStatus28(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setF78(status);
					cdao.updateStatus29(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setF90(status);
					cdao.updateStatus30(cl1);
				}
			}else if(day==0){
				if(jieshu.equals("1-2节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setG12(status);
					cdao.updateStatus31(cl1);
				}else if(jieshu.equals("3-4节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setG34(status);
					cdao.updateStatus32(cl1);
				}else if(jieshu.equals("5-6节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setG56(status);
					cdao.updateStatus33(cl1);
				}else if(jieshu.equals("7-8节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setG78(status);
					cdao.updateStatus34(cl1);
				}else if(jieshu.equals("9-10节")){
					cl1.setRbuilding(building);
					cl1.setRno(no);
					cl1.setG90(status);
					cdao.updateStatus35(cl1);
				}
			}
		}else
		{
			out.println("<script language=javascript>");				
			out.println("alert('提交申请失败');");	
			out.println("window.location.href='applyClassroom.jsp'");			
			out.println("</script>");
		}
		out.flush();
		out.close();
	}
}
