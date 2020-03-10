package datos;

import dominio.ClienteDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author John
 */
public interface ClienteDAO {
    List<ClienteDTO> listar() throws SQLException;
    
    ClienteDTO encontrar(ClienteDTO cliente) throws SQLException;
    
    int insertar(ClienteDTO cliente) throws SQLException;

    int actualizar(ClienteDTO cliente) throws SQLException;
    
    int eliminar(ClienteDTO cliente) throws SQLException;
}
