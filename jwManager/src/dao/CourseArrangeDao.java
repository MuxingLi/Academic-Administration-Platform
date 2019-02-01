package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBUtil;
import dto.CourseArrange;

public class CourseArrangeDao {
//创建一个id 以便于插入课程安排
	public int insertCourseArrange(CourseArrange ca){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into coursearrange (id,cayear,caterm) values(?,?,?)");
			ps.setString(1,ca.getId());
			ps.setString(2,ca.getCayear());
			ps.setString(3,ca.getCaterm());
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
//判断表中是否已存在该id及同年和学期 好确定是否创建一个新的（上一个函数）
	public CourseArrange panduan(String id,String year,String term) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from coursearrange where id=? and cayear=? and caterm=? ");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
			CourseArrange cs = new CourseArrange();
			cs.setId(rs.getString("id"));
			cs.setCayear(rs.getString("cayear"));
			cs.setCaterm(rs.getString("caterm"));
			return cs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		
		return null;
	}
//查看课表 通过id,caterm,cayear
	public CourseArrange selectCAById(String id,String caterm,String cayear){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from coursearrange where id=? and caterm=?"
					+ " and cayear=?");
			ps.setString(1, id);
			ps.setString(2, caterm);
			ps.setString(3, cayear);
			rs = ps.executeQuery();
			if (rs.next()) {
			CourseArrange ca = new CourseArrange();
			ca.setId(rs.getString("id"));
			ca.setCayear(rs.getString("cayear"));
			ca.setCaterm(rs.getString("caterm"));
			ca.setMon1(rs.getString("mon1"));
			ca.setMon2(rs.getString("mon2"));
			ca.setMon3(rs.getString("mon3"));
			ca.setMon4(rs.getString("mon4"));
			ca.setMon5(rs.getString("mon5"));
			ca.setTue1(rs.getString("tue1"));
			ca.setTue2(rs.getString("tue2"));
			ca.setTue3(rs.getString("tue3"));
			ca.setTue4(rs.getString("tue4"));
			ca.setTue5(rs.getString("tue5"));
			ca.setWed1(rs.getString("wed1"));
			ca.setWed2(rs.getString("wed2"));
			ca.setWed3(rs.getString("wed3"));
			ca.setWed4(rs.getString("wed4"));
			ca.setWed5(rs.getString("wed5"));
			ca.setThu1(rs.getString("thu1"));
			ca.setThu2(rs.getString("thu2"));
			ca.setThu3(rs.getString("thu3"));
			ca.setThu4(rs.getString("thu4"));
			ca.setThu5(rs.getString("thu5"));
			ca.setFri1(rs.getString("fri1"));
			ca.setFri2(rs.getString("fri2"));
			ca.setFri3(rs.getString("fri3"));
			ca.setFri4(rs.getString("fri4"));
			ca.setFri5(rs.getString("fri5"));
			return ca;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//插入课程至课表----必修-----学生
	public int insertCourseArrange1(CourseArrange ca){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try{
			CourseArrangeDao dao=new CourseArrangeDao();
		for(int k=0;k<3;k++){
			if("周一".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon3=? where id=? and caterm=? and cayear=? ");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}
			ps.executeUpdate();
			ps.close();
		}else if("周二".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周三".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周四".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周五".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getStudentCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
		}
//插入课程至课表----选修-----学生
	public int insertCourseArrange2(CourseArrange ca){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try{
			CourseArrangeDao dao=new CourseArrangeDao();
		for(int k=0;k<3;k++){
			if("周一".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon3=? where id=? and caterm=? and cayear=? ");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}
			ps.executeUpdate();
			ps.close();
		}else if("周二".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周三".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周四".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周五".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
		}
//插入课程至课表----必修-----教师
	public int insertCourseArrange3(CourseArrange ca){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try{
			CourseArrangeDao dao=new CourseArrangeDao();
		for(int k=0;k<3;k++){
			if("周一".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon3=? where id=? and caterm=? and cayear=? ");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}
			ps.executeUpdate();
			ps.close();
		}else if("周二".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周三".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周四".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周五".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getTeacherCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
		}
//插入课程至课表----选修-----教师
	public int insertCourseArrange4(CourseArrange ca){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try{
			CourseArrangeDao dao=new CourseArrangeDao();
		for(int k=0;k<3;k++){
			if("周一".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+" "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon3=? where id=? and caterm=? and cayear=? ");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectMon5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set mon5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}
			ps.executeUpdate();
			ps.close();
		}else if("周二".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectTue5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set tue5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周三".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectWed5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set wed5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周四".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectThu5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set thu5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}else if("周五".equals(ca.getCourse().getCweekday()[k])){
			if("1-2节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri1(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri1=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("3-4节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri2(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri2=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("5-6节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri3(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri3=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("7-8节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri4(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri4=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}else if("9-10节".equals(ca.getCourse().getCjieshu()[k])){
				String c=dao.selectFri5(ca.getId(),ca.getCayear(),ca.getCaterm());
				ps=conn.prepareStatement("update coursearrange set fri5=? where id=? and caterm=? and cayear=?");
				ps.setString(1,c+ca.getCourse().getCname()+" "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
				ps.setString(2,ca.getId());
				ps.setString(3,ca.getCaterm());
				ps.setString(4,ca.getCayear());
			}ps.executeUpdate();
			ps.close();
		}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.clearAll(conn, ps);
		}
		return 0;
		}	
//选择出课程表某格内容
	public String selectCA(CourseArrange ca){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			if("周一".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select mon1 from coursearrange where id=? and caterm=? and cayear=? "
							+ " and mon1 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("mon1");
						return ca1;
						}
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select mon2 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and mon2 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("mon2");
						return ca1;
						}
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select mon3 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and mon3 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("mon3");
						return ca1;
						}
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select mon4 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and mon4 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("mon4");
						return ca1;
						}
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select mon5 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and mon5 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("mon5");
						return ca1;
						}
				}
			}else if("周二".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select tue1 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and tue1 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("tue1");
						return ca1;
						}
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select tue2 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and tue2 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("tue2");
						return ca1;
						}
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select tue3 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and tue3 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("tue3");
						return ca1;
						}
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select tue4 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and tue4 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("tue4");
						return ca1;
						}
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select tue5 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and tue5 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("tue5");
						return ca1;
						}
				}
			}else if("周三".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select wed1 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and wed1 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("wed1");
						return ca1;
						}
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select wed2 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and wed2 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("wed2");
						return ca1;
						}
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select wed3 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and wed3 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("wed3");
						return ca1;
						}
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select wed4 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and wed4 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("wed4");
						return ca1;
						}
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select wed5 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and wed5 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("wed5");
						return ca1;
						}
				}
			}else if("周四".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select thu1 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and thu1 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("thu1");
						return ca1;
						}
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select thu2 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and thu2 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("thu2");
						return ca1;
						}
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select thu3 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and thu3 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("thu3");
						return ca1;
						}
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select thu4 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and thu4 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("thu4");
						return ca1;
						}
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select thu5 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and thu5 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("thu5");
						return ca1;
						}
				}
			}else if("周五".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select fri1 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and fri1 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("fri1");
						return ca1;
						}
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select fri2 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and fri2 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("fri2");
						return ca1;
						}
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select fri3 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and fri3 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("fri3");
						return ca1;
						}
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select fri4 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and fri4 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("fri4");
						return ca1;
						}
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					ps=conn.prepareStatement("select fri5 from coursearrange where id=? and caterm=? and cayear=?"
							+ " and fri5 like '%"+ca.getCourse().getCshangke()+"%'");
					ps.setString(1, ca.getId());
					ps.setString(2, ca.getCaterm());
					ps.setString(3, ca.getCayear());
					rs = ps.executeQuery();
					if (rs.next()) {
						String ca1="";
						ca1=rs.getString("fri5");
						return ca1;
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
	
//删除课表某节
	public int deleteCA(CourseArrange ca) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {			
			CourseArrangeDao dao=new CourseArrangeDao();
			if("周一".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectMon1(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set mon1=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectMon2(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set mon2=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectMon3(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set mon3=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectMon4(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set mon4=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectMon5(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set mon5=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}ps.executeUpdate();
				ps.close();
			}else if("周二".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectTue1(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set tue1=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectTue2(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set tue2=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectTue3(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set tue3=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectTue4(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set tue4=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectTue5(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set tue5=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}ps.executeUpdate();
				ps.close();
			}else if("周三".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectWed1(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set wed1=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectWed2(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set wed2=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectWed3(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set wed3=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectWed4(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set wed4=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectWed5(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set wed5=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}ps.executeUpdate();
				ps.close();
			}else if("周四".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectThu1(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=ca.getCourse().getCname()+"  "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>";
					String s=s0.replaceAll(s1,"");
					ps=conn.prepareStatement("update coursearrange set thu1=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectThu2(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set thu2=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectThu3(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set thu3=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectThu4(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set thu4=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectThu5(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set thu5=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}ps.executeUpdate();
				ps.close();
			}else if("周五".equals(ca.getCourse().getCweekday()[0])){
				if("1-2节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectFri1(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set fri1=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("3-4节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectFri2(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set fri2=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("5-6节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectFri3(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set fri3=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("7-8节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectFri4(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set fri4=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}else if("9-10节".equals(ca.getCourse().getCjieshu()[0])){
					String s0=dao.selectFri5(ca.getId(),ca.getCayear(),ca.getCaterm());
					String s1=(ca.getCourse().getCname()+" "+ca.getCourse().getCteacher()+"  "+ca.getCourse().getCshangke()+"  "+ca.getCourse().getCplace()+"<br>");
					String s=s0.replaceAll(s1, "");
					ps=conn.prepareStatement("update coursearrange set fri5=? where id=? and caterm=? and cayear=?");
					ps.setString(1,s);
					ps.setString(2,ca.getId());
					ps.setString(3,ca.getCaterm());
					ps.setString(4,ca.getCayear());
				}ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	} finally {
			DBUtil.clearAll(conn, ps);
		}
		return 0;
	}

	public String selectMon1(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select mon1 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("mon1");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectMon2(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select mon2 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("mon2");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectMon3(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select mon3 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("mon3");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectMon4(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select mon4 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("mon4");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectMon5(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select mon5 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("mon5");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
	public String selectTue1(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select tue1 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("tue1");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectTue2(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select tue2 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("tue2");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectTue3(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select tue3 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("tue3");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectTue4(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select tue4 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("tue4");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectTue5(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select tue5 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("tue5");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectWed1(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select wed1 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("wed1");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectWed2(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select wed2 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("wed2");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectWed3(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select wed3 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("wed3");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectWed4(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select wed4 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("wed4");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectWed5(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select wed5 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("wed5");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectThu1(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select thu1 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("thu1");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectThu2(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select thu2 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("thu2");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectThu3(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select thu3 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("thu3");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectThu4(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select thu4 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("thu4");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectThu5(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select thu5 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("thu5");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectFri1(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select fri1 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("fri1");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectFri2(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select fri2 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("fri2");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectFri3(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select fri3 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("fri3");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectFri4(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select fri4 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("fri4");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public String selectFri5(String id,String year,String term){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {		
			ps=conn.prepareStatement("select fri5 from coursearrange where id=? and cayear=? and caterm=?");
			ps.setString(1, id);
			ps.setString(2, year);
			ps.setString(3, term);
			rs = ps.executeQuery();
			if (rs.next()) {
				String ca=null;
				ca=rs.getString("fri5");
				return ca;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}


}
