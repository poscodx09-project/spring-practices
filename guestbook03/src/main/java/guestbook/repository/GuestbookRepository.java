package guestbook.repository;

import guestbook.repository.template.JdbcContext;
import guestbook.repository.template.StatementStrategy;
import guestbook.vo.GuestbookVo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestbookRepository {
	private DataSource dataSource;
	private JdbcContext jdbcContext;

	public GuestbookRepository(DataSource dataSource,JdbcContext jdbcContext){
		this.dataSource = dataSource;
		this.jdbcContext = jdbcContext;
	}



	public List<GuestbookVo> findAll() {
		return jdbcContext.queryForList(
				"select id, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc",
				new RowMapper<GuestbookVo>(){
					@Override
					public GuestbookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						Long id = rs.getLong(1);
						String name = rs.getString(2);
						String contents = rs.getString(3);
						String regDate = rs.getString(4);

						GuestbookVo vo = new GuestbookVo();
						vo.setId(id);
						vo.setName(name);
						vo.setContents(contents);
						vo.setRegDate(regDate);

						return vo;
					}
				});
	}

	public int insert(GuestbookVo vo){
		return jdbcContext.executeUpdate(
				"insert into guestbook values(null, ?, ?, ?, now())",
				new Object[]{vo.getName(),vo.getPassword(),vo.getContents()});
	}

	public int deleteByIdAndPassword(Long id, String password){
		return jdbcContext.executeUpdate(
				"delete from guestbook where id=? and password=?",
				new Object[]{id,password});
	}

//	public int deleteByIdAndPassword(Long id, String password) {
//		int count = 0;
//
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement("delete from guestbook where id=? and password=?");
//		) {
//			pstmt.setLong(1, id);
//			pstmt.setString(2, password);
//
//			count = pstmt.executeUpdate();
//			System.out.println("쿼리 결과 " +  count);
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		}
//
//		return count;
//	}

	//	public int insert(GuestbookVo vo) {
//		int count = 0;
//
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement("insert into guestbook values(null, ?, ?, ?, now())");
//		) {
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getPassword());
//			pstmt.setString(3, vo.getContents());
//
//			count = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		}
//
//		return count;
//	}

	//	private Connection getConnection() throws SQLException{
//		Connection conn = null;
//
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//
//			String url = "jdbc:mariadb://192.168.0.5:3306/webdb";
//			conn = DriverManager.getConnection(url, "webdb", "webdb");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패:" + e);
//		}
//
//		return conn;
//	}

//	public List<GuestbookVo> findAll() {
//		List<GuestbookVo> result = new ArrayList<>();
//
//		try (
//				Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement("select id, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc");
//				ResultSet rs = pstmt.executeQuery();
//		) {
//			while(rs.next()) {
//				Long id = rs.getLong(1);
//				String name = rs.getString(2);
//				String contents = rs.getString(3);
//				String regDate = rs.getString(4);
//
//				GuestbookVo vo = new GuestbookVo();
//				vo.setId(id);
//				vo.setName(name);
//				vo.setContents(contents);
//				vo.setRegDate(regDate);
//
//				result.add(vo);
//			}
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		}
//
//		return result;
//	}
}
