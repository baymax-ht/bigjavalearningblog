package org.bigjava.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.bigjava.utils.JDBCutils;

import com.alibaba.druid.util.JdbcUtils;

public abstract class BaseDao {
	// ��Dbutils�������ݿ�
	private QueryRunner queryrunner = new QueryRunner();// (queryrunner�����Ǹ�ʲô�ģ�jdbcutilsҲ��֪��)

	/**
	 * ִ��insert��delete��update���
	 */
	public int update(String sql, Object... args) {
		Connection connection = JDBCutils.getConnection();
		try {
			return queryrunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.close(connection);
		}
		return -1;
	}

	/**
	 * ��ѯ����һ��javabean�Ĳ�ѯ��� type �������͵ķ��� sql sql��� conn ��ȡ������ args sql��Ӧ�Ĳ���
	 */
	public <T> T queryForOne(Class<T> type, String sql, Object... args) {
		Connection conn = JDBCutils.getConnection();
		try {
			return queryrunner.query(conn, sql, new BeanHandler<T>(type), args);// BeanHandler��֪��ʲô��˼
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.close(conn);
		}
		return null;
	}

	/**
	 * ��ѯ���ض��JavaBean�Ķ����ѯ��� type �������͵ķ��� sql sql��� conn ��ȡ������ args sql��Ӧ�Ĳ���
	 */
	public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
		Connection con = JDBCutils.getConnection();
		try {
			return queryrunner.query(con, sql, new BeanListHandler<T>(type), args);// BeanHandler��֪��ʲô��˼
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutils.close(con);
		}
		return null;
	}
	/**
	 * ��ѯ����һ�л�һ�еĲ�ѯ���
	 */
	public Object querySingleValues(String sql, Object... args) {
		Connection conn = JDBCutils.getConnection();
		try {
			return queryrunner.query(conn,sql,new ScalarHandler(),args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutils.close(conn);
		}
		return null;
	}
}
