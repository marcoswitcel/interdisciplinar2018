package DAO;

import DTO.PedidoDTO;
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
    
    public int save(PedidoDTO pedido) {
        int cpedido = 0;
       
        // @TODO insere pedido
       
        return cpedido;
        
    }
}
