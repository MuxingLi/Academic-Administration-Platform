package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.DBUtil;
import dto.Teacher;


public class TeacherDao {
	
	public Teacher login(Teacher user) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teacher where id=? ");
			ps.setString(1, user.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getString("id"));
				t.setRole(rs.getString("role"));
				t.setPassword(rs.getString("password"));
				return t;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public int insertTeacher(Teacher teacherinfo){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,teacherinfo.getId());
			ps.setString(2,teacherinfo.getName());
			ps.setString(3,teacherinfo.getTechsex());
			ps.setString(4,teacherinfo.getTechpic());
			ps.setString(5,teacherinfo.getTechbirth());
			ps.setString(6,teacherinfo.getTechlook());
			ps.setString(7,teacherinfo.getTechnation());
			ps.setString(8,teacherinfo.getTechtel());
			ps.setString(9,teacherinfo.getTechidentity());
			ps.setString(10,teacherinfo.getTechenterdate());
			ps.setString(11,teacherinfo.getTechdepartment());
			ps.setString(12,teacherinfo.getTechzhicheng());
			ps.setString(13,teacherinfo.getTechaddress());
			ps.setString(14,teacherinfo.getTecheducation());
			ps.setString(15,teacherinfo.getTechaward());
			ps.setString(16,teacherinfo.getTechkeyan());
			ps.setString(17,teacherinfo.getTechremark());
			ps.setString(18,teacherinfo.getPassword());
			ps.setString(19,teacherinfo.getRole());
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
	public int deleteTeacherById(String techid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from teacher where id=?");
			ps.setString(1, techid);
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
	public int updateTeacherpwd(Teacher teacherpwd) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update teacher set password=? where id=?");
			ps.setString(1, teacherpwd.getPassword());
			ps.setString(2, teacherpwd.getId());
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
	public int updateTeacher(Teacher teacher) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update teacher set name=?,techsex=?,techpic=?,"
					+ "techbirth=?,techlook=?,technation=?,techtel=?,techidentity=?,techdepartment=?,"
					+ "techenterdate=?,techzhicheng=?,techaddress=?,techeducation=?,techaward=?,"
					+ "techkeyan=?,techremark=? where id=?");
			ps.setString(1,teacher.getName());
			ps.setString(2,teacher.getTechsex());
			ps.setString(3,teacher.getTechpic());
			ps.setString(4,teacher.getTechbirth());
			ps.setString(5,teacher.getTechlook());
			ps.setString(6,teacher.getTechnation());
			ps.setString(7,teacher.getTechtel());
			ps.setString(8,teacher.getTechidentity());
			ps.setString(9,teacher.getTechdepartment());
			ps.setString(10,teacher.getTechenterdate());
			ps.setString(11,teacher.getTechzhicheng());
			ps.setString(12,teacher.getTechaddress());
			ps.setString(13,teacher.getTecheducation());
			ps.setString(14,teacher.getTechaward());
			ps.setString(15,teacher.getTechkeyan());
			ps.setString(16,teacher.getTechremark());
			ps.setString(17,teacher.getId());
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
	public ArrayList<Teacher> selectAllTeachers() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teacher");
			rs = ps.executeQuery();
			ArrayList<Teacher> teachers = new ArrayList<Teacher>();
			while (rs.next()) {
			Teacher t = new Teacher();
			t.setId(rs.getString("id"));
			t.setName(rs.getString("name"));
			t.setTechsex(rs.getString("techsex"));
			t.setTechpic(rs.getString("techpic"));
			t.setTechbirth(rs.getString("techbirth"));
			t.setTechlook(rs.getString("techlook"));
			t.setTechnation(rs.getString("technation"));
			t.setTechtel(rs.getString("techtel"));
			t.setTechidentity(rs.getString("techidentity"));
			t.setTechenterdate(rs.getString("techenterdate"));
			t.setTechdepartment(rs.getString("techdepartment"));
			t.setTechzhicheng(rs.getString("techzhicheng"));
			t.setTechaddress(rs.getString("techaddress"));
			t.setTecheducation(rs.getString("techeducation"));
			t.setTechaward(rs.getString("techaward"));
			t.setTechkeyan(rs.getString("techkeyan"));
			t.setTechremark(rs.getString("techremark"));
			teachers.add(t);
			}
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
	public Teacher selectTeacherById(String techid){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from teacher where id=?");
			ps.setString(1,techid);
			rs=ps.executeQuery();
			if(rs.next()){
				Teacher t=new Teacher();
				t.setId(rs.getString("id"));
				t.setName(rs.getString("name"));
				t.setTechsex(rs.getString("techsex"));
				t.setTechpic(rs.getString("techpic"));
				t.setTechbirth(rs.getString("techbirth"));
				t.setTechlook(rs.getString("techlook"));
				t.setTechnation(rs.getString("technation"));
				t.setTechtel(rs.getString("techtel"));
				t.setTechidentity(rs.getString("techidentity"));
				t.setTechenterdate(rs.getString("techenterdate"));
				t.setTechdepartment(rs.getString("techdepartment"));
				t.setTechzhicheng(rs.getString("techzhicheng"));
				t.setTechaddress(rs.getString("techaddress"));
				t.setTecheducation(rs.getString("techeducation"));
				t.setTechaward(rs.getString("techaward"));
				t.setTechkeyan(rs.getString("techkeyan"));
				t.setTechremark(rs.getString("techremark"));
				return t;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
			Teacher teacher=null;
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
			String techsex;
			String techpic;
			String techbirth;
			String techlook;
			String technation;
			String techtel;
			String techidentity;
			String techenterdate;
			String techdepartment;
			String techzhicheng;
			String techaddress;
			String techeducation;
			String techaward;
			String techkeyan;
			String techremark;
			String password;
			String role;
			System.out.println(totalrow);
			for(short i=1;i<=totalrow;i++)
			{
				teacher = new Teacher();
				row=sheet.getRow(i);
				cell=row.getCell((short)0);
				if(cell!=null)
				{
					id=cell.toString();
					teacher.setId(id);
				}
				cell=row.getCell((short)1);
				if(cell!=null)
				{
					name=cell.toString();
					teacher.setName(name);
				}
				cell=row.getCell((short)2);
				if(cell!=null)
				{
					techsex=cell.toString();
					teacher.setTechsex(techsex);
				}
				cell=row.getCell((short)3);
				if(cell!=null)
				{
					techpic=cell.toString();
					teacher.setTechpic(techpic);
				}
				cell=row.getCell((short)4);
				if(cell!=null)
				{
					techbirth=cell.toString();
					teacher.setTechbirth(techbirth);
				}
				cell=row.getCell((short)5);
				if(cell!=null)
				{
					techlook=cell.toString();
					teacher.setTechlook(techlook);
				}
				cell=row.getCell((short)6);
				if(cell!=null)
				{
					technation=cell.toString();
					teacher.setTechnation(technation);
				}
				cell=row.getCell((short)7);
				if(cell!=null)
				{
					techtel=cell.toString();
					teacher.setTechtel(techtel);
				}
				cell=row.getCell((short)8);
				if(cell!=null)
				{
					techidentity=cell.toString();
					teacher.setTechidentity(techidentity);
				}
				cell=row.getCell((short)9);
				if(cell!=null)
				{
					techenterdate=cell.toString();
					teacher.setTechenterdate(techenterdate);
				}
				cell=row.getCell((short)10);
				if(cell!=null)
				{
					techdepartment=cell.toString();
					teacher.setTechdepartment(techdepartment);
				}
				cell=row.getCell((short)11);
				if(cell!=null)
				{
					techzhicheng=cell.toString();
					teacher.setTechzhicheng(techzhicheng);
				}
				cell=row.getCell((short)12);
				if(cell!=null)
				{
					techaddress=cell.toString();
					teacher.setTechaddress(techaddress);
				}cell=row.getCell((short)13);
				if(cell!=null)
				{
					techeducation=cell.toString();
					teacher.setTecheducation(techeducation);
				}
				cell=row.getCell((short)14);
				if(cell!=null)
				{
					techaward=cell.toString();
					teacher.setTechaward(techaward);
				}
				cell=row.getCell((short)15);
				if(cell!=null)
				{
					techkeyan=cell.toString();
					teacher.setTechkeyan(techkeyan);
				}
				cell=row.getCell((short)16);
				if(cell!=null)
				{
					techremark=cell.toString();
					teacher.setTechremark(techremark);
				}
				cell=row.getCell((short)17);
				if(cell!=null)
				{
					password=cell.toString();
					teacher.setPassword(password);
				}
				cell=row.getCell((short)18);
				if(cell!=null)
				{
					role=cell.toString();
					teacher.setRole(role);
				}
				ps=conn.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,teacher.getId());
				System.out.println(teacher.getId());
				ps.setString(2,teacher.getName());
				ps.setString(3,teacher.getTechsex());
				ps.setString(4,teacher.getTechpic());
				ps.setString(5,teacher.getTechbirth());
				ps.setString(6,teacher.getTechlook());
				ps.setString(7,teacher.getTechnation());
				ps.setString(8,teacher.getTechtel());
				ps.setString(9,teacher.getTechidentity());
				ps.setString(10,teacher.getTechenterdate());
				ps.setString(11,teacher.getTechdepartment());
				ps.setString(12,teacher.getTechzhicheng());
				ps.setString(13,teacher.getTechaddress());
				ps.setString(14,teacher.getTecheducation());
				ps.setString(15,teacher.getTechaward());
				ps.setString(16,teacher.getTechkeyan());
				ps.setString(17,teacher.getTechremark());
				ps.setString(18,teacher.getPassword());
				ps.setString(19,teacher.getRole());
				DBUtil.beginTrans(conn);
				j=ps.executeUpdate();
				DBUtil.endTrans(conn);
		}	return j;
			//conn=DBUtil.getConnection();
			//DBUtil.clearAll(conn, ps);
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
	public ArrayList<String> selectTeacherName(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select name from teacher");
			rs = ps.executeQuery();
			ArrayList<String> teachers = new ArrayList<String>();
			while (rs.next()) {
			teachers.add(rs.getString(1));
			}
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
}
	public Teacher selectTeacherByName(String name){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from teacher where name=?");
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next()){
				Teacher t=new Teacher();
				t.setId(rs.getString("id"));
				t.setName(rs.getString("name"));
				t.setTechsex(rs.getString("techsex"));
				t.setTechpic(rs.getString("techpic"));
				t.setTechbirth(rs.getString("techbirth"));
				t.setTechlook(rs.getString("techlook"));
				t.setTechnation(rs.getString("technation"));
				t.setTechtel(rs.getString("techtel"));
				t.setTechidentity(rs.getString("techidentity"));
				t.setTechenterdate(rs.getString("techenterdate"));
				t.setTechdepartment(rs.getString("techdepartment"));
				t.setTechzhicheng(rs.getString("techzhicheng"));
				t.setTechaddress(rs.getString("techaddress"));
				t.setTecheducation(rs.getString("techeducation"));
				t.setTechaward(rs.getString("techaward"));
				t.setTechkeyan(rs.getString("techkeyan"));
				t.setTechremark(rs.getString("techremark"));
				return t;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//条件查找
	public ArrayList<Teacher> selectTeacher(String id, String name, String zhicheng, String dept) {
		Connection conn = DBUtil.getConnection();
		String sql="select * from teacher where (id like '%"+id+"%' and name like '%"+name+"%'"
				+ " and techzhicheng like '%"+zhicheng+"%' and techdepartment like '%"+dept+"%')";
		PreparedStatement ps = null;
		java.sql.Statement pstmt=null;
		ResultSet rs = null;
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {
			pstmt=conn.createStatement();
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
			Teacher t = new Teacher();
			t.setId(rs.getString("id"));
			t.setName(rs.getString("name"));
			t.setTechdepartment(rs.getString("techdepartment"));
			t.setTechzhicheng(rs.getString("techzhicheng"));
			teachers.add(t);
			}return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//院系下拉列表
	public ArrayList<Teacher> depart() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {
			ps = conn.prepareStatement("select DISTINCT techdepartment from teacher");
			rs = ps.executeQuery();
			while (rs.next()) {
			Teacher t = new Teacher();
			t.setTechdepartment(rs.getString("techdepartment"));
			teachers.add(t);
			}return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//职称下拉列表
	public ArrayList<Teacher> zhicheng() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {
			ps = conn.prepareStatement("select DISTINCT techzhicheng from teacher");
			rs = ps.executeQuery();
			while (rs.next()) {
			Teacher t = new Teacher();
			t.setTechzhicheng(rs.getString("techzhicheng"));
			teachers.add(t);
			}return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//分页
	public ArrayList<Teacher> fenye(int dangqianPage){
		ArrayList<Teacher> techFY = new ArrayList<Teacher>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from teacher order by id limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Teacher t = new Teacher();
				t.setId(rs.getString("id"));
				t.setName(rs.getString("name"));
				t.setTechsex(rs.getString("techsex"));
				t.setTechpic(rs.getString("techpic"));
				t.setTechbirth(rs.getString("techbirth"));
				t.setTechlook(rs.getString("techlook"));
				t.setTechnation(rs.getString("technation"));
				t.setTechtel(rs.getString("techtel"));
				t.setTechidentity(rs.getString("techidentity"));
				t.setTechenterdate(rs.getString("techenterdate"));
				t.setTechdepartment(rs.getString("techdepartment"));
				t.setTechzhicheng(rs.getString("techzhicheng"));
				t.setTechaddress(rs.getString("techaddress"));
				t.setTecheducation(rs.getString("techeducation"));
				t.setTechaward(rs.getString("techaward"));
				t.setTechkeyan(rs.getString("techkeyan"));
				t.setTechremark(rs.getString("techremark"));
				techFY.add(t);
			}return techFY;
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
			ps = conn.prepareStatement("select * from teacher");
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
	public ArrayList<Teacher> fenye1(int dangqianPage,String id, String name, String zhicheng, String dept){
		ArrayList<Teacher> techFY = new ArrayList<Teacher>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if("".equals(zhicheng)){
				ps = conn.prepareStatement("select * from teacher where (id like '%"+id+"%' and name like '%"+name+"%'"
						+ " and techzhicheng like'%"+zhicheng+"%' and techdepartment like '%"+dept+"%')"
								+ "order by id limit "+8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
			}else{
				ps = conn.prepareStatement("select * from teacher where (id like '%"+id+"%' and name like '%"+name+"%'"
						+ " and techzhicheng='"+zhicheng+"' and techdepartment like '%"+dept+"%')"
								+ " limit "+ 8*(dangqianPage-1)+","+8+"");
				rs = ps.executeQuery();
			}			
			while(rs.next()){
				Teacher t = new Teacher();
				t.setId(rs.getString("id"));
				t.setName(rs.getString("name"));
				t.setTechsex(rs.getString("techsex"));
				t.setTechpic(rs.getString("techpic"));
				t.setTechbirth(rs.getString("techbirth"));
				t.setTechlook(rs.getString("techlook"));
				t.setTechnation(rs.getString("technation"));
				t.setTechtel(rs.getString("techtel"));
				t.setTechidentity(rs.getString("techidentity"));
				t.setTechenterdate(rs.getString("techenterdate"));
				t.setTechdepartment(rs.getString("techdepartment"));
				t.setTechzhicheng(rs.getString("techzhicheng"));
				t.setTechaddress(rs.getString("techaddress"));
				t.setTecheducation(rs.getString("techeducation"));
				t.setTechaward(rs.getString("techaward"));
				t.setTechkeyan(rs.getString("techkeyan"));
				t.setTechremark(rs.getString("techremark"));
				techFY.add(t);
			}return techFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
//查询-总记录数
	public int sumData1(String id, String name, String zhicheng, String dept) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			if("".equals(zhicheng)){
				ps = conn.prepareStatement("select * from teacher where (id like '%"+id+"%' and name like '%"+name+"%'"
						+ " and techzhicheng like'%"+zhicheng+"%' and techdepartment like '%"+dept+"%')");
				rs = ps.executeQuery();
			}else{
				ps = conn.prepareStatement("select * from teacher where (id like '%"+id+"%' and name like '%"+name+"%'"
						+ " and techzhicheng='"+zhicheng+"' and techdepartment like '%"+dept+"%')");
				rs = ps.executeQuery();
			}		
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
	public int sumPageCount1(String id, String name, String zhicheng, String dept) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(id,name,zhicheng,dept);
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
