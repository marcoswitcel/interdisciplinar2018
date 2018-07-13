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
            "INSERT INTO PEDIDO VALUES (?, ?) returning "
        );
        ps.setString(1, pedido.getCpf().getCpf());
        ps.setTimestamp(
            2,
            new Timestamp(pedido.getData().getTime())
        );

        // @TODO descobrir como retornar o id de forma performática e segura
        //ResultSet rs = ps.executeQuery();
        //rs.close();
        
        ps.close();
       
        return cpedido;
        
    }
}
