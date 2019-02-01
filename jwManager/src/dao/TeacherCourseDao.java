package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import dto.TeacherCourse;

public class TeacherCourseDao {
	public int insertTeacherCourse(TeacherCourse tc){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into teachercourse values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,tc.getId());
			ps.setString(2,tc.getCourse().getCteacher());
			ps.setString(3,tc.getCourse().getCid());
			ps.setString(4,tc.getCourse().getCname());
			ps.setString(5,tc.getCyear());
			ps.setString(6,tc.getCourse().getCterm());
			ps.setString(7,tc.getCourse().getCshangke());
			ps.setString(8,tc.getCourse().getCweekday()[0]);
			ps.setString(9,tc.getCourse().getCjieshu()[0]);
			ps.setString(10,tc.getCourse().getCweekday()[1]);
			ps.setString(11,tc.getCourse().getCjieshu()[1]);
			ps.setString(12,tc.getCourse().getCweekday()[2]);
			ps.setString(13,tc.getCourse().getCjieshu()[2]);
			ps.setString(14,tc.getCourse().getCexam());
			ps.setString(15,tc.getCourse().getCtype());
			ps.setString(16,tc.getCourse().getCplace());
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
//查找该教师所上的课程
	public ArrayList<TeacherCourse> selectAllCoursesByTname(String cteacher){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TeacherCourse> tcourses = new ArrayList<TeacherCourse>();
		try {
			ps = conn.prepareStatement("select cid,cname,cexam,cyear,cterm,name from teachercourse where name=?");
			ps.setString(1, cteacher);
			rs = ps.executeQuery();
			while (rs.next()) {
			TeacherCourse sc=new TeacherCourse();
			sc.setCid(rs.getString("cid"));
			sc.setCname(rs.getString("cname"));
			sc.setCexam(rs.getString("cexam"));
			sc.setCyear(rs.getString("cyear"));			
			sc.setCterm(rs.getString("cterm"));			
			sc.setName(rs.getString("name"));
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
//输出学期
	public ArrayList<TeacherCourse> term() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TeacherCourse> scs = new ArrayList<TeacherCourse>();
		try {
			ps = conn.prepareStatement("select DISTINCT cterm from teachercourse");
			rs = ps.executeQuery();
			while (rs.next()) {
			TeacherCourse s = new TeacherCourse();
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
	public ArrayList<TeacherCourse> term1() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TeacherCourse> scs = new ArrayList<TeacherCourse>();
		try {
			ps = conn.prepareStatement("select DISTINCT cyear from teachercourse");
			rs = ps.executeQuery();
			while (rs.next()) {
			TeacherCourse s = new TeacherCourse();
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
//查看名单-分页
	public ArrayList<TeacherCourse> fenye(int dangqianPage,String cteacher){
		ArrayList<TeacherCourse> cfy = new ArrayList<TeacherCourse>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teachercourse where name='"+cteacher+"' order by cid limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				TeacherCourse sc=new TeacherCourse();
				sc.setCid(rs.getString("cid"));
				sc.setCname(rs.getString("cname"));
				sc.setCexam(rs.getString("cexam"));
				sc.setCyear(rs.getString("cyear"));			
				sc.setCterm(rs.getString("cterm"));			
				sc.setName(rs.getString("name"));
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
//查看名单-总数据
	public int sumData(String cteacher) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teachercourse where name='"+cteacher+"' ");
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
//查看名单-总页数
	public int sumPageCount(String cteacher) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData(cteacher);
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
//查看名单-查询-分页
	public ArrayList<TeacherCourse> fenye1(int dangqianPage,String cexam, String cyear, String cterm,String cteacher){
		ArrayList<TeacherCourse> cfy = new ArrayList<TeacherCourse>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from teachercourse where (name='"+cteacher+"' and cexam like '%"+cexam+"%' and"
						+ " cyear like '%"+cyear+"%' and cterm like '%"+cterm+"%') order by cid limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
					TeacherCourse sc=new TeacherCourse();
					sc.setCid(rs.getString("cid"));
					sc.setCname(rs.getString("cname"));
					sc.setCexam(rs.getString("cexam"));
					sc.setCyear(rs.getString("cyear"));			
					sc.setCterm(rs.getString("cterm"));			
					sc.setName(rs.getString("name"));
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
//查看名单-查询-总数据
	public int sumData1(String cexam, String cyear, String cterm, String cteacher) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from teachercourse where (name='"+cteacher+"' and cexam like '%"+cexam+"%' and"
						+ " cyear like '%"+cyear+"%' and cterm like '%"+cterm+"%')");
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
//查看名单-查询-总页数
	public int sumPageCount1(String cexam, String cyear, String cterm, String cteacher) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(cexam, cyear, cterm,cteacher);
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
//根据id和cid查找sc表中相应内容
	public TeacherCourse selectByIC(String id,String cid,String cterm,String cyear){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teachercourse where id=? and cid=? and cterm=? and cyear=?");
			ps.setString(1, id);
			ps.setString(2, cid);
			ps.setString(3, cterm);
			ps.setString(4, cyear);
			rs = ps.executeQuery();
			if (rs.next()) {
			TeacherCourse sc=new TeacherCourse();
			sc.setCid(rs.getString("cid"));
			sc.setCname(rs.getString("cname"));
			sc.setCexam(rs.getString("cexam"));
			sc.setCterm(rs.getString("cterm"));			
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
}
