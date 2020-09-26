package org.bigjava.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
public class JDBCutils {
	private static DruidDataSource datasource;
	static {
		try {
			Properties properties = new Properties();
			//读取properties中的文件
			InputStream inputstream =JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//读取流中的数据
			properties.load(inputstream);
			//加载数据流
			datasource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
		
		}
	}
	/**
	 * 获取连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = datasource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 */
	public static void close(Connection conn) {
		if(conn !=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
