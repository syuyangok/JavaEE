package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//jdbc utils class, for druid
public class JDBCUtils {

    private static DataSource ds;

    //initize
    static {
        // add properites file
        Properties pro = new Properties();
        ClassLoader cls = JDBCUtils.class.getClassLoader();
        InputStream is = cls.getResourceAsStream("druid.properties");

        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creae datapool
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static DataSource getDatasource(){

        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
