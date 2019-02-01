package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import dto.Course;
import dto.News;


public class NewsDao {
//增
	public int insertNews(News news){
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("insert into news (ntype,ntime,nauthor,ntitle,ncontent,nfile,nfake) values (?,?,?,?,?,?,?)");
			ps.setString(1, news.getNtype());
			ps.setString(2, news.getNtime());
			ps.setString(3, news.getNauthor());
			ps.setString(4, news.getNtitle());
			ps.setString(5, news.getNcontent());
			ps.setString(6, news.getNfile());
			ps.setString(7, news.getNfake());
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
//删
	public int deleteNews(String nid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from news where nid=?");
			ps.setString(1, nid);
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
//多项删除
	
//改
	public int updateNews(News news) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update news set ntype=?,ntitle=?,ncontent=?,nfile=?,nfake=? where nid=?");
			ps.setString(1,news.getNtype());
			ps.setString(2,news.getNtitle());
			ps.setString(3,news.getNcontent());
			ps.setString(4,news.getNfile());
			ps.setString(5,news.getNfake());
			ps.setString(6,news.getNid());
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
//查
	public ArrayList<News> selectAllNewses() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news order by ntime");
			rs = ps.executeQuery();
			ArrayList<News> news = new ArrayList<News>();
			while (rs.next()) {
			News n=new News();
			n.setNid(rs.getString("nid"));
			n.setNtype(rs.getString("ntype"));
			n.setNtime(rs.getString("ntime"));
			n.setNauthor(rs.getString("nauthor"));
			n.setNtitle(rs.getString("ntitle"));
			n.setNcontent(rs.getString("ncontent"));
			n.setNfile(rs.getString("nfile"));
			n.setNfake(rs.getString("nfake"));
			news.add(n);
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
		}
//分类显示新闻
	public ArrayList<News> selectNewsByType(News news) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where ntype=? order by ntime");
			ps.setString(1,news.getNtype());
			rs = ps.executeQuery();
			ArrayList<News> news1 = new ArrayList<News>();
			while (rs.next()) {
			News n=new News();
			n.setNid(rs.getString("nid"));
			n.setNtype(rs.getString("ntype"));
			n.setNtime(rs.getString("ntime"));
			n.setNauthor(rs.getString("nauthor"));
			n.setNtitle(rs.getString("ntitle"));
			n.setNcontent(rs.getString("ncontent"));
			n.setNfile(rs.getString("nfile"));
			n.setNfake(rs.getString("nfake"));
			news1.add(n);
			}
			return news1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
		}
//显示最新4条公告（分类）
	public ArrayList<News> selectNewsFour(News news) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where ntype=? order by ntime limit 0,4");
			ps.setString(1,news.getNtype());
			rs = ps.executeQuery();
			ArrayList<News> news1 = new ArrayList<News>();
			while (rs.next()) {
			News n=new News();
			n.setNid(rs.getString("nid"));
			n.setNtype(rs.getString("ntype"));
			n.setNtime(rs.getString("ntime"));
			n.setNauthor(rs.getString("nauthor"));
			n.setNtitle(rs.getString("ntitle"));
			n.setNcontent(rs.getString("ncontent"));
			n.setNfile(rs.getString("nfile"));
			n.setNfake(rs.getString("nfake"));
			news1.add(n);
			}
			return news1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
		}
//显示新闻内容
	public News selectNewsById(News news) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where nid=? order by ntime");
			ps.setString(1,news.getNid());
			rs = ps.executeQuery();
			if(rs.next()) {
			News n=new News();
			n.setNid(rs.getString("nid"));
			n.setNtype(rs.getString("ntype"));
			n.setNtime(rs.getString("ntime"));
			n.setNauthor(rs.getString("nauthor"));
			n.setNtitle(rs.getString("ntitle"));
			n.setNcontent(rs.getString("ncontent"));
			n.setNfile(rs.getString("nfile"));
			n.setNfake(rs.getString("nfake"));
			return n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}
		return null;
		}
//分页显示新闻
	public ArrayList<News> fenye(int dangqianPage){
		ArrayList<News> newsFY = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getString("nid"));
				n.setNtime(rs.getString("ntime"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNtype(rs.getString("ntype"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNfile(rs.getString("nfile"));
				n.setNfake(rs.getString("nfake"));
				newsFY.add(n);
			}return newsFY;
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
			ps = conn.prepareStatement("select * from news");
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
//按类别查询-分页
//模糊查找全部 分页
	public ArrayList<News> fenye1(int dangqianPage,String search){
		ArrayList<News> newsFY = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where concat (ntitle,ntype,"
					+ "ncontent,nfile) like '%"+search+"%' limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getString("nid"));
				n.setNtime(rs.getString("ntime"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNtype(rs.getString("ntype"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNfile(rs.getString("nfile"));
				n.setNfake(rs.getString("nfake"));
				newsFY.add(n);
			}return newsFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}	
//按类别查询-分页-总数据
	public int sumData1(String search) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where concat (ntitle,ntype,"
					+ "ncontent,nfile) like '%"+search+"%'");
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
//按类别查询-分页-总页数
	public int sumPageCount1(String search) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData1(search);
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
//上传文件
	
//按类别 分页
	public ArrayList<News> fenye2(int dangqianPage,String ntype){
		ArrayList<News> newsFY = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where ntype='"+ntype+"' limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getString("nid"));
				n.setNtime(rs.getString("ntime"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNtype(rs.getString("ntype"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNfile(rs.getString("nfile"));
				n.setNfake(rs.getString("nfake"));
				newsFY.add(n);
			}return newsFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
	public int sumData2(String ntype) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where ntype='"+ntype+"'");
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
	public int sumPageCount2(String ntype) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData2(ntype);
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
//按类别 模糊查找查询“全部” 分页
	public ArrayList<News> fenye3(int dangqianPage,String search,String ntype){
		ArrayList<News> newsFY = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where concat (ntitle,ncontent) and"
					+ " ntype='"+ntype+"' like '%"+search+"%' limit "+ 8*(dangqianPage-1)+","+8+"");
			rs = ps.executeQuery();
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getString("nid"));
				n.setNtime(rs.getString("ntime"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNtype(rs.getString("ntype"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNfile(rs.getString("nfile"));
				n.setNfake(rs.getString("nfake"));
				newsFY.add(n);
			}return newsFY;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.clearAll(conn, ps, rs);
		}		
		return null;		
	}
	public int sumData3(String search,String ntype) {
		int sumData=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from news where concat (ntitle,ncontent)"
					+ " and ntype='"+ntype+"' like '%"+search+"%'");
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
	public int sumPageCount3(String search,String ntype) {
		try {
			int sumPageCount=0;
			int sumPage=this.sumData3(search,ntype);
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
