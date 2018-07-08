package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import util.ConnectionUtil;

/**
 * @author joaomarcos
 */
public class ClienteDAO {
    
    private Connection connection;
    
    public ClienteDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public void save(ClienteDTO cliente) {
        // @TODO implementar
    }
    
    public void update(ClienteDTO cliente) {
        // @TODO implementar
    }
    
    public ClienteDTO findById(int cpf) {
        ClienteDTO cliente = null;
        
        // @TODO lógica 
        
        return cliente; 
    }
}
