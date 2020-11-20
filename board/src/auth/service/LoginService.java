package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class LoginService {
	
	private UserDao userDao = new UserDao();
	
	public AuthUser login(String id, String password) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			User user = userDao.selectById(conn, id);
			if(user == null) {
				throw new LoginFailException();
			}
			if(!user.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new AuthUser(user.getId(), user.getName());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
