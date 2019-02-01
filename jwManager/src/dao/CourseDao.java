package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.DBUtil;
import dto.Course;

public class CourseDao {
	
	public int insertCourse1(Course course){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into course values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,course.getCid());
			ps.setString(2,course.getCname());
			ps.setString(3,course.getCtime());
			ps.setString(4,course.getCweektime());
			ps.setString(5,course.getCtype());
			ps.setString(6,course.getCscore());
			ps.setString(7,course.getCdepartment());
			ps.setString(8,course.getCexam());
			ps.setString(9,course.getCdescribe());
			ps.setString(10,course.getCterm());
			ps.setString(11,course.getCteacher());
			ps.setString(12,course.getCplace());
			ps.setString(13,course.getCshangke());
			ps.setString(14,course.getCjieshu()[0]);
			ps.setString(15,course.getCweekday()[0]);
			ps.setString(16,"");
			ps.setString(17,"");
			ps.setString(18,"");
			ps.setString(19,"");
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
	public int insertCourse2(Course course){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into course values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,course.getCid());
			ps.setString(2,course.getCname());
			ps.setString(3,course.getCtime());
			ps.setString(4,course.getCweektime());
			ps.setString(5,course.getCtype());
			ps.setString(6,course.getCscore());
			ps.setString(7,course.getCdepartment());
			ps.setString(8,course.getCexam());
			ps.setString(9,course.getCdescribe());
			ps.setString(10,course.getCterm());
			ps.setString(11,course.getCteacher());
			ps.setString(12,course.getCplace());
			ps.setString(13,course.getCshangke());
			ps.setString(14,course.getCjieshu()[0]);
			ps.setString(15,course.getCweekday()[0]);
			ps.setString(16,course.getCjieshu()[1]);
			ps.setString(17,course.getCweekday()[1]);
			ps.setString(18,"");
			ps.setString(19,"");
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
	public int insertCourse3(Course course){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into course values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,course.getCid());
			ps.setString(2,course.getCname());
			ps.setString(3,course.getCtime());
			ps.setString(4,course.getCweektime());
			ps.setString(5,course.getCtype());
			ps.setString(6,course.getCscore());
			ps.setString(7,course.getCdepartment());
			ps.setString(8,course.getCexam());
			ps.setString(9,course.getCdescribe());
			ps.setString(10,course.getCterm());
			ps.setString(11,course.getCteacher());
			ps.setString(12,course.getCplace());
			ps.setString(13,course.getCshangke());
			ps.setString(14,course.getCjieshu()[0]);
			ps.setString(15,course.getCweekday()[0]);
			ps.setString(16,course.getCjieshu()[1]);
			ps.setString(17,course.getCweekday()[1]);
			ps.setString(18,course.getCjieshu()[2]);
			ps.setString(19,course.getCweekday()[2]);
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
	public int deleteCourseById(String cid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from course where cid=?");
			ps.setString(1, cid);
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
	public int updateCourse1(Course course) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update course set cname=?,ctime=?,cweektime=?,ctype=?,"
					+ "cscore=?,cdepartment=?,cexam=?,cdescribe=?,cterm=?,cteacher=?,cshangke=?,"
					+ "cjieshu1=?,cweekday1=?,cplace=? where cid=?");
			ps.setString(1,course.getCname());
			ps.setString(2,course.getCtime());
			ps.setString(3, course.getCweektime());
			ps.setString(4,course.getCtype());
			ps.setString(5,course.getCscore());
			ps.setString(6,course.getCdepartment());
			ps.setString(7,course.getCexam());
			ps.setString(8,course.getCdescribe());
			ps.setString(9,course.getCterm());
			ps.setString(10,course.getCteacher());
			ps.setString(11,course.getCshangke());
			ps.setString(12,course.getCjieshu()[0]);
			ps.setString(13,course.getCweekday()[0]);
			ps.setString(14,course.getCplace());
			ps.setString(15,course.getCid());
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
	public int updateCourse2(Course course) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update course set cname=?,ctime=?,cweektime=?,ctype=?,"
					+ "cscore=?,cdepartment=?,cexam=?,cdescribe=?,cterm=?,cteacher=?,cshangke=?,"
					+ "cjieshu1=?,cweekday1=?,cjieshu2=?,cweekday2=?,cplace=? where cid=?");
			ps.setString(1,course.getCname());
			ps.setString(2,course.getCtime());
			ps.setString(3, course.getCweektime());
			ps.setString(4,course.getCtype());
			ps.setString(5,course.getCscore());
			ps.setString(6,course.getCdepartment());
			ps.setString(7,course.getCexam());
			ps.setString(8,course.getCdescribe());
			ps.setString(9,course.getCterm());
			ps.setString(10,course.getCteacher());
			ps.setString(11,course.getCshangke());
			ps.setString(12,course.getCjieshu()[0]);
			ps.setString(13,course.getCweekday()[0]);
			ps.setString(14,course.getCjieshu()[1]);
			ps.setString(15,course.getCweekday()[1]);
			ps.setString(16,course.getCplace());
			ps.setString(17,course.getCid());
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
	public int updateCourse3(Course course) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update course set cname=?,ctime=?,cweektime=?,ctype=?,"
					+ "cscore=?,cdepartment=?,cexam=?,cdescribe=?,cterm=?,cteacher=?,cshangke=?,"
					+ "cjieshu1=?,cweekday1=?,cjieshu2=?,cweekday2=?,cjieshu3=?,cweekday3=?,cplace=? where cid=?");
			ps.setString(1,course.getCname());
			ps.setString(2,course.getCtime());
			ps.setString(3, course.getCweektime());
			ps.setString(4,course.getCtype());
			ps.setString(5,course.getCscore());
			ps.setString(6,course.getCdepartment());
			ps.setString(7,course.getCexam());
			ps.setString(8,course.getCdescribe());
			ps.setString(9,course.getCterm());
			ps.setString(10,course.getCteacher());
			ps.setString(11,course.getCshangke());
			ps.setString(12,course.getCjieshu()[0]);
			ps.setString(13,course.getCweekday()[0]);
			ps.setString(14,course.getCjieshu()[1]);
			ps.setString(15,course.getCweekday()[1]);
			ps.setString(16,course.getCjieshu()[2]);
			ps.setString(17,course.getCweekday()[2]);
			ps.setString(18,course.getCplace());
			ps.setString(19,course.getCid());
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
	public ArrayList<Course> selectAllCourses() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course");
			rs = ps.executeQuery();
			ArrayList<Course> courses = new ArrayList<Course>();
			while (rs.next()) {
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
			c.setCplace(rs.getString("cplace"));
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
	public Course selectCourseById(String cid){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from course where cid=?");
			ps.setString(1,cid);
			rs=ps.executeQuery();
			if(rs.next()){
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
				c.setCplace(rs.getString("cplace"));
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
				return c;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public ArrayList<Course> selectCourseById1(String cid){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course where cid=?");
			ps.setString(1,cid);
			rs = ps.executeQuery();
			ArrayList<Course> courses = new ArrayList<Course>();
			if(rs.next()){
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
				c.setCplace(rs.getString("cplace"));
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
				courses.add(c);
			}			
			return courses;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public ArrayList<Course> selectCourse(String cid, String cname, String ctype) {
		Connection conn = DBUtil.getConnection();
		String sql="select * from course where (cid like '%"+cid+"%' and cname like '%"+cname+"%'"
				+ " and ctype like '%"+ctype+"%')";
		PreparedStatement ps = null;
		java.sql.Statement pstmt=null;
		ResultSet rs = null;
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			pstmt=conn.createStatement();
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
			Course c = new Course();
			c.setCid(rs.getString("cid"));
			c.setCname(rs.getString("cname"));
			c.setCteacher(rs.getString("cteacher"));
			c.setCtype(rs.getString("ctype"));
			courses.add(c);
			}return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//查询所有课程号
	public ArrayList<String> selectCid(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select cid from course");
			rs = ps.executeQuery();
			ArrayList<String> course = new ArrayList<String>();
			while (rs.next()) {
			course.add(rs.getString(1));
			}
			return course;
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
				c.setCplace(rs.getString("cplace"));
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
//总数据数
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
//课程信息查询-分页 
	public ArrayList<Course> fenye1(int dangqianPage, String ctype, String cid, String cname){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course where cid like '%"+cid+"%' and cname like '%"+cname+"%'"
				+ " and ctype like '%"+ctype+"%' order by cid limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Course c=new Course();
				c.setCid(rs.getString("cid"));
				c.setCname(rs.getString("cname"));
				c.setCteacher(rs.getString("cteacher"));
				c.setCtype(rs.getString("ctype"));
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
//查询-数据数
	public int sumData1(String ctype, String cid, String cname) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from course where cid like '%"+cid+"%' and cname like '%"+cname+"%'"
				+ " and ctype like '%"+ctype+"%'");
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
//查询-页数
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
//传入文件插入课程信息
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
			Course course=null;
			try{
				System.out.println("生成句柄成功");
			}
			catch(Exception ex)
			{
				System.out.println("生成句柄失败");
			}
			int j = 0;
			String cid;
			String cname;
			String ctime;
			String cweektime;
			String ctype;
			String cscore;
			String cdepartment;
			String cexam;
			String cdescribe;
			String cterm;
			String cteacher;
			String cshangke;
			String cplace;
			String cjieshu1;
			String cweekday1;
			String cjieshu2;
			String cweekday2;
			String cjieshu3;
			String cweekday3;
			System.out.println(totalrow);
			for(short i=1;i<=totalrow;i++)
			{
				course = new Course();
				row=sheet.getRow(i);
				cell=row.getCell((short)0);
				if(cell!=null)
				{
					cid=cell.toString();
					course.setCid(cid);
				}
				cell=row.getCell((short)1);
				if(cell!=null)
				{
					cname=cell.toString();
					course.setCname(cname);
				}
				cell=row.getCell((short)2);
				if(cell!=null)
				{
					ctime=cell.toString();
					course.setCtime(ctime);
				}
				cell=row.getCell((short)3);
				if(cell!=null)
				{
					cweektime=cell.toString();
					course.setCweektime(cweektime);
				}
				cell=row.getCell((short)4);
				if(cell!=null)
				{
					ctype=cell.toString();
					course.setCtype(ctype);
				}
				cell=row.getCell((short)5);
				if(cell!=null)
				{
					cscore=cell.toString();
					course.setCscore(cscore);
				}
				cell=row.getCell((short)6);
				if(cell!=null)
				{
					cdepartment=cell.toString();
					course.setCdepartment(cdepartment);
				}
				cell=row.getCell((short)7);
				if(cell!=null)
				{
					cexam=cell.toString();
					course.setCexam(cexam);
				}
				cell=row.getCell((short)8);
				if(cell!=null)
				{
					cdescribe=cell.toString();
					course.setCdescribe(cdescribe);
				}
				cell=row.getCell((short)9);
				if(cell!=null)
				{
					cterm=cell.toString();
					course.setCterm(cterm);
				}
				cell=row.getCell((short)10);
				if(cell!=null)
				{
					cteacher=cell.toString();
					course.setCteacher(cteacher);
				}
				cell=row.getCell((short)11);
				if(cell!=null)
				{
					cplace=cell.toString();
					course.setCplace(cplace);
				}
				cell=row.getCell((short)12);
				if(cell!=null)
				{
					cshangke=cell.toString();
					course.setCshangke(cshangke);
				}
				cell=row.getCell((short)13);
				if(cell!=null)
				{
					cjieshu1=cell.toString();
					course.setCjieshu1(cjieshu1);
				}else{
					cjieshu1="";
					course.setCjieshu1(cjieshu1);
				}
				cell=row.getCell((short)14);
				if(cell!=null)
				{
					cweekday1=cell.toString();
					course.setCweekday1(cweekday1);
				}else{
					cweekday1="";
					course.setCweekday1(cweekday1);
				}
				cell=row.getCell((short)15);
				if(cell!=null)
				{
					cjieshu2=cell.toString();
					course.setCjieshu2(cjieshu2);
				}else{
					cjieshu2="";
					course.setCjieshu2(cjieshu2);
				}
				cell=row.getCell((short)16);
				if(cell!=null)
				{
					cweekday2=cell.toString();
					course.setCweekday2(cweekday2);
				}else{
					cweekday2="";
					course.setCweekday2(cweekday2);
				}
				cell=row.getCell((short)17);
				if(cell!=null)
				{
					cjieshu3=cell.toString();
					course.setCjieshu3(cjieshu3);
				}
				else {
					cjieshu3="";
					course.setCjieshu3(cjieshu3);
				}
				cell=row.getCell((short)18);
				if(cell!=null)
				{
					cweekday3=cell.toString();
					course.setCweekday3(cweekday3);
				}else{
					cweekday3="";
					course.setCweekday3(cweekday3);
				}
				ps=conn.prepareStatement("insert into course values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,course.getCid());
				ps.setString(2,course.getCname());
				ps.setString(3,course.getCtime());
				ps.setString(4,course.getCweektime());
				ps.setString(5,course.getCtype());
				ps.setString(6,course.getCscore());
				ps.setString(7,course.getCdepartment());
				ps.setString(8,course.getCexam());
				ps.setString(9,course.getCdescribe());
				ps.setString(10,course.getCterm());
				ps.setString(11,course.getCteacher());
				ps.setString(12,course.getCplace());
				ps.setString(13,course.getCshangke());
				ps.setString(14,course.getCjieshu1());
				ps.setString(15,course.getCweekday1());
				ps.setString(16,course.getCjieshu2());
				ps.setString(17,course.getCweekday2());
				ps.setString(18,course.getCjieshu3());
				ps.setString(19,course.getCweekday3());
				DBUtil.beginTrans(conn);
				j=ps.executeUpdate();
				DBUtil.endTrans(conn);
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
//学生课程查看-分页-仅选修
	public ArrayList<Course> fenye2(int dangqianPage){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' order by cid limit "+ 8*(dangqianPage-1)+","+8+"");
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
				c.setCplace(rs.getString("cplace"));
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
//学生课程查看-总数据数
	public int sumData2() {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' ");
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
//学生课程查看-总页数
	public int sumPageCount2() {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData2();
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
//学生选课-查找-分页（名 号）
	public ArrayList<Course> fenye3(int dangqianPage,String cname,String cid,String cterm){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' and cterm='"+cterm+"'"
					+ " and cid like '%"+cid+"%' and cname like '%"+cname+"%' order by cid"
					+ " limit "+ 8*(dangqianPage-1)+","+8+"");
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
				c.setCplace(rs.getString("cplace"));
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
//学生选课-查找-总数据数
	public int sumData3(String cname,String cid,String cterm) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' and "
					+ " cterm='"+cterm+"' and cid like '%"+cid+"%' and cname like '%"+cname+"%'");
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
//学生选课-查找-总页数
	public int sumPageCount3(String cname,String cid,String cterm) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData3(cname,cid,cterm);
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
//学生选课-学期&选修-分页
	public ArrayList<Course> fenye4(int dangqianPage,String cterm){
		ArrayList<Course> cfy = new ArrayList<Course>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' and "
					+ "cterm like '%"+cterm+"%' order by cid limit "+ 8*(dangqianPage-1)+","+8+"");
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
				c.setCplace(rs.getString("cplace"));
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
//学生选课-学期&选修-总数据数
	public int sumData4(String cterm) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String ctype="选修";
			ps = conn.prepareStatement("select * from course where ctype='"+ctype+"' and "
					+ "cterm like '%"+cterm+"%' ");
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
//学生选课-学期&选修-总页数
	public int sumPageCount4(String cterm) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData4(cterm);
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
				