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
import dto.Program;

public class ProgramDao {
//插入4个
	public int insertProgram4(Program pro){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into program (dept,term,cid1,cp1,cid2,cp2,cid3,cp3,cid4,cp4)"
					+ " values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pro.getDept());
			ps.setString(2, pro.getTerm());
			ps.setString(3, pro.getCid()[0]);
			ps.setString(4, pro.getCp()[0]);
			ps.setString(5, pro.getCid()[1]);
			ps.setString(6, pro.getCp()[1]);
			ps.setString(7, pro.getCid()[2]);
			ps.setString(8, pro.getCp()[2]);
			ps.setString(9, pro.getCid()[3]);
			ps.setString(10, pro.getCp()[3]);
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
//插入3个
	public int insertProgram3(Program pro){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into program (dept,term,cid1,cp1,cid2,cp2,cid3,cp3,cid4,cp4)"
					+ " values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pro.getDept());
			ps.setString(2, pro.getTerm());
			ps.setString(3, pro.getCid()[0]);
			ps.setString(4, pro.getCp()[0]);
			ps.setString(5, pro.getCid()[1]);
			ps.setString(6, pro.getCp()[1]);
			ps.setString(7, pro.getCid()[2]);
			ps.setString(8, pro.getCp()[2]);
			ps.setString(9, "");
			ps.setString(10, "");
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
//插入2个
	public int insertProgram2(Program pro){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into program (dept,term,cid1,cp1,cid2,cp2,cid3,cp3,cid4,cp4)"
					+ " values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pro.getDept());
			ps.setString(2, pro.getTerm());
			ps.setString(3, pro.getCid()[0]);
			ps.setString(4, pro.getCp()[0]);
			ps.setString(5, pro.getCid()[1]);
			ps.setString(6, pro.getCp()[1]);
			ps.setString(7, "");
			ps.setString(8, "");
			ps.setString(9, "");
			ps.setString(10, "");
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
//插入1个
	public int insertProgram1(Program pro){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into program (dept,term,cid1,cp1,cid2,cp2,cid3,cp3,cid4,cp4)"
					+ " values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pro.getDept());
			ps.setString(2, pro.getTerm());
			ps.setString(3, pro.getCid()[0]);
			ps.setString(4, pro.getCp()[0]);
			ps.setString(5, "");
			ps.setString(6, "");
			ps.setString(7, "");
			ps.setString(8, "");
			ps.setString(9, "");
			ps.setString(10, "");
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
//删除
	public int deleteProgram(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from program where id=?");
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
//修改4
	public int updateProgram4(Program pro) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update program set dept=?,term=?,cid1=?,cid2=?,cid3=?,cid4=?,"
					+ "cp1=?,cp2=?,cp3=?,cp4=?");
			ps.setString(1,pro.getDept());
			ps.setString(2, pro.getTerm());
			ps.setString(3, pro.getCid1());
			ps.setString(4, pro.getCid2());
			ps.setString(5, pro.getCid3());
			ps.setString(6, pro.getCid4());
			ps.setString(7, pro.getCp1());
			ps.setString(8, pro.getCp2());
			ps.setString(9, pro.getCp3());
			ps.setString(10, pro.getCp4());
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
//查看所有byid
	public Program selectProgramById(String id){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				Program p = new Program();
				p.setId(rs.getString("id"));
				p.setDept(rs.getString("dept"));
				p.setTerm(rs.getString("term"));
				p.setCid1(rs.getString("cid1"));
				p.setCid2(rs.getString("cid2"));
				p.setCid3(rs.getString("cid3"));
				p.setCid4(rs.getString("cid4"));
				p.setCp1(rs.getString("cp1"));
				p.setCp2(rs.getString("cp2"));
				p.setCp3(rs.getString("cp3"));
				p.setCp4(rs.getString("cp4"));
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
//分页查看
	public ArrayList<Program> fenye(int dangqianPage){
		ArrayList<Program> proFY = new ArrayList<Program>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from program limit "+ 4*(dangqianPage-1)+","+4+"");
			rs = ps.executeQuery();
			while(rs.next()){
				Program p = new Program();
				p.setId(rs.getString("id"));
				p.setDept(rs.getString("dept"));
				p.setTerm(rs.getString("term"));
				p.setCid1(rs.getString("cid1"));
				p.setCid2(rs.getString("cid2"));
				p.setCid3(rs.getString("cid3"));
				p.setCid4(rs.getString("cid4"));
				p.setCp1(rs.getString("cp1"));
				p.setCp2(rs.getString("cp2"));
				p.setCp3(rs.getString("cp3"));
				p.setCp4(rs.getString("cp4"));
				proFY.add(p);
			}return proFY;
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
			ps = conn.prepareStatement("select * from program");
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
				sumPageCount=sumPage/4;
			}else{
				sumPageCount=sumPage/4+1;
			}return sumPageCount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
//通过院系和学期查看
	public Program selectProgramByDT(Program pro){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where dept=? and term=?");
			ps.setString(1,pro.getDept());
			ps.setString(2,pro.getTerm());
			rs=ps.executeQuery();
			if(rs.next()){
				Program p = new Program();
				p.setId(rs.getString("id"));
				p.setDept(rs.getString("dept"));
				p.setTerm(rs.getString("term"));
				p.setCid1(rs.getString("cid1"));
				p.setCid2(rs.getString("cid2"));
				p.setCid3(rs.getString("cid3"));
				p.setCid4(rs.getString("cid4"));
				p.setCp1(rs.getString("cp1"));
				p.setCp2(rs.getString("cp2"));
				p.setCp3(rs.getString("cp3"));
				p.setCp4(rs.getString("cp4"));
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}	
//表格上传教学计划
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
			Program pro=null;
			try{
				System.out.println("生成句柄成功");
			}
			catch(Exception ex)
			{
				System.out.println("生成句柄失败");
			}
			int j = 0;
			String id;
			String dept;
			String term;
			String cid1;
			String cp1;
			String cid2;
			String cp2;
			String cid3;
			String cp3;
			String cid4;
			String cp4;			
			System.out.println(totalrow);
			for(short i=1;i<=totalrow;i++)
			{
				pro = new Program();
				row=sheet.getRow(i);
				cell=row.getCell((short)0);
				if(cell!=null)
				{
					id=cell.toString();
					pro.setId(id);
				}
				cell=row.getCell((short)1);
				if(cell!=null)
				{
					dept=cell.toString();
					pro.setDept(dept);
				}
				cell=row.getCell((short)2);
				if(cell!=null)
				{
					term=cell.toString();
					pro.setTerm(term);
				}
				cell=row.getCell((short)3);
				if(cell!=null)
				{
					cid1=cell.toString();
					pro.setCid1(cid1);
				}
				cell=row.getCell((short)4);
				if(cell!=null)
				{
					cp1=cell.toString();
					pro.setCp1(cp1);
				}
				cell=row.getCell((short)5);
				if(cell!=null)
				{
					cid2=cell.toString();
					pro.setCid2(cid2);
				}else{
					pro.setCid2("");
				}
				cell=row.getCell((short)6);
				if(cell!=null)
				{
					cp2=cell.toString();
					pro.setCp2(cp2);
				}else{
					pro.setCp2("");
				}
				cell=row.getCell((short)7);
				if(cell!=null)
				{
					cid3=cell.toString();
					pro.setCid3(cid3);
				}else{
					pro.setCid3("");
				}
				cell=row.getCell((short)8);
				if(cell!=null)
				{
					cp3=cell.toString();
					pro.setCp3(cp3);
				}else{
					pro.setCp3("");
				}
				cell=row.getCell((short)9);
				if(cell!=null)
				{
					cid4=cell.toString();
					pro.setCid4(cid4);
				}else{
					pro.setCid4("");
				}
				cell=row.getCell((short)10);
				if(cell!=null)
				{
					cp4=cell.toString();
					pro.setCp4(cp4);
				}else{
					pro.setCp4("");
				}
				cell=row.getCell((short)11);
				ps=conn.prepareStatement("insert into program values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,pro.getId());
				ps.setString(2,pro.getDept());
				ps.setString(3,pro.getTerm());
				ps.setString(4,pro.getCid1());
				ps.setString(5,pro.getCp1());
				ps.setString(6,pro.getCid2());
				ps.setString(7,pro.getCp2());
				ps.setString(8,pro.getCid3());
				ps.setString(9,pro.getCp3());
				ps.setString(10,pro.getCid4());
				ps.setString(11,pro.getCp4());

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
//通过cid1获取cplace1---还需要dept,term
	public String selectProgramByDTC1(String dept,String term,String cid1){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where dept=? and term=? and cid1=?");
			ps.setString(1,dept);
			ps.setString(2,term);
			ps.setString(3,cid1);
			rs=ps.executeQuery();
			if(rs.next()){
				String p ;
				p=rs.getString("cp1");
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//通过cid2获取cplace2---还需要dept,term
	public String selectProgramByDTC2(String dept,String term,String cid2){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where dept=? and term=? and cid2=?");
			ps.setString(1,dept);
			ps.setString(2,term);
			ps.setString(3,cid2);
			rs=ps.executeQuery();
			if(rs.next()){
				String p ;
				p=rs.getString("cp2");
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//通过cid3获取cplace3---还需要dept,term
	public String selectProgramByDTC3(String dept,String term,String cid3){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where dept=? and term=? and cid3=?");
			ps.setString(1,dept);
			ps.setString(2,term);
			ps.setString(3,cid3);
			rs=ps.executeQuery();
			if(rs.next()){
				String p ;
				p=rs.getString("cp3");
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
//通过cid4获取cplace4---还需要dept,term
	public String selectProgramByDTC4(String dept,String term,String cid4){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//try用来捕获异常
			ps=conn.prepareStatement("select * from program where dept=? and term=? and cid4=?");
			ps.setString(1,dept);
			ps.setString(2,term);
			ps.setString(3,cid4);
			rs=ps.executeQuery();
			if(rs.next()){
				String p ;
				p=rs.getString("cp4");
				return p;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
	}
}
