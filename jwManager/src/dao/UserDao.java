package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBUtil;
import dto.User;

public class UserDao {

	public User login(User user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from usertable where id=?");
			ps.setString(1, user.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}

	public int deleteUserById(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from usertable where id=?");
			ps.setString(1, id);
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

	public int updateUser(User user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update usertable set password=? where id=?");
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getId());
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
	public static void main(String[] args) throws SQLException {

	}
}
