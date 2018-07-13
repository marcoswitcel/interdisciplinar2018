package DAO;

import DTO.ProdutoPedidoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public void save(ProdutoPedidoDTO produtoPedido) throws Exception {
        PreparedStatement ps = connection.prepareStatement(
            "INSERT INTO PRODUTOPEDIDO VALUES (?, ?, ?, ?, ?)"
        );
        ps.setInt(1, produtoPedido.getCproduto().getCproduto());
        ps.setInt(2, produtoPedido.getCpedido().getCpedido());
        ps.setInt(3, produtoPedido.getQuantidade());
        ps.setDouble(4, produtoPedido.getPreco());
        ps.setDouble(5, produtoPedido.getDesconto());

        ps.execute();
    }
}
