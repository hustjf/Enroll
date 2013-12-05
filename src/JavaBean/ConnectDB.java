package JavaBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13-10-21
 * Time: 下午9:57
 * To change this template use File | Settings | File Templates.
 */
public class ConnectDB {
    private Context ctx;
    private Connection conn;
    public ConnectDB(){
        try {
            this.ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/connectionpool");
            this.conn = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
