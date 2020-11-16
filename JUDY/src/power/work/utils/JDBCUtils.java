package power.work.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
public class JDBCUtils {
    private static DruidDataSource datasource;
    private static final String URL_STRING ="jdbc:mysql://localhost:3306/hoteljudy?useSSL=false";
    private static final String USERNAME_STRING ="root";
    private static final String PASSWORD_STRING="123456";
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
     * 获取链接第一种方式
     *
     */
    public static Connection getConnectionOne(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL_STRING,USERNAME_STRING,PASSWORD_STRING);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties pro = new Properties();
//        Connection conn = null;
//        try {
//            pro.load(is);
//            String user = pro.getProperty("username");
//            String password = pro.getProperty("password");
//            String driverClass = pro.getProperty("driverClassName");
//            String url = pro.getProperty("url");
//            //加载驱动
//            Class.forName(driverClass);
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
    };
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
