package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class ChangePasswordService {
	
	private UserDao userDao = new UserDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			User user = userDao.selectById(conn, userId);
			if(user == null) {
				throw new MemberNotFoundException();
			}
			if(!user.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			user.changePassword(newPwd);
			userDao.update(conn, user);
			conn.commit();
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
