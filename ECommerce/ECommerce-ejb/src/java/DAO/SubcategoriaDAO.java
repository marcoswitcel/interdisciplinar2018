package DAO;

import DTO.SubcategoriaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectionUtil;

/**
 *
 * @author joaomarcos
 */
public class SubcategoriaDAO {
    private Connection connection;
    
    public SubcategoriaDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public SubcategoriaDTO findById(int csubcategoria) throws Exception {
        SubcategoriaDTO subcategoria = null;

        PreparedStatement ps = connection.prepareStatement(
            "SELECT * FROM SUBCATEGORIA WHERE csubcategoria = ?"
        );
        ps.setInt(1, csubcategoria);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            subcategoria = new SubcategoriaDTO();
            // @TODO Termine de implementar
        }
        
        rs.close();
        
        return subcategoria;
    }
}
