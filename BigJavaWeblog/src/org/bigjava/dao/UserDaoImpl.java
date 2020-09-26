package org.bigjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp.PoolablePreparedStatement;
import org.bigjava.bean.User;
import org.bigjava.utils.JDBCutils;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User queryUserName(String username) {
		String sql = "select * from t_user where username=?";
		return queryForOne(User.class,sql,username);
	}

	@Override
	public int saveUser(User user) {
		String sql = "insert into t_user(`username`,`password`,`mail`)values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getMail());
	}
	@Override
	public User queryUsernameAndPassword(String username, String password) {
		String sql = "select `id`,`username`,`password`,`mail` from t_user where binary username=? And password=?";
		return queryForOne(User.class,sql,username,password);
	}

	@Override
	public List<String> selectLike(String username) {
		Connection conn = JDBCutils.getConnection();
		String sql="select distinct(username) from t_user where username like ? order by username asc";
		List<String> wordStrings = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username + '%');
			ResultSet rSet = pstmt.executeQuery();
			
			wordStrings = new ArrayList<String>();
			while (rSet.next()) {
				wordStrings.add(rSet.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wordStrings;

	}

}
