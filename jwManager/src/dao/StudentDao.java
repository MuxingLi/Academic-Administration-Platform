package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Statement;

import common.DBUtil;
import dto.Course;
import dto.CourseArrange;
import dto.Program;
import dto.Student;
import dto.StudentCourse;
import dto.Teacher;
import dto.TeacherCourse;

public class StudentDao {

	public Student login(Student user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student where id=? ");
			ps.setString(1, user.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				Student s = new Student();
				s.setId(rs.getString("id"));
				s.setRole(rs.getString("role"));
				s.setPassword(rs.getString("password"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public int insertStudent(Student studentinfo){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,studentinfo.getId());
			ps.setString(2,studentinfo.getName());
			ps.setString(3,studentinfo.getStupic());
			ps.setString(4,studentinfo.getStusex());
			ps.setString(5,studentinfo.getStubirth());
			ps.setString(6,studentinfo.getStunation());
			ps.setString(7,studentinfo.getStuidentity());
			ps.setString(8,studentinfo.getStulook());
			ps.setString(9,studentinfo.getStubirthplace());
			ps.setString(10,studentinfo.getStutel());
			ps.setString(11,studentinfo.getStucontacter());
			ps.setString(12,studentinfo.getStuhometel());
			ps.setString(13,studentinfo.getStuaddress());
			ps.setString(14,studentinfo.getStuemail());
			ps.setString(15,studentinfo.getStuenterdate());
			ps.setString(16,studentinfo.getStuleavedate());
			ps.setString(17,studentinfo.getStudepartment());
			ps.setString(18,studentinfo.getStumajor());
			ps.setString(19,studentinfo.getStuclassid());
			ps.setString(20,studentinfo.getStustatus());
			ps.setString(21,studentinfo.getSturoomid());
			ps.setString(22,studentinfo.getSturemark());
			ps.setString(23,studentinfo.getPassword());
			ps.setString(24,studentinfo.getRole());
			DBUtil.beginTrans(conn);
			int i=ps.executeUpdate();
			DBUtil.endTrans(conn);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}
	public int deleteStudentById(String stuid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from student where id=?");
			ps.setString(1, stuid);
			DBUtil.beginTrans(conn);
			int i = ps.executeUpdate();
			DBUtil.endTrans(conn);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}
	public int updateStudentpwd(Student studentpwd) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update student set password=? where id=?");
			ps.setString(1, studentpwd.getPassword());
			ps.setString(2, studentpwd.getId());
			DBUtil.beginTrans(conn);
			int i = ps.executeUpdate();
			DBUtil.endTrans(conn);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}
	public int updateStudent(Student student) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update student set name=?,stupic=?,stusex=?,"
					+ "stubirth=?,stunation=?,stuidentity=?,stulook=?,stubirthplace=?,stutel=?,"
					+ "stucontacter=?,stuhometel=?,stuaddress=?,stuemail=?,stuenterdate=?,"
					+ "stuleavedate=?,studepartment=?,stumajor=?,stuclassid=?,stustatus=?,"
					+ "sturoomid=?,sturemark=? where id=?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getStupic());
			ps.setString(3, student.getStusex());
			ps.setString(4, student.getStubirth());
			ps.setString(5, student.getStunation());
			ps.setString(6, student.getStuidentity());
			ps.setString(7, student.getStulook());
			ps.setString(8, student.getStubirthplace());
			ps.setString(9, student.getStutel());
			ps.setString(10, student.getStucontacter());
			ps.setString(11, student.getStuhometel());
			ps.setString(12, student.getStuaddress());
			ps.setString(13, student.getStuemail());
			ps.setString(14, student.getStuenterdate());
			ps.setString(15, student.getStuleavedate());
			ps.setString(16, student.getStudepartment());
			ps.setString(17, student.getStumajor());
			ps.setString(18, student.getStuclassid());
			ps.setString(19, student.getStustatus());
			ps.setString(20, student.getSturoomid());
			ps.setString(21, student.getSturemark());
			ps.setString(22, student.getId());
			DBUtil.beginTrans(conn);
			int i = ps.executeUpdate();
			DBUtil.endTrans(conn);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.clearAll(conn, ps);
		}
		return 0;

	}
	public ArrayList<Student> selectAllStudents() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student");
			//排除密码字段 不显示
			rs = ps.executeQuery();
			ArrayList<Student> students = new ArrayList<Student>();
			while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getString("id"));
			s.setName(rs.getString("name"));
			s.setStupic(rs.getString("stupic"));
			s.setStusex(rs.getString("stusex"));
			s.setStubirth(rs.getString("stubirth"));
			s.setStunation(rs.getString("stunation"));
			s.setStuidentity(rs.getString("stuidentity"));
			s.setStulook(rs.getString("stulook"));
			s.setStubirthplace(rs.getString("stubirthplace"));
			s.setStutel(rs.getString("stutel"));
			s.setStucontacter(rs.getString("stucontacter"));
			s.setStuhometel(rs.getString("stuhometel"));
			s.setStuaddress(rs.getString("stuaddress"));
			s.setStuemail(rs.getString("stuemail"));
			s.setStuenterdate(rs.getString("stuenterdate"));
			s.setStuleavedate(rs.getString("stuleavedate"));			
			s.setStudepartment(rs.getString("studepartment"));
			s.setStumajor(rs.getString("stumajor"));
			s.setStuclassid(rs.getString("stuclassid"));
			s.setStustatus(rs.getString("stustatus"));
			s.setSturoomid(rs.getString("sturoomid"));
			s.setSturemark(rs.getString("sturemark"));
			students.add(s);
			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//查询
	public Student selectStudentById(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
			Student s = new Student();
			s.setId(rs.getString("id"));
			s.setName(rs.getString("name"));
			s.setStupic(rs.getString("stupic"));
			s.setStusex(rs.getString("stusex"));
			s.setStubirth(rs.getString("stubirth"));
			s.setStunation(rs.getString("stunation"));
			s.setStuidentity(rs.getString("stuidentity"));
			s.setStulook(rs.getString("stulook"));
			s.setStubirthplace(rs.getString("stubirthplace"));
			s.setStutel(rs.getString("stutel"));
			s.setStucontacter(rs.getString("stucontacter"));
			s.setStuhometel(rs.getString("stuhometel"));
			s.setStuaddress(rs.getString("stuaddress"));
			s.setStuemail(rs.getString("stuemail"));
			s.setStuenterdate(rs.getString("stuenterdate"));
			s.setStuleavedate(rs.getString("stuleavedate"));			
			s.setStudepartment(rs.getString("studepartment"));
			s.setStumajor(rs.getString("stumajor"));
			s.setStuclassid(rs.getString("stuclassid"));
			s.setStustatus(rs.getString("stustatus"));
			s.setSturoomid(rs.getString("sturoomid"));
			s.setSturemark(rs.getString("sturemark"));
			return s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Student selectStudentById(Student student) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student where id=?");
			ps.setString(1,student.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
			Student s = new Student();
			s.setId(rs.getString("id"));
			s.setName(rs.getString("name"));
			return s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public int insertDB(String fileid,String filename,String filepath)
	{	
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try{
			filename=filepath+"\\"+filename;
			//FileInputStream f=new FileInputStream(filename);
			XSSFWorkbook workbook = new XSSFWorkbook(filename);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = null;
			XSSFCell cell = null;
			row=sheet.getRow((short)0);
			int totalrow=sheet.getLastRowNum();
			Student student=null;
			try{
				System.out.println("生成句柄成功");
			}
			catch(Exception ex)
			{
				System.out.println("生成句柄失败");
			}
			int j = 0;
			String id;
			String name;
			String stupic;
			String stusex;
			String stubirth;
			String stunation;
			String stuidentity;
			String stulook;
			String stubirthplace;
			String stutel;
			String stucontacter;
			String stuhometel;
			String stuaddress;
			String stuemail;
			String stuenterdate;
			String stuleavedate;
			String studepartment;
			String stumajor;
			String stuclassid;
			String stustatus;
			String sturoomid;
			String sturemark;
			String password;
			String role;
			for(short i=1;i<=totalrow;i++)
			{
				student = new Student();
				row=sheet.getRow(i);
				cell=row.getCell((short)0);
				if(cell!=null)
				{
					id=cell.toString();
					student.setId(id);
				}
				cell=row.getCell((short)1);
				if(cell!=null)
				{
					name=cell.toString();
					student.setName(name);
				}
				cell=row.getCell((short)2);
				if(cell!=null)
				{
					stupic=cell.toString();
					student.setStupic(stupic);
				}
				cell=row.getCell((short)3);
				if(cell!=null)
				{
					stusex=cell.toString();
					student.setStusex(stusex);
				}
				cell=row.getCell((short)4);
				if(cell!=null)
				{
					stubirth=cell.toString();
					student.setStubirth(stubirth);
				}
				cell=row.getCell((short)5);
				if(cell!=null)
				{
					stunation=cell.toString();
					student.setStunation(stunation);
				}
				cell=row.getCell((short)6);
				if(cell!=null)
				{
					stuidentity=cell.toString();
					student.setStuidentity(stuidentity);
				}
				cell=row.getCell((short)7);
				if(cell!=null)
				{
					stulook=cell.toString();
					student.setStulook(stulook);
				}
				cell=row.getCell((short)8);
				if(cell!=null)
				{
					stubirthplace=cell.toString();
					student.setStubirthplace(stubirthplace);
				}
				cell=row.getCell((short)9);
				if(cell!=null)
				{
					stutel=cell.toString();
					student.setStutel(stutel);
				}
				cell=row.getCell((short)10);
				if(cell!=null)
				{
					stucontacter=cell.toString();
					student.setStucontacter(stucontacter);
				}
				cell=row.getCell((short)11);
				if(cell!=null)
				{
					stuhometel=cell.toString();
					student.setStuhometel(stuhometel);
				}
				cell=row.getCell((short)12);
				if(cell!=null)
				{
					stuaddress=cell.toString();
					student.setStuaddress(stuaddress);
				}cell=row.getCell((short)13);
				if(cell!=null)
				{
					stuemail=cell.toString();
					student.setStuemail(stuemail);
				}
				cell=row.getCell((short)14);
				if(cell!=null)
				{
					stuenterdate=cell.toString();
					student.setStuenterdate(stuenterdate);
				}
				cell=row.getCell((short)15);
				if(cell!=null)
				{
					stuleavedate=cell.toString();
					student.setStuleavedate(stuleavedate);
				}
				cell=row.getCell((short)16);
				if(cell!=null)
				{
					studepartment=cell.toString();
					student.setStudepartment(studepartment);
				}
				cell=row.getCell((short)17);
				if(cell!=null)
				{
					stumajor=cell.toString();
					student.setStumajor(stumajor);
				}
				cell=row.getCell((short)18);
				if(cell!=null)
				{
					stuclassid=cell.toString();
					student.setStuclassid(stuclassid);
				}
				cell=row.getCell((short)19);
				if(cell!=null)
				{
					stustatus=cell.toString();
					student.setStustatus(stustatus);
				}
				cell=row.getCell((short)20);
				if(cell!=null)
				{
					sturoomid=cell.toString();
					student.setSturoomid(sturoomid);
				}
				cell=row.getCell((short)21);
				if(cell!=null)
				{
					sturemark=cell.toString();
					student.setSturemark(sturemark);
				}
				cell=row.getCell((short)22);
				if(cell!=null)
				{
					password=cell.toString();
					student.setPassword(password);
				}
				cell=row.getCell((short)23);
				if(cell!=null)
				{
					role=cell.toString();
					student.setRole(role);
				}
				ps=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,student.getId());
				ps.setString(2,student.getName());
				ps.setString(3,student.getStupic());
				ps.setString(4,student.getStusex());
				ps.setString(5,student.getStubirth());
				ps.setString(6,student.getStunation());
				ps.setString(7,student.getStuidentity());
				ps.setString(8,student.getStulook());
				ps.setString(9,student.getStubirthplace());
				ps.setString(10,student.getStutel());
				ps.setString(11,student.getStucontacter());
				ps.setString(12,student.getStuhometel());
				ps.setString(13,student.getStuaddress());
				ps.setString(14,student.getStuemail());
				ps.setString(15,student.getStuenterdate());
				ps.setString(16,student.getStuleavedate());
				ps.setString(17,student.getStudepartment());
				ps.setString(18,student.getStumajor());
				ps.setString(19,student.getStuclassid());
				ps.setString(20,student.getStustatus());
				ps.setString(21,student.getSturoomid());
				ps.setString(22,student.getSturemark());
				ps.setString(23,student.getPassword());
				ps.setString(24,student.getRole());
				DBUtil.beginTrans(conn);
				j=ps.executeUpdate();
				DBUtil.endTrans(conn);
//————————————————————————————————————————————————开始插入教学计划—————————————————————————————————————————
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
				String y = student.getId().substring(0,4);
				int year = Integer.parseInt(y);
				String cyear;
	//通过学生院系 调出教学计划-第一学期
				p.setDept(student.getStudepartment());
				p.setTerm("第一学期");
				Program p1 = new Program();//1
				p1=pdao.selectProgramByDT(p);//获得某系第一学期教学计划所有内容
	//在第一学期中 令year=year-year+1 秋季->在课程信息中已包含
				cyear= year+"-"+(year+1);
		//通过第一学期计划 获取课程id 从而获取所有课程信息
		//cid1的所有课程信息
				c1=cdao.selectCourseById(p1.getCid1());
		//获取cid1的上课地点
				String cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p1.getCid1());
			//将课程插入sc表中
				sc.setCyear(cyear);
				sc.setId(student.getId());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
			//将课程插入课程表中
				sc1=scdao.selectByIC(student.getId(),p1.getCid1());
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setStudentCourse(sc1);
				ca.setCayear(cyear);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p1.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p1.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p1.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p1.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p1.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p1.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p2.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p2.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setStudentCourse(sc1);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p2.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p2.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p2.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p2.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p2.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p2.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p3.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p3.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setCayear(cyear);
				ca.setStudentCourse(sc1);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p3.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p3.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p3.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p3.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p3.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p3.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p4.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p4.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setStudentCourse(sc1);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p4.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p4.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p4.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p4.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p4.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p4.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p5.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p5.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setCayear(cyear);
				ca.setStudentCourse(sc1);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p5.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p5.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p5.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p5.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p5.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p5.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p6.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p6.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setStudentCourse(sc1);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p6.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p6.getCid2());
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
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p6.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p6.getCid3());
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
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p6.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p6.getCid4());
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
				sc.setId(student.getId());
				cplace=pdao.selectProgramByDTC1(student.getStudepartment(),p.getTerm(),p7.getCid1());
				c1.setCplace(cplace);
				sc.setCourse(c1);
				sc.setStudent(student);
				scdao.insertStudentCourse(sc);
				sc1=scdao.selectByIC(student.getId(),p7.getCid1());
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c1);
				ca.setStudentCourse(sc1);
				ca.setCayear(cyear);
				ca.setCaterm(c1.getCterm());
				if(cadao.panduan(student.getId(),cyear,c1.getCterm())==null){
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
				if(!"".equals(p7.getCid2())){
					c2=cdao.selectCourseById(p7.getCid2());
					cplace=pdao.selectProgramByDTC2(student.getStudepartment(),p.getTerm(),p7.getCid2());
					c2.setCplace(cplace);
					sc.setCourse(c2);
					scdao.insertStudentCourse(sc);//将cid2课程插入sc表
					sc1=scdao.selectByIC(student.getId(),p7.getCid2());
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
					if(!"".equals(p7.getCid3())){
						c3=cdao.selectCourseById(p7.getCid3());
						cplace=pdao.selectProgramByDTC3(student.getStudepartment(),p.getTerm(),p7.getCid3());
						c3.setCplace(cplace);
						sc.setCourse(c3);
						scdao.insertStudentCourse(sc);//将cid3课程插入sc表
						sc1=scdao.selectByIC(student.getId(),p7.getCid3());
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
						if(!"".equals(p7.getCid4())){
							c4=cdao.selectCourseById(p7.getCid4());
							cplace=pdao.selectProgramByDTC4(student.getStudepartment(),p.getTerm(),p4.getCid4());
							c4.setCplace(cplace);
							sc.setCourse(c4);
							scdao.insertStudentCourse(sc);//将cid4课程插入sc表
							sc1=scdao.selectByIC(student.getId(),p4.getCid4());
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
	//在第八学期中
				cyear= (year+3)+"-"+(year+4);
	//无课程计划   无必修课程
				Course c8 = new Course();
//				c8.setCterm("春季");
			//将课程插入课程表中
				ca.setId(student.getId());
				ca.setCourse(c8);
				ca.setCayear(cyear);
				ca.setCaterm("春季");
				if(cadao.panduan(student.getId(),cyear,"春季")==null){
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
		}	return j;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			DBUtil.rollback(conn);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			DBUtil.rollback(conn);
		}
		finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}
//院系下拉列表
	public ArrayList<Student> depart() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement("select DISTINCT studepartment from student");
			rs = ps.executeQuery();
			while (rs.next()) {
			Student s = new Student();
			s.setStudepartment(rs.getString("studepartment"));
			students.add(s);
			}return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//分页
	public ArrayList<Student> fenye(int dangqianPage){
		ArrayList<Student> stuFY = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Student s = new Student();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setStupic(rs.getString("stupic"));
				s.setStusex(rs.getString("stusex"));
				s.setStubirth(rs.getString("stubirth"));
				s.setStunation(rs.getString("stunation"));
				s.setStuidentity(rs.getString("stuidentity"));
				s.setStulook(rs.getString("stulook"));
				s.setStubirthplace(rs.getString("stubirthplace"));
				s.setStutel(rs.getString("stutel"));
				s.setStucontacter(rs.getString("stucontacter"));
				s.setStuhometel(rs.getString("stuhometel"));
				s.setStuaddress(rs.getString("stuaddress"));
				s.setStuemail(rs.getString("stuemail"));
				s.setStuenterdate(rs.getString("stuenterdate"));
				s.setStuleavedate(rs.getString("stuleavedate"));			
				s.setStudepartment(rs.getString("studepartment"));
				s.setStumajor(rs.getString("stumajor"));
				s.setStuclassid(rs.getString("stuclassid"));
				s.setStustatus(rs.getString("stustatus"));
				s.setSturoomid(rs.getString("sturoomid"));
				s.setSturemark(rs.getString("sturemark"));
				stuFY.add(s);
			}return stuFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//查询总的记录数
	public int sumData() {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student");
			rs = ps.executeQuery();		
			rs.last();
			sumData = rs.getRow();
			return sumData;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return 0;
	}
//查询总页数
	public int sumPageCount() {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData();
			if(sumPage%8==0){
				sumPageCount=sumPage/8;
			}else{
				sumPageCount=sumPage/8+1;
			}return sumPageCount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
//查询-分页
	public ArrayList<Student> fenye1(int dangqianPage,String id, String name, String cid, String dept){
		ArrayList<Student> stuFY = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student where (id like '%"+id+"%' and name like '%"+name+"%'"
					+ " and stuclassid like '%"+cid+"%' and studepartment like '%"+dept+"%')"
							+ " limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Student s = new Student();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setStupic(rs.getString("stupic"));
				s.setStusex(rs.getString("stusex"));
				s.setStubirth(rs.getString("stubirth"));
				s.setStunation(rs.getString("stunation"));
				s.setStuidentity(rs.getString("stuidentity"));
				s.setStulook(rs.getString("stulook"));
				s.setStubirthplace(rs.getString("stubirthplace"));
				s.setStutel(rs.getString("stutel"));
				s.setStucontacter(rs.getString("stucontacter"));
				s.setStuhometel(rs.getString("stuhometel"));
				s.setStuaddress(rs.getString("stuaddress"));
				s.setStuemail(rs.getString("stuemail"));
				s.setStuenterdate(rs.getString("stuenterdate"));
				s.setStuleavedate(rs.getString("stuleavedate"));			
				s.setStudepartment(rs.getString("studepartment"));
				s.setStumajor(rs.getString("stumajor"));
				s.setStuclassid(rs.getString("stuclassid"));
				s.setStustatus(rs.getString("stustatus"));
				s.setSturoomid(rs.getString("sturoomid"));
				s.setSturemark(rs.getString("sturemark"));
				stuFY.add(s);
			}return stuFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//查询-总记录数
		public int sumData1(String id, String name, String cid, String dept) {
			int sumData=0;
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("select * from student where (id like '%"+id+"%' and name like '%"+name+"%'"
					+ " and stuclassid like '%"+cid+"%' and studepartment like '%"+dept+"%')");
				rs = ps.executeQuery();		
				rs.last();
				sumData = rs.getRow();
				return sumData;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.clearAll(conn, ps, rs);
			}		
			return 0;
		}
//查询-总页数
		public int sumPageCount1(String id, String name, String cid, String dept) {
			try {
				int sumPageCount=0;
				int sumPage=this.sumData1(id,name,cid,dept);
				if(sumPage%8==0){
					sumPageCount=sumPage/8;
				}else{
					sumPageCount=sumPage/8+1;
				}return sumPageCount;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return 0;
		}

}
