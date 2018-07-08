package beans;

import DTO.ClienteDTO;
import DTO.ProdutoPedidoDTO;
import java.util.List;
import javax.ejb.Remote;
/**
 * @author joaomarcos
 */

@Remote
public interface RegistraCompraBeanRemote {
    public boolean registraCompra(ClienteDTO cliente, List<ProdutoPedidoDTO> produtos);
}
