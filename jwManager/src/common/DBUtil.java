package common;

import java.sql.*;

import com.mysql.jdbc.Statement;

public class DBUtil {
	/**
	 * �����ݿ�����
	 * 
	 * */
	public static Connection getConnection() {
		try {
			// ���������
			Class.forName("com.mysql.jdbc.Driver");
			// �����ݿ����Ӷ���
			// jdbc:��ݿ⣺��ݿ�Э�飺@��ݿ������IP���˿ںţ�SID,�û�������
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jw", "root", "123");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ʼ����
	 * 
	 * */
	public static void beginTrans(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ύ����
	 * 
	 * */
	public static void endTrans(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����ع�
	 * 
	 * */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ر���Դ
	 * 
	 * */
	public static void clearAll(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clearAll(Connection conn, PreparedStatement ps,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			clearAll(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*	public static void clearAll(Connection conn, Statement stmt) {
		try {
			if (stmt!= null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
/*	public static Statement getStatement(Connection conn) {
		try {
			conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

/*	public static boolean executeQuery(Statement stmt, String sql) {
		// TODO 自动生成的方法存根
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}*/
	

/*	public void DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jw", "root", "123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			  System.err.println("装载 JDBC/ODBC 驱动程序失败。" );  
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("无法连接数据库" ); 
			e.printStackTrace();
		}
}

// 查询
public ResultSet  Search(String sql, String str[]) {
	DataBase();
	try {
		Connection conn;
		PreparedStatement ps =conn.prepareStatement(sql);
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				ps.setString(i + 1, str[i]);
			}
		}
		res = ps.executeQuery();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}

// 增删修改
public int AddU(String sql, String str[]) {
	int a = 0;
	DataBase();
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				ps.setString(i + 1, str[i]);
			}
		}
		a = ps.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
}
*/

}
