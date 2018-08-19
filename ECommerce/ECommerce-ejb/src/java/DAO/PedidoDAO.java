package DAO;

import DTO.PedidoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
    
    public int save(PedidoDTO pedido) throws Exception {
        int cpedido = 0;
       
        PreparedStatement ps = connection.prepareStatement(
            "EXECUTE PROCEDURE ID_NOVO_PEDIDO(?, ?)"
        );
        ps.setString(1, pedido.getCpf().getCpf());
        ps.setTimestamp(
            2,
            new Timestamp(pedido.getData().getTime())
        );
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            cpedido = rs.getInt("CPEDIDO");
        }
        
        rs.close();
        ps.close();
       
        return cpedido;
        
    }
}
