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
			//��ȡproperties�е��ļ�
			InputStream inputstream =JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//��ȡ���е�����
			properties.load(inputstream);
			//����������
			datasource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
		
		}
	}
	/**
	 * ��ȡ����
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
	 * �ر�����
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
