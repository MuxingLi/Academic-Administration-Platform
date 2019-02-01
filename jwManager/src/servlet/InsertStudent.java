package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.CourseArrangeDao;
import dao.CourseDao;
import dao.ProgramDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import dao.TeacherCourseDao;
import dao.TeacherDao;
import dto.Course;
import dto.CourseArrange;
import dto.Program;
import dto.Student;
import dto.StudentCourse;
import dto.Teacher;
import dto.TeacherCourse;

public class InsertStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InsertStudent() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String stuid=request.getParameter("stuid");
		String stuname=Decode.decode(request.getParameter("stuname"));
		String stusex=Decode.decode(request.getParameter("stusex"));
		String stubirth=request.getParameter("stubirth");
		String stunation=Decode.decode(request.getParameter("stunation"));
		String stuidentity=request.getParameter("stuidentity");
		String stulook=Decode.decode(request.getParameter("stulook"));
		String stubirthplace=Decode.decode(request.getParameter("stubirthplace"));
		String stutel=Decode.decode(request.getParameter("stutel"));
		String stucontacter=Decode.decode(request.getParameter("stucontacter"));
		String stuhometel=request.getParameter("stuhometel");
		String stuaddress=Decode.decode(request.getParameter("stuaddress"));
		String stuemail=request.getParameter("stuemail");
		String stuenterdate=request.getParameter("stuenterdate");
		String stuleavedate=request.getParameter("stuleavedate");
		String studepartment=Decode.decode(request.getParameter("studepartment"));
		String stumajor=Decode.decode(request.getParameter("stumajor"));
		String stuclassid=request.getParameter("stuclassid");
		String stustatus=Decode.decode(request.getParameter("stustatus"));
		String sturoomid=Decode.decode(request.getParameter("sturoomid"));
		String sturemark=Decode.decode(request.getParameter("sturemark"));
		String password=(request.getParameter("password"));
		String role=Decode.decode(request.getParameter("role"));
		
		StudentDao dao=new StudentDao();
		Student s=new Student();
		s.setId(stuid);
		s.setName(stuname);
		s.setStusex(stusex);
		s.setStubirth(stubirth);
		s.setStunation(stunation);
		s.setStuidentity(stuidentity);
		s.setStulook(stulook);
		s.setStubirthplace(stubirthplace);
		s.setStutel(stutel);
		s.setStucontacter(stucontacter);
		s.setStuhometel(stuhometel);
		s.setStuaddress(stuaddress);
		s.setStuemail(stuemail);
		s.setStuenterdate(stuenterdate);
		s.setStuleavedate(stuleavedate);
		s.setStudepartment(studepartment);
		s.setStumajor(stumajor);
		s.setStuclassid(stuclassid);
		s.setStustatus(stustatus);
		s.setSturoomid(sturoomid);
		s.setSturemark(sturemark);	
		s.setPassword(password);	
		s.setRole(role);	
		int i=dao.insertStudent(s);
		if(i>0){
			out.println("<script language=javascript>");
			out.println("alert('增添学生信息成功');");
			out.println("</script>");
//获取学生id dept name  直接使用s
//建立空间中转信息
			ProgramDao pdao = new ProgramDao();
			Program p = new Program();
			CourseDao cdao = new CourseDao();
			Course c1 = new Course();//1门
			Course c2 = new Course();//2门
			Course c3 = new Course();//3门
			Course c4 = new Course();//4门
			Teacher t = new Teacher();//教师课表
			TeacherDao tdao = new TeacherDao();
//准备插入sc表的相关dto dao   && 插入课程表的dto  dao
			StudentCourse sc=new StudentCourse();
			StudentCourse sc1=new StudentCourse();
			StudentCourseDao scdao=new StudentCourseDao();
			CourseArrange ca=new CourseArrange();
			CourseArrangeDao cadao = new CourseArrangeDao();
			TeacherCourseDao tcdao = new TeacherCourseDao();
			TeacherCourse tc = new TeacherCourse();
			TeacherCourse tc1 = new TeacherCourse();
//获得年份 eg.2013 第一学期-》2013-2014（cyear）【入学年份-入学年份+1】
			String y = stuid.substring(0,4);
			int year = Integer.parseInt(y);
			String cyear;
//通过学生院系 调出教学计划-第一学期
			p.setDept(studepartment);
			p.setTerm("第一学期");
			Program p1 = new Program();//1
			p1=pdao.selectProgramByDT(p);//获得某系第一学期教学计划所有内容
//在第一学期中 令year=year-year+1 秋季->在课程信息中已包含
			cyear= year+"-"+(year+1);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1的所有课程信息
			c1=cdao.selectCourseById(p1.getCid1());
	//获取cid1的上课地点
			String cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p1.getCid1());
		//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
		//将课程插入课程表中
			sc1=scdao.selectByIC(stuid,p1.getCid1());
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setStudentCourse(sc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
	//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
	//cid2,cid3,cid4
			if(!"".equals(p1.getCid2())){
				c2=cdao.selectCourseById(p1.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p1.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p1.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p1.getCid3())){
					c3=cdao.selectCourseById(p1.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p1.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p1.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p1.getCid4())){
						c4=cdao.selectCourseById(p1.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p1.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p1.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}
//通过学生院系 调出教学计划-第二学期
			p.setTerm("第二学期");
			Program p2 = new Program();//2
			p2=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
//在第二学期中 令year=year-year+1 春季->在课程信息中已包含
			cyear= year+"-"+(year+1);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p2.getCid1());
	//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p2.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p2.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setStudentCourse(sc1);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
	//cid2,cid3,cid4
			if(!"".equals(p2.getCid2())){
				c2=cdao.selectCourseById(p2.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p2.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p2.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p2.getCid3())){
					c3=cdao.selectCourseById(p2.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p2.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p2.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p2.getCid4())){
						c4=cdao.selectCourseById(p2.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p2.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p2.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
						//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}
//通过学生院系 调出教学计划-第三学期
			p.setTerm("第三学期");
			Program p3 = new Program();//2
			p3=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
//在第san学期中
			cyear= (year+1)+"-"+(year+2);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p3.getCid1());
		//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p3.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p3.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setCayear(cyear);
			ca.setStudentCourse(sc1);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
			if(!"".equals(p3.getCid2())){
				c2=cdao.selectCourseById(p3.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p3.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p3.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p3.getCid3())){
					c3=cdao.selectCourseById(p3.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p3.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p3.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p3.getCid4())){
						c4=cdao.selectCourseById(p3.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p3.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p3.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}
//通过学生院系 调出教学计划-第四学期			
			p.setTerm("第四学期");
			Program p4 = new Program();//2
			p4=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
			cyear= (year+1)+"-"+(year+2);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p4.getCid1());
	//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p4.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p4.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setStudentCourse(sc1);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
	//cid2,cid3,cid4
			if(!"".equals(p4.getCid2())){
				c2=cdao.selectCourseById(p4.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p4.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p4.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p4.getCid3())){
					c3=cdao.selectCourseById(p4.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p4.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p4.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p4.getCid4())){
						c4=cdao.selectCourseById(p4.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p4.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p4.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}	
//通过学生院系 调出教学计划-第五学期
			p.setTerm("第五学期");
			Program p5 = new Program();//2
			p5=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
//在第五学期中
			cyear= (year+2)+"-"+(year+3);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p5.getCid1());
		//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p5.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p5.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setCayear(cyear);
			ca.setStudentCourse(sc1);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
			if(!"".equals(p5.getCid2())){
				c2=cdao.selectCourseById(p5.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p5.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p5.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p5.getCid3())){
					c3=cdao.selectCourseById(p5.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p5.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p5.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p5.getCid4())){
						c4=cdao.selectCourseById(p5.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p5.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p5.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}			
//通过学生院系 调出教学计划-第六学期			
			p.setTerm("第六学期");
			Program p6 = new Program();//2
			p6=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
			cyear= (year+2)+"-"+(year+3);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p6.getCid1());
	//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p6.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p6.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setStudentCourse(sc1);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
			if(tcdao.selectByIC(t.getId(), c1.getCid(),c1.getCterm(),cyear)==null){
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			}
	//cid2,cid3,cid4
			if(!"".equals(p6.getCid2())){
				c2=cdao.selectCourseById(p6.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p6.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p6.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
				if(tcdao.selectByIC(t.getId(), c2.getCid(),c2.getCterm(),cyear)==null){
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				}
				if(!"".equals(p6.getCid3())){
					c3=cdao.selectCourseById(p6.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p6.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p6.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
					if(tcdao.selectByIC(t.getId(), c3.getCid(),c3.getCterm(),cyear)==null){
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					}
					if(!"".equals(p6.getCid4())){
						c4=cdao.selectCourseById(p6.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p6.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p6.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
						if(tcdao.selectByIC(t.getId(), c4.getCid(),c4.getCterm(),cyear)==null){
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
						}
					}
				}
			}			
//通过学生院系 调出教学计划-第七学期
			p.setTerm("第七学期");
			Program p7 = new Program();//2
			p7=pdao.selectProgramByDT(p);//获得某系第二学期教学计划所有内容
//在第七学期中
			cyear= (year+3)+"-"+(year+4);
	//通过第一学期计划 获取课程id 从而获取所有课程信息
	//cid1
			c1=cdao.selectCourseById(p7.getCid1());
		//将课程插入sc表中
			sc.setCyear(cyear);
			sc.setId(stuid);
			cplace=pdao.selectProgramByDTC1(studepartment,p.getTerm(),p7.getCid1());
			c1.setCplace(cplace);
			sc.setCourse(c1);
			sc.setStudent(s);
			scdao.insertStudentCourse(sc);
			sc1=scdao.selectByIC(stuid,p7.getCid1());
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c1);
			ca.setStudentCourse(sc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(stuid,cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange1(ca);
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
		//将课程插入tc表中
			tc.setCyear(cyear);
			tc.setId(t.getId());
			tc.setName(t.getName());
			c1.setCplace(cplace);
			tc.setCourse(c1);
			tcdao.insertTeacherCourse(tc);
		//将课程插入课表中----教师
			tc1=tcdao.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear);
			ca.setId(t.getId());
			ca.setCourse(c1);
			ca.setTeacherCourse(tc1);
			ca.setCayear(cyear);
			ca.setCaterm(c1.getCterm());
			if(cadao.panduan(t.getId(),cyear,c1.getCterm())==null){
				cadao.insertCourseArrange(ca);
			}			
			cadao.insertCourseArrange3(ca);
			if(!"".equals(p7.getCid2())){
				c2=cdao.selectCourseById(p7.getCid2());
				cplace=pdao.selectProgramByDTC2(studepartment,p.getTerm(),p7.getCid2());
				c2.setCplace(cplace);
				sc.setCourse(c2);
				scdao.insertStudentCourse(sc);//将cid2课程插入sc表
				sc1=scdao.selectByIC(stuid,p7.getCid2());
				ca.setCourse(c2);
				ca.setStudentCourse(sc1);
				cadao.insertCourseArrange1(ca);//将cid2课程插入课程表
			//获取上课教师---获取教师id和姓名
				t=tdao.selectTeacherByName(c2.getCteacher());
			//将课程插入tc表中
				tc.setCyear(cyear);
				tc.setId(t.getId());
				tc.setName(t.getName());
				c2.setCplace(cplace);
				tc.setCourse(c2);
				tcdao.insertTeacherCourse(tc);
			//将课程插入课表中----教师
				tc1=tcdao.selectByIC(t.getId(),c2.getCid(),c2.getCterm(),cyear);
				ca.setId(t.getId());
				ca.setCourse(c2);
				ca.setTeacherCourse(tc1);
				ca.setCayear(cyear);
				ca.setCaterm(c2.getCterm());
				if(cadao.panduan(t.getId(),cyear,c2.getCterm())==null){
					cadao.insertCourseArrange(ca);
				}			
				cadao.insertCourseArrange3(ca);
				if(!"".equals(p7.getCid3())){
					c3=cdao.selectCourseById(p7.getCid3());
					cplace=pdao.selectProgramByDTC3(studepartment,p.getTerm(),p7.getCid3());
					c3.setCplace(cplace);
					sc.setCourse(c3);
					scdao.insertStudentCourse(sc);//将cid3课程插入sc表
					sc1=scdao.selectByIC(stuid,p7.getCid3());
					ca.setCourse(c3);
					ca.setStudentCourse(sc1);
					cadao.insertCourseArrange1(ca);//将cid3课程插入课程表
				//获取上课教师---获取教师id和姓名
					t=tdao.selectTeacherByName(c3.getCteacher());
				//将课程插入tc表中
					tc.setCyear(cyear);
					tc.setId(t.getId());
					tc.setName(t.getName());
					c3.setCplace(cplace);
					tc.setCourse(c3);
					tcdao.insertTeacherCourse(tc);
				//将课程插入课表中----教师
					tc1=tcdao.selectByIC(t.getId(),c3.getCid(),c3.getCterm(),cyear);
					ca.setId(t.getId());
					ca.setCourse(c3);
					ca.setTeacherCourse(tc1);
					ca.setCayear(cyear);
					ca.setCaterm(c3.getCterm());
					if(cadao.panduan(t.getId(),cyear,c3.getCterm())==null){
						cadao.insertCourseArrange(ca);
					}			
					cadao.insertCourseArrange3(ca);
					if(!"".equals(p7.getCid4())){
						c4=cdao.selectCourseById(p7.getCid4());
						cplace=pdao.selectProgramByDTC4(studepartment,p.getTerm(),p4.getCid4());
						c4.setCplace(cplace);
						sc.setCourse(c4);
						scdao.insertStudentCourse(sc);//将cid4课程插入sc表
						sc1=scdao.selectByIC(stuid,p4.getCid4());
						ca.setCourse(c4);
						ca.setStudentCourse(sc1);
						cadao.insertCourseArrange1(ca);//将cid4课程插入课程表
					//获取上课教师---获取教师id和姓名
						t=tdao.selectTeacherByName(c4.getCteacher());
					//将课程插入tc表中
						tc.setCyear(cyear);
						tc.setId(t.getId());
						tc.setName(t.getName());
						c4.setCplace(cplace);
						tc.setCourse(c4);
						tcdao.insertTeacherCourse(tc);
					//将课程插入课表中----教师
						tc1=tcdao.selectByIC(t.getId(),c4.getCid(),c4.getCterm(),cyear);
						ca.setId(t.getId());
						ca.setCourse(c4);
						ca.setTeacherCourse(tc1);
						ca.setCayear(cyear);
						ca.setCaterm(c4.getCterm());
						if(cadao.panduan(t.getId(),cyear,c4.getCterm())==null){
							cadao.insertCourseArrange(ca);
						}			
						cadao.insertCourseArrange3(ca);
					}
				}
			}						
//在第八学期中
			cyear= (year+3)+"-"+(year+4);
//无课程计划   无必修课程
			Course c8 = new Course();
//			c8.setCterm("春季");
		//将课程插入课程表中
			ca.setId(stuid);
			ca.setCourse(c8);
			ca.setCayear(cyear);
			ca.setCaterm("春季");
			if(cadao.panduan(stuid,cyear,"春季")==null){
				cadao.insertCourseArrange(ca);
			}
		//获取上课教师---获取教师id和姓名
			t=tdao.selectTeacherByName(c1.getCteacher());
		//将课程插入课表中----教师
			ca.setId(t.getId());
			ca.setCourse(c8);
			ca.setCayear(cyear);
			ca.setCaterm("春季");
			if(cadao.panduan(t.getId(),cyear,"春季")==null){
				cadao.insertCourseArrange(ca);
			}			
			
		response.sendRedirect("SelectAllStudentsServlet");
		}else
		{
			out.println("<script language=javascript>");
			out.println("alert('增添学生信息失败');");
			out.println("window.location.href='insertStudent.jsp'");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}

}
