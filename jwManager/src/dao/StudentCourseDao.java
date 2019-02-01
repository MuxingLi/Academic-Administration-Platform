package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import dto.Classroom;
import dto.Course;
import dto.StudentCourse;

public class StudentCourseDao {
	public int insertStudentCourse(StudentCourse sc){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into studentcourse(id,cyear,name,cid,cname,cterm,cshangke,cteacher,ctype,cexam,cweekday1,cjieshu1,cweekday2,cjieshu2,cweekday3,cjieshu3,cplace) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,sc.getId());
			ps.setString(2,sc.getCyear());
			ps.setString(3,sc.getStudent().getName());
			ps.setString(4,sc.getCourse().getCid());
			ps.setString(5,sc.getCourse().getCname());
			ps.setString(6,sc.getCourse().getCterm());
			ps.setString(7,sc.getCourse().getCshangke());
			ps.setString(8,sc.getCourse().getCteacher());
			ps.setString(9,sc.getCourse().getCtype());
			ps.setString(10,sc.getCourse().getCexam());
			ps.setString(11,sc.getCourse().getCweekday()[0]);
			ps.setString(12,sc.getCourse().getCjieshu()[0]);
			ps.setString(13,sc.getCourse().getCweekday()[1]);
			ps.setString(14,sc.getCourse().getCjieshu()[1]);
			ps.setString(15,sc.getCourse().getCweekday()[2]);
			ps.setString(16,sc.getCourse().getCjieshu()[2]);
			ps.setString(17,sc.getCourse().getCplace());
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
//根据id和cid查找sc表中相应内容
	public StudentCourse selectByIC(String id,String cid){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from studentcourse where id=? and cid=?");
			ps.setString(1, id);
			ps.setString(2, cid);
			rs = ps.executeQuery();
			if (rs.next()) {
			StudentCourse sc=new StudentCourse();
			sc.setCid(rs.getString("cid"));
			sc.setCname(rs.getString("cname"));
			sc.setCexam(rs.getString("cexam"));
			sc.setCterm(rs.getString("cterm"));			
			sc.setCteacher(rs.getString("cteacher"));
			sc.setCplace(rs.getString("cplace"));
			return sc;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
	public ArrayList<Course> selectAllCourses() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select cid,cname,ctype,cterm,cteacher,cshangke,cexam,cweekday1,cjieshu1,cweekday2,cjieshu2,cweekday3,cjieshu3,cplace from course");
			rs = ps.executeQuery();
			ArrayList<Course> courses = new ArrayList<Course>();
			while (rs.next()) {
			Course c=new Course();
			c.setCid(rs.getString("cid"));
			c.setCname(rs.getString("cname"));
			c.setCtype(rs.getString("ctype"));
			c.setCterm(rs.getString("cterm"));
			c.setCteacher(rs.getString("cteacher"));
			c.setCshangke(rs.getString("cshangke"));
			c.setCexam(rs.getString("cexam"));
			c.setCplace(rs.getString("cplace"));
			String[] arr1=new String[3];
			arr1[0]=rs.getString("cweekday1");
			arr1[1]=rs.getString("cweekday2");
			arr1[2]=rs.getString("cweekday3");			
			c.setCweekday(arr1);
			String[] arr=new String[3];
			arr[0]=rs.getString("cjieshu1");
			arr[1]=rs.getString("cjieshu2");
			arr[2]=rs.getString("cjieshu3");			
			c.setCjieshu(arr);
			courses.add(c);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
		}
//删除选课[id,cid,cterm,cyear]
	public int deleteStudentCourseById(StudentCourse studentcourse) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from studentcourse where id=? and cid=? and "
					+ "cyear=? and cterm=?");
			ps.setString(1, studentcourse.getId());
			ps.setString(2, studentcourse.getCid());
			ps.setString(3, studentcourse.getCyear());
			ps.setString(4, studentcourse.getCterm());
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
//查看：查看选修了什么课
	public ArrayList<StudentCourse> selectAllStudentCourses(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from studentcourse where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			ArrayList<StudentCourse> studentcourse1 = new ArrayList<StudentCourse>();
			while (rs.next()) {
			StudentCourse sc = new StudentCourse();
			sc.setCid(rs.getString("cid"));
			sc.setCname(rs.getString("cname"));
			sc.setCyear(rs.getString("cyear"));
			sc.setCterm(rs.getString("cterm"));
			sc.setCshangke(rs.getString("cshangke"));
			sc.setCteacher(rs.getString("cteacher"));
			sc.setCtype(rs.getString("ctype"));
			sc.setCexam(rs.getString("cexam"));
			sc.setScmark(rs.getString("scmark"));
			String[] arr=new String[3];
			arr[0]=rs.getString("cjieshu1");
			arr[1]=rs.getString("cjieshu2");
			arr[2]=rs.getString("cjieshu3");			
			sc.setCjieshu(arr);
			String[] arr1=new String[3];
			arr1[0]=rs.getString("cweekday1");
			arr1[1]=rs.getString("cweekday2");
			arr1[2]=rs.getString("cweekday3");		
			sc.setCweekday(arr1);
			sc.setCplace(rs.getString("cplace"));
			studentcourse1.add(sc);
			}
			return studentcourse1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//加入成绩 即为查看成绩  查看成绩应为另一个jsp及功能。 查看选课仅看课程信息；查看成绩才能看分数
	public int updateScmark(StudentCourse sc){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement("update studentcourse set scmark=? where id=? and cid=?");
			ps.setString(1, sc.getScmark());
			ps.setString(2, sc.getId());
			ps.setString(3, sc.getCid());
			DBUtil.beginTrans(conn);
			int i = ps.executeUpdate();
			DBUtil.endTrans(conn);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}
//查看：按照老师的名称进行查看 筛选出曾经添加了什么课 根据课程进一步添加成绩
	public ArrayList<StudentCourse> selectAllCoursesByTid(String cteacher){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StudentCourse> tcourses = new ArrayList<StudentCourse>();
		try {
			ps = conn.prepareStatement("select cid,cname,cexam,cterm,cteacher,cplace from course where cteacher=?");
			ps.setString(1, cteacher);
			rs = ps.executeQuery();
			while (rs.next()) {
			StudentCourse sc=new StudentCourse();
			sc.setCid(rs.getString("cid"));
			sc.setCname(rs.getString("cname"));
			sc.setCexam(rs.getString("cexam"));
			sc.setCterm(rs.getString("cterm"));			
			sc.setCteacher(rs.getString("cteacher"));
			sc.setCplace(rs.getString("cplace"));
			tcourses.add(sc);
			}
			return tcourses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//根据课程号筛选所有学生
	public ArrayList<StudentCourse> selectAllStudentsByCid(String cid){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select id,name,cyear,cterm,cexam,scmark,cplace from studentcourse where cid=?");
			ps.setString(1, cid);
			rs = ps.executeQuery();
			ArrayList<StudentCourse> stumark = new ArrayList<StudentCourse>();
			while (rs.next()) {
			StudentCourse sc=new StudentCourse();
			sc.setId(rs.getString("id"));
			sc.setName(rs.getString("name"));
			sc.setCyear(rs.getString("cyear"));
			sc.setCterm(rs.getString("cterm"));
			sc.setCexam(rs.getString("cexam"));
			sc.setScmark(rs.getString("scmark"));
			sc.setCplace(rs.getString("cplace"));
			stumark.add(sc);
			}
			return stumark;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//分页
	public ArrayList<Course> fenye(int dangqianPage){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course order by cid limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Course c=new Course();
				c.setCid(rs.getString("cid"));
				c.setCname(rs.getString("cname"));
				c.setCtime(rs.getString("ctime"));
				c.setCweektime(rs.getString("cweektime"));
				c.setCtype(rs.getString("ctype"));
				c.setCscore(rs.getString("cscore"));
				c.setCdepartment(rs.getString("cdepartment"));
				c.setCexam(rs.getString("cexam"));
				c.setCdescribe(rs.getString("cdescribe"));
				c.setCterm(rs.getString("cterm"));
				c.setCteacher(rs.getString("cteacher"));
				c.setCshangke(rs.getString("cshangke"));
				String[] arr=new String[3];
				arr[0]=rs.getString("cjieshu1");
				arr[1]=rs.getString("cjieshu2");
				arr[2]=rs.getString("cjieshu3");			
				c.setCjieshu(arr);
				String[] arr1=new String[3];
				arr1[0]=rs.getString("cweekday1");
				arr1[1]=rs.getString("cweekday2");
				arr1[2]=rs.getString("cweekday3");			
				c.setCweekday(arr1);
				c.setCplace(rs.getString("cplace"));
				cfy.add(c);
				}
				return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//总记录数
	public int sumData() {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course");
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
//总页数
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
	public ArrayList<Course> fenye1(int dangqianPage,String ctype, String cid, String cname){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from course where (ctype like '%"+ctype+"%' and"
						+ " cid like '%"+cid+"%' and cname like '%"+cname+"%') order by cid limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
					Course c=new Course();
					c.setCid(rs.getString("cid"));
					c.setCname(rs.getString("cname"));
					c.setCtime(rs.getString("ctime"));
					c.setCweektime(rs.getString("cweektime"));
					c.setCtype(rs.getString("ctype"));
					c.setCscore(rs.getString("cscore"));
					c.setCdepartment(rs.getString("cdepartment"));
					c.setCexam(rs.getString("cexam"));
					c.setCdescribe(rs.getString("cdescribe"));
					c.setCterm(rs.getString("cterm"));
					c.setCteacher(rs.getString("cteacher"));
					c.setCshangke(rs.getString("cshangke"));
					String[] arr=new String[3];
					arr[0]=rs.getString("cjieshu1");
					arr[1]=rs.getString("cjieshu2");
					arr[2]=rs.getString("cjieshu3");			
					c.setCjieshu(arr);
					String[] arr1=new String[3];
					arr1[0]=rs.getString("cweekday1");
					arr1[1]=rs.getString("cweekday2");
					arr1[2]=rs.getString("cweekday3");			
					c.setCweekday(arr1);
					c.setCplace(rs.getString("cplace"));
					cfy.add(c);
					}
					return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//查询总记录
	public int sumData1(String ctype, String cid, String cname) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from course where (ctype like '%"+ctype+"%' and"
						+ " cid like '%"+cid+"%' and cname like '%"+cname+"%')");
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
	public int sumPageCount1(String ctype, String cid, String cname) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(ctype, cid, cname);
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
//输出学期
	public ArrayList<StudentCourse> term() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StudentCourse> scs = new ArrayList<StudentCourse>();
		try {
			ps = conn.prepareStatement("select DISTINCT cterm from studentcourse");
			rs = ps.executeQuery();
			while (rs.next()) {
			StudentCourse s = new StudentCourse();
			s.setCterm(rs.getString("cterm"));
			scs.add(s);
			}return scs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//年份
	public ArrayList<StudentCourse> term1() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StudentCourse> scs = new ArrayList<StudentCourse>();
		try {
			ps = conn.prepareStatement("select DISTINCT cyear from studentcourse");
			rs = ps.executeQuery();
			while (rs.next()) {
			StudentCourse s = new StudentCourse();
			s.setCyear(rs.getString("cyear"));
			scs.add(s);
			}return scs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//查看选课查询-分页
	public ArrayList<StudentCourse> fenye2(int dangqianPage,String ctype, String cterm, String cyear, String id){
		ArrayList<StudentCourse> cfy = new ArrayList<StudentCourse>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where (ctype like '%"+ctype+"%' and"
						+ " cterm like '%"+cterm+"%' and cyear like '%"+cyear+"%' and id='"+id+"') order by cid limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
						StudentCourse sc = new StudentCourse();
						sc.setCid(rs.getString("cid"));
						sc.setCname(rs.getString("cname"));
						sc.setCyear(rs.getString("cyear"));
						sc.setCterm(rs.getString("cterm"));
						sc.setCshangke(rs.getString("cshangke"));
						sc.setCteacher(rs.getString("cteacher"));
						sc.setCtype(rs.getString("ctype"));
						sc.setCexam(rs.getString("cexam"));
						sc.setScmark(rs.getString("scmark"));
						String[] arr=new String[3];
						arr[0]=rs.getString("cjieshu1");
						arr[1]=rs.getString("cjieshu2");
						arr[2]=rs.getString("cjieshu3");			
						sc.setCjieshu(arr);
						String[] arr1=new String[3];
						arr1[0]=rs.getString("cweekday1");
						arr1[1]=rs.getString("cweekday2");
						arr1[2]=rs.getString("cweekday3");			
						sc.setCweekday(arr1);
						sc.setCplace(rs.getString("cplace"));
						cfy.add(sc);
						}
						return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//总记录数
	public int sumData2(String ctype, String cterm, String cyear, String id) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where (ctype like '%"+ctype+"%' and"
						+ " cterm like '%"+cterm+"%' and cyear like '%"+cyear+"%' and id='"+id+"')");
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
//总页数
	public int sumPageCount2(String ctype, String cterm,String cyear, String id) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData2(ctype, cterm,cyear,id);
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
//查看选课和成绩 共用
	public ArrayList<StudentCourse> fenye3(int dangqianPage, String id){
		ArrayList<StudentCourse> cfy = new ArrayList<StudentCourse>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where id='"+id+"' order by cid limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
						StudentCourse sc = new StudentCourse();
						sc.setCid(rs.getString("cid"));
						sc.setCname(rs.getString("cname"));
						sc.setCyear(rs.getString("cyear"));
						sc.setCterm(rs.getString("cterm"));
						sc.setCshangke(rs.getString("cshangke"));
						sc.setCteacher(rs.getString("cteacher"));
						sc.setCtype(rs.getString("ctype"));
						sc.setCexam(rs.getString("cexam"));
						sc.setScmark(rs.getString("scmark"));
						String[] arr=new String[3];
						arr[0]=rs.getString("cjieshu1");
						arr[1]=rs.getString("cjieshu2");
						arr[2]=rs.getString("cjieshu3");			
						sc.setCjieshu(arr);
						String[] arr1=new String[3];
						arr1[0]=rs.getString("cweekday1");
						arr1[1]=rs.getString("cweekday2");
						arr1[2]=rs.getString("cweekday3");			
						sc.setCweekday(arr1);
						sc.setCplace(rs.getString("cplace"));
						cfy.add(sc);
						}
						return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//总记录
	public int sumData3(String id) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where id='"+id+"' ");
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
//总页数
	public int sumPageCount3(String id) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData3(id);
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
//查看成绩查询-分页   fenye4(currentCount,id,cterm,cyear)
	public ArrayList<StudentCourse> fenye4(int dangqianPage, String id,String cterm,String cyear){
		ArrayList<StudentCourse> cfy = new ArrayList<StudentCourse>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where id='"+id+"' and cterm like'%"+cterm+"%'"
						+ " and cyear like '%"+cyear+"%' order by cid limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
						StudentCourse sc = new StudentCourse();
						sc.setCid(rs.getString("cid"));
						sc.setCname(rs.getString("cname"));
						sc.setCyear(rs.getString("cyear"));
						sc.setCterm(rs.getString("cterm"));
						sc.setCshangke(rs.getString("cshangke"));
						sc.setCteacher(rs.getString("cteacher"));
						sc.setCtype(rs.getString("ctype"));
						sc.setCexam(rs.getString("cexam"));
						sc.setScmark(rs.getString("scmark"));
						String[] arr=new String[3];
						arr[0]=rs.getString("cjieshu1");
						arr[1]=rs.getString("cjieshu2");
						arr[2]=rs.getString("cjieshu3");			
						sc.setCjieshu(arr);
						String[] arr1=new String[3];
						arr1[0]=rs.getString("cweekday1");
						arr1[1]=rs.getString("cweekday2");
						arr1[2]=rs.getString("cweekday3");			
						sc.setCweekday(arr1);
						sc.setCplace(rs.getString("cplace"));
						cfy.add(sc);
						}
						return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//总数据
	public int sumData4(String id, String cterm, String cyear) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from studentcourse where id='"+id+"' and cterm like'%"+cterm+"%'"
						+ " and cyear like '%"+cyear+"%'");
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
//总页数
	public int sumPageCount4(String id,String cterm,String cyear) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData4(id,cterm,cyear);
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