package DAO;

import DTO.ProdutoPedidoDTO;
import java.sql.Connection;
import util.ConnectionUtil;

/**
 *
 * @author joaomarcos
 */
public class ProdutoPedidoDAO {
    private Connection connection;
    
    public ProdutoPedidoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public void save(ProdutoPedidoDTO produtoPedido) {
        // @TODO implementar
    }
}
