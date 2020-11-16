package power.work.dao;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import power.work.utils.JDBCUtils;
import com.alibaba.druid.util.JdbcUtils;

public abstract class BaseDao {
    // 用Dbutils操作数据库
    private QueryRunner queryrunner = new QueryRunner();// (queryrunner不懂是干什么的，jdbcutils也不知道)

    /**
     * 执行insert，delete，update语句
     */
    public int update(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnectionOne();
        try {
            return queryrunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }
    /**
     * 查询返回一个javabean的查询语句 type 返回类型的泛型 sql sql语句 conn 获取的连接 args sql对应的参数
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JDBCUtils.getConnectionOne();
        try {
            return queryrunner.query(connection, sql, new BeanHandler<T>(type), args);// BeanHandler不知道什么意思
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean的对象查询语句 type 返回类型的泛型 sql sql语句 conn 获取的连接 args sql对应的参数
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JDBCUtils.getConnectionOne();
        try {
            return queryrunner.query(connection, sql, new BeanListHandler<T>(type), args);// BeanHandler不知道什么意思
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }
    /**
     * 查询返回一行或一列的查询结果
     */
    public Object querySingleValues(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnectionOne();
        try {
            return queryrunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
