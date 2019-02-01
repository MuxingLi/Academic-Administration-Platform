package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import dto.RoomApply;

public class RoomApplyDao {

	public int insertApply(RoomApply roomapply){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into roomapply (id,building,no,type,seat,media,time,jieshu,usetime,status,remark) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,roomapply.getId());
			ps.setString(2,roomapply.getBuilding());
			ps.setString(3,roomapply.getNo());
			ps.setString(4,roomapply.getType());
			ps.setString(5,roomapply.getSeat());
			ps.setString(6,roomapply.getMedia());
			ps.setString(7,roomapply.getTime());
			ps.setString(8,roomapply.getJieshu());
			ps.setString(9,roomapply.getUsetime());
			ps.setString(10,roomapply.getStatus());
			ps.setString(11,roomapply.getRemark());
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
	public ArrayList<RoomApply> selectAllApplys(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply");
			rs = ps.executeQuery();
			ArrayList<RoomApply> applys = new ArrayList<RoomApply>();
			while (rs.next()) {
			RoomApply ra = new RoomApply();
			ra.setId(rs.getString("id"));
			ra.setBuilding(rs.getString("building"));
			ra.setNo(rs.getString("no"));
			ra.setType(rs.getString("type"));
			ra.setSeat(rs.getString("seat"));
			ra.setMedia(rs.getString("media"));
			ra.setTime(rs.getString("time"));
			ra.setJieshu(rs.getString("jieshu"));
			ra.setUsetime(rs.getString("usetime"));
			ra.setStatus(rs.getString("status"));
			ra.setRemark(rs.getString("remark"));
			ra.setReply(rs.getString("reply"));
			applys.add(ra);
			}
			return applys;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
	public RoomApply selectApplyBySth(RoomApply roomapply){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply where id=? and building=? and no=? and jieshu=? and usetime=?");
			ps.setString(1, roomapply.getId());
			ps.setString(2, roomapply.getBuilding());
			ps.setString(3, roomapply.getNo());			
			ps.setString(4, roomapply.getJieshu());
			ps.setString(5, roomapply.getUsetime());
			rs = ps.executeQuery();
			while (rs.next()) {
				RoomApply ra = new RoomApply();
				ra.setId(rs.getString("id"));
				ra.setBuilding(rs.getString("building"));
				ra.setNo(rs.getString("no"));
				ra.setType(rs.getString("type"));
				ra.setSeat(rs.getString("seat"));
				ra.setMedia(rs.getString("media"));
				ra.setTime(rs.getString("time"));
				ra.setJieshu(rs.getString("jieshu"));
				ra.setUsetime(rs.getString("usetime"));
				ra.setStatus(rs.getString("status"));
				ra.setRemark(rs.getString("remark"));
				ra.setReply(rs.getString("reply"));
				return ra;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		
		return roomapply;
	}
	public int updateStatusAccept(RoomApply roomapply){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update roomapply set status=? where id=? and building=? and no=? and usetime=? and jieshu=?");
			ps.setString(1, roomapply.getStatus());
			ps.setString(2, roomapply.getId());
			ps.setString(3, roomapply.getBuilding());
			ps.setString(4, roomapply.getNo());
			ps.setString(5, roomapply.getUsetime());
			ps.setString(6, roomapply.getJieshu());
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
	public int updateStatusRefuse(RoomApply roomapply){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update roomapply set status=?,reply=? where id=? and building=? and no=? and usetime=? and jieshu=?");
			ps.setString(1, roomapply.getStatus());
			ps.setString(2, roomapply.getReply());
			ps.setString(3, roomapply.getId());
			ps.setString(4, roomapply.getBuilding());
			ps.setString(5, roomapply.getNo());
			ps.setString(6, roomapply.getUsetime());
			ps.setString(7, roomapply.getJieshu());
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
	public ArrayList<RoomApply> selectApplysByTechid(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			ArrayList<RoomApply> applys = new ArrayList<RoomApply>();
			while (rs.next()) {
			RoomApply ra = new RoomApply();
			ra.setId(rs.getString("id"));
			ra.setBuilding(rs.getString("building"));
			ra.setNo(rs.getString("no"));
			ra.setType(rs.getString("type"));
			ra.setSeat(rs.getString("seat"));
			ra.setMedia(rs.getString("media"));
			ra.setTime(rs.getString("time"));
			ra.setJieshu(rs.getString("jieshu"));
			ra.setUsetime(rs.getString("usetime"));
			ra.setStatus(rs.getString("status"));
			ra.setRemark(rs.getString("remark"));
			ra.setReply(rs.getString("reply"));
			applys.add(ra);
			}
			return applys;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//分页
	public ArrayList<RoomApply> fenye(int dangqianPage){
		ArrayList<RoomApply> rafy = new ArrayList<RoomApply>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply order by time DESC limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				RoomApply ra = new RoomApply();
				ra.setId(rs.getString("id"));
				ra.setBuilding(rs.getString("building"));
				ra.setNo(rs.getString("no"));
				ra.setType(rs.getString("type"));
				ra.setSeat(rs.getString("seat"));
				ra.setMedia(rs.getString("media"));
				ra.setTime(rs.getString("time"));
				ra.setJieshu(rs.getString("jieshu"));
				ra.setUsetime(rs.getString("usetime"));
				ra.setStatus(rs.getString("status"));
				ra.setRemark(rs.getString("remark"));
				ra.setReply(rs.getString("reply"));
				rafy.add(ra);
			}return rafy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//总数据
	public int sumData() {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply");
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
//查询的分页
	public ArrayList<RoomApply> fenye1(int dangqianPage,String time, String usetime, String id){
		ArrayList<RoomApply> rafy = new ArrayList<RoomApply>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from roomapply where (id like '%"+id+"%' and usetime like '%"+usetime+"%'"
						+ " and time like'%"+time+"%') order by time DESC limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
			while(rs.next()){
				RoomApply ra = new RoomApply();
				ra.setId(rs.getString("id"));
				ra.setBuilding(rs.getString("building"));
				ra.setNo(rs.getString("no"));
				ra.setType(rs.getString("type"));
				ra.setSeat(rs.getString("seat"));
				ra.setMedia(rs.getString("media"));
				ra.setTime(rs.getString("time"));
				ra.setJieshu(rs.getString("jieshu"));
				ra.setUsetime(rs.getString("usetime"));
				ra.setStatus(rs.getString("status"));
				ra.setRemark(rs.getString("remark"));
				ra.setReply(rs.getString("reply"));
				rafy.add(ra);
			}return rafy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//查询总数据
	public int sumData1(String time, String usetime, String id) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from roomapply where (id like '%"+id+"%' and usetime like '%"+usetime+"%'"
						+ " and time like'%"+time+"%')");
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
	public int sumPageCount1(String time, String usetime, String id) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(time,usetime,id);
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
//教师查看申请分页
	public ArrayList<RoomApply> fenye2(int dangqianPage, String id){
		ArrayList<RoomApply> rafy = new ArrayList<RoomApply>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply where id='"+id+"' order by time DESC limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				RoomApply ra = new RoomApply();
				ra.setId(rs.getString("id"));
				ra.setBuilding(rs.getString("building"));
				ra.setNo(rs.getString("no"));
				ra.setType(rs.getString("type"));
				ra.setSeat(rs.getString("seat"));
				ra.setMedia(rs.getString("media"));
				ra.setTime(rs.getString("time"));
				ra.setJieshu(rs.getString("jieshu"));
				ra.setUsetime(rs.getString("usetime"));
				ra.setStatus(rs.getString("status"));
				ra.setRemark(rs.getString("remark"));
				ra.setReply(rs.getString("reply"));
				rafy.add(ra);
			}return rafy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//教师查看申请总数据数
	public int sumData2(String id) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from roomapply where id='"+id+"' ");
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
//教师查看申请总页数
	public int sumPageCount2(String id) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData2(id);
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
//教师查看申请-查询-分页
	public ArrayList<RoomApply> fenye3(int dangqianPage,String time, String usetime, String id, String status){
		ArrayList<RoomApply> rafy = new ArrayList<RoomApply>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from roomapply where (id like '%"+id+"%' and usetime like '%"+usetime+"%'"
						+ " and time like'%"+time+"%' and status like'%"+status+"%') order by time DESC limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
			while(rs.next()){
				RoomApply ra = new RoomApply();
				ra.setId(rs.getString("id"));
				ra.setBuilding(rs.getString("building"));
				ra.setNo(rs.getString("no"));
				ra.setType(rs.getString("type"));
				ra.setSeat(rs.getString("seat"));
				ra.setMedia(rs.getString("media"));
				ra.setTime(rs.getString("time"));
				ra.setJieshu(rs.getString("jieshu"));
				ra.setUsetime(rs.getString("usetime"));
				ra.setStatus(rs.getString("status"));
				ra.setRemark(rs.getString("remark"));
				ra.setReply(rs.getString("reply"));
				rafy.add(ra);
			}return rafy;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//教师查看申请-查询-总数据数
	public int sumData3(String time, String usetime, String id, String status) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
				ps = conn.prepareStatement("select * from roomapply where (id like '%"+id+"%' and usetime like '%"+usetime+"%'"
						+ " and time like'%"+time+"%' and status like'%"+status+"%')");
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
//教师查看申请-查询-页数
	public int sumPageCount3(String time, String usetime, String id, String status) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData3(time, usetime, id, status);
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
