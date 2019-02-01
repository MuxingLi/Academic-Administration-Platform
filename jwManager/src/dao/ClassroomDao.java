package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import dto.Classroom;

public class ClassroomDao {
	public int insertClassroom(Classroom roominfo){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into classroom (rbuilding,rno,rtype,rseat,rmedia,rremark,a12,a34,a56,a78,a90,"
					+ "b12,b34,b56,b78,b90,c12,c34,c56,c78,c90,d12,d34,d56,d78,d90,e12,e34,e56,e78,e90,f12,f34,f56,f78,f90,"
					+ "g12,g34,g56,g78,g90) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,roominfo.getRbuilding());
			ps.setString(2,roominfo.getRno());
			ps.setString(3,roominfo.getRtype());
			ps.setString(4,roominfo.getRseat());
			ps.setString(5,roominfo.getRmedia());
			ps.setString(6,roominfo.getRremark());
			ps.setString(7,roominfo.getRavailable()[0]);
			ps.setString(8,roominfo.getRavailable()[1]);
			ps.setString(9,roominfo.getRavailable()[2]);
			ps.setString(10,roominfo.getRavailable()[3]);
			ps.setString(11,roominfo.getRavailable()[4]);
			ps.setString(12,roominfo.getRavailable()[5]);
			ps.setString(13,roominfo.getRavailable()[6]);
			ps.setString(14,roominfo.getRavailable()[7]);
			ps.setString(15,roominfo.getRavailable()[8]);
			ps.setString(16,roominfo.getRavailable()[9]);
			ps.setString(17,roominfo.getRavailable()[10]);
			ps.setString(18,roominfo.getRavailable()[11]);
			ps.setString(19,roominfo.getRavailable()[12]);
			ps.setString(20,roominfo.getRavailable()[13]);
			ps.setString(21,roominfo.getRavailable()[14]);
			ps.setString(22,roominfo.getRavailable()[15]);
			ps.setString(23,roominfo.getRavailable()[16]);
			ps.setString(24,roominfo.getRavailable()[17]);
			ps.setString(25,roominfo.getRavailable()[18]);
			ps.setString(26,roominfo.getRavailable()[19]);
			ps.setString(27,roominfo.getRavailable()[20]);
			ps.setString(28,roominfo.getRavailable()[21]);
			ps.setString(29,roominfo.getRavailable()[22]);
			ps.setString(30,roominfo.getRavailable()[23]);
			ps.setString(31,roominfo.getRavailable()[24]);
			ps.setString(32,roominfo.getRavailable()[25]);
			ps.setString(33,roominfo.getRavailable()[26]);
			ps.setString(34,roominfo.getRavailable()[27]);
			ps.setString(35,roominfo.getRavailable()[28]);
			ps.setString(36,roominfo.getRavailable()[29]);
			ps.setString(37,roominfo.getRavailable()[30]);
			ps.setString(38,roominfo.getRavailable()[31]);
			ps.setString(39,roominfo.getRavailable()[32]);
			ps.setString(40,roominfo.getRavailable()[33]);
			ps.setString(41,roominfo.getRavailable()[34]);
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
	public int deleteClassroomById(Classroom room) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;		
		try {
			ps = conn.prepareStatement("delete from classroom where rno=? and rbuilding=?");
			ps.setString(1, room.getRno());
			ps.setString(2, room.getRbuilding());
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
	public int updateClassroom(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set rtype=?,rseat=?,rmedia=?,"
					+ "rremark=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getRtype());
			ps.setString(2, classroom.getRseat());
			ps.setString(3, classroom.getRmedia());
			ps.setString(4, classroom.getRremark());
			ps.setString(5, classroom.getRno());
			ps.setString(6, classroom.getRbuilding());			
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
	public ArrayList<Classroom> selectAllClassrooms() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom");
			rs = ps.executeQuery();
			ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			cl.setRremark(rs.getString("rremark"));
			classrooms.add(cl);
			}
			return classrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectClassroomById(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[35];
			arr[0]=rs.getString("a12");
			arr[1]=rs.getString("a34");
			arr[2]=rs.getString("a56");			
			arr[3]=rs.getString("a78");			
			arr[4]=rs.getString("a90");			
			arr[5]=rs.getString("b12");			
			arr[6]=rs.getString("b34");			
			arr[7]=rs.getString("b56");			
			arr[8]=rs.getString("b78");			
			arr[9]=rs.getString("b90");			
			arr[10]=rs.getString("c12");			
			arr[11]=rs.getString("c34");			
			arr[12]=rs.getString("c56");			
			arr[13]=rs.getString("c78");			
			arr[14]=rs.getString("c90");			
			arr[15]=rs.getString("d12");			
			arr[16]=rs.getString("d34");			
			arr[17]=rs.getString("d56");			
			arr[18]=rs.getString("d78");			
			arr[19]=rs.getString("d90");			
			arr[20]=rs.getString("e12");			
			arr[21]=rs.getString("e34");			
			arr[22]=rs.getString("e56");			
			arr[23]=rs.getString("e78");			
			arr[24]=rs.getString("e90");			
			arr[25]=rs.getString("f12");			
			arr[26]=rs.getString("f34");			
			arr[27]=rs.getString("f56");			
			arr[28]=rs.getString("f78");			
			arr[29]=rs.getString("f90");			
			arr[30]=rs.getString("g12");			
			arr[31]=rs.getString("g34");			
			arr[32]=rs.getString("g56");			
			arr[33]=rs.getString("g78");			
			arr[34]=rs.getString("g90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//条件查找
	public ArrayList<Classroom> selectClassroom(String rseat, String rbuilding) {
		Connection conn = DBUtil.getConnection();
		String sql="select * from classroom where (rseat like '%"+rseat+"%' and rbuilding like '%"+rbuilding+"%')";
		PreparedStatement ps = null;
		java.sql.Statement pstmt=null;
		ResultSet rs = null;
		ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
		try {
			pstmt=conn.createStatement();
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRno(rs.getString("rno"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRreply(rs.getString("rremark"));
			classrooms.add(cl);
			}return classrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//分页
	public ArrayList<Classroom> fenye(int dangqianPage){
		ArrayList<Classroom> cfy = new ArrayList<Classroom>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom order by rbuilding,rno limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Classroom cl = new Classroom();
				cl.setRno(rs.getString("rno"));
				cl.setRbuilding(rs.getString("rbuilding"));
				cl.setRtype(rs.getString("rtype"));
				cl.setRseat(rs.getString("rseat"));
				cl.setRmedia(rs.getString("rmedia"));
				cl.setRremark(rs.getString("rremark"));
				cfy.add(cl);
			}return cfy;
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
			ps = conn.prepareStatement("select * from classroom");
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
	public ArrayList<Classroom> fenye1(int dangqianPage,String rseat, String rbuilding){
		ArrayList<Classroom> cfy = new ArrayList<Classroom>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from classroom where (rseat like '%"+rseat+"%' and"
						+ " rbuilding like '%"+rbuilding+"%') order by rbuilding,rno limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
				while(rs.next()){
					Classroom cl = new Classroom();
					cl.setRno(rs.getString("rno"));
					cl.setRbuilding(rs.getString("rbuilding"));
					cl.setRtype(rs.getString("rtype"));
					cl.setRseat(rs.getString("rseat"));
					cl.setRmedia(rs.getString("rmedia"));
					cl.setRremark(rs.getString("rremark"));
					cfy.add(cl);
				}return cfy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//查询-总数据数
	public int sumData1(String rseat, String rbuilding) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from classroom where (rseat like '%"+rseat+"%' and"
						+ " rbuilding like '%"+rbuilding+"%')");
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
	public int sumPageCount1(String rseat, String rbuilding) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(rseat, rbuilding);
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
//教学楼下拉列表
	public ArrayList<Classroom> building() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
		try {
			ps = conn.prepareStatement("select DISTINCT rbuilding from classroom");
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRbuilding(rs.getString("rbuilding"));
			classrooms.add(cl);
			}return classrooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
	public Classroom selectStatus1(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			String[] arr=new String[5];
			arr[0]=rs.getString("a12");
			arr[1]=rs.getString("a34");
			arr[2]=rs.getString("a56");			
			arr[3]=rs.getString("a78");			
			arr[4]=rs.getString("a90");					
			cl.setRavailable(arr);
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus2(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];
			arr[0]=rs.getString("b12");			
			arr[1]=rs.getString("b34");			
			arr[2]=rs.getString("b56");			
			arr[3]=rs.getString("b78");			
			arr[4]=rs.getString("b90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus3(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];
			arr[0]=rs.getString("c12");			
			arr[1]=rs.getString("c34");			
			arr[2]=rs.getString("c56");			
			arr[3]=rs.getString("c78");			
			arr[4]=rs.getString("c90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus4(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];
			arr[0]=rs.getString("d12");			
			arr[1]=rs.getString("d34");			
			arr[2]=rs.getString("d56");			
			arr[3]=rs.getString("d78");			
			arr[4]=rs.getString("d90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus5(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];
			arr[0]=rs.getString("e12");			
			arr[1]=rs.getString("e34");			
			arr[2]=rs.getString("e56");			
			arr[3]=rs.getString("e78");			
			arr[4]=rs.getString("e90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus6(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];		
			arr[0]=rs.getString("f12");			
			arr[1]=rs.getString("f34");			
			arr[2]=rs.getString("f56");			
			arr[3]=rs.getString("f78");			
			arr[4]=rs.getString("f90");				
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Classroom selectStatus7(Classroom classroom) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from classroom where rno=? and rbuilding=? ");
			ps.setString(1, classroom.getRno());
			ps.setString(2, classroom.getRbuilding());			
			rs = ps.executeQuery();
			while (rs.next()) {
			Classroom cl = new Classroom();
			cl.setRno(rs.getString("rno"));
			cl.setRbuilding(rs.getString("rbuilding"));
			cl.setRtype(rs.getString("rtype"));
			cl.setRseat(rs.getString("rseat"));
			cl.setRmedia(rs.getString("rmedia"));
			String[] arr=new String[5];	
			arr[0]=rs.getString("g12");			
			arr[1]=rs.getString("g34");			
			arr[2]=rs.getString("g56");			
			arr[3]=rs.getString("g78");			
			arr[4]=rs.getString("g90");			
			cl.setRavailable(arr);
			cl.setRremark(rs.getString("rremark"));
			return cl;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
	public int updateStatus1(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set a12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getA12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus2(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set a34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getA34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus3(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set a56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getA56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus4(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set a78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getA78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus5(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set a90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getA90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus6(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set b12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getB12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus7(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set b34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getB34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus8(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set b56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getB56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus9(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set b78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getB78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus10(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set b90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getB90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus11(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set c12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getC12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus12(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set c34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getC34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus13(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set c56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getC56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus14(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set c78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getC78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus15(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set c90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getC90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus16(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set d12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getD12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus17(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set d34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getD34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus18(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set d56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getD56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus19(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set d78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getD78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus20(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set d90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getD90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus21(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set e12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getE12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus22(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set e34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getE34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus23(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set e56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getE56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus24(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set e78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getE78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus25(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set e90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getE90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus26(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set f12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getF12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus27(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set f34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getF34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus28(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set f56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getF56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus29(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set f78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getF78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus30(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set f90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getF90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus31(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set g12=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getG12());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus32(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set g34=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getG34());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus33(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set g56=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getG56());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus34(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set g78=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getG78());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
	public int updateStatus35(Classroom classroom){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update classroom set g90=? where rno=? and rbuilding=?");
			ps.setString(1, classroom.getG90());
			ps.setString(2, classroom.getRno());
			ps.setString(3, classroom.getRbuilding());
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
}
