package DAO;

import java.sql.Connection;
import model.Pedido;
import util.ConnectionUtil;
/**
 * @author joaomarcos
 */

public class PedidoDAO {
    private Connection connection;
    
    public PedidoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public void save(Pedido pedido) {
        // @TODO insere pedido
    }
}
