package util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author joaomarcos
 */

public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        InitialContext ctx;
        Connection con = null;
        
        try {
            ctx = new InitialContext();
            // @TODO configurar pool
            DataSource ds = (DataSource) ctx.lookup("jdbc/bestcard-poll");
            con = ds.getConnection();
        } catch(NamingException | SQLException ex) {
            throw new Exception("Erro de conexão ao banco de dados! Verifique o log do aplicativo.", ex);
        }
        return con;
    }
}
