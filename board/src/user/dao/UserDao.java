package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import user.model.User;

public class UserDao {

	public User selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from user where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User(
						rs.getString("userid"),
						rs.getString("name"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate")));
			}
			return user;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, User user) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into user values(?, ?, ? ,?)")) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setTimestamp(4, new Timestamp(user.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, User user) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("update user set name = ?, password = ? where userid = ?")) {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getId());
			pstmt.executeUpdate();
		} 
	}
	
}
