package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConnectionUtil;

/**
 * @author joaomarcos
 */
public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }

    public void save(ClienteDTO cliente) throws Exception {
        // Como o CPF é a primarykey do cliente, ele sempre deve
        // ser inserido
        PreparedStatement ps = connection.prepareStatement(
            "INSERT INTO CLIENTE VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, cliente.getCpf());
        ps.setString(2, cliente.getCep());
        ps.setString(3, cliente.getRua());
        ps.setInt(4, cliente.getNumero());

        ps.execute();
    }

    public void update(ClienteDTO cliente) throws Exception {
        PreparedStatement ps = connection.prepareStatement(
            "UPDATE CLIENTE SET "
            + "CEP = ?, RUA = ?, NUMERO = ? "
            + "WHERE CPF = ?"
        );
        ps.setString(1, cliente.getCep());
        ps.setString(2, cliente.getRua());
        ps.setInt(3, cliente.getNumero());
        ps.setString(4, cliente.getCpf());

        ps.execute();
    }

    public ClienteDTO findById(int cpf) throws Exception {
        ClienteDTO cliente = null;

        PreparedStatement ps = connection.prepareStatement(
            "SELECT * FROM CLIENTE WHERE CPF = ?"
        );
        ps.setInt(1, cpf);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            cliente = new ClienteDTO();
            cliente.setCpf(rs.getString("CPF"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setRua(rs.getString("RUA"));
            cliente.setNumero(rs.getInt("NUMERO"));
        }
        
        rs.close();
        
        return cliente;
    }
}
