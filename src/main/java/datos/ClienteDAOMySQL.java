package datos;

import dominio.ClienteDTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author John
 */
public class ClienteDAOMySQL implements ClienteDAO {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM CLIENTE";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + "FROM CLIENTE WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO CLIENTE(nombre, apellido, email, telefono, saldo)"
            + "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE CLIENTE SET nombre=?, apellido=?, email=?, telefono=?, saldo=? "
            + "WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM CLIENTE WHERE id_cliente = ?";
    
    @Override
    public List<ClienteDTO> listar() throws SQLException {
        Connection conn = Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = stmt.executeQuery();

        List<ClienteDTO> clientes = new LinkedList<>();
        int idCliente;
        String nombre;
        String apellido;
        String email;
        String telefono;
        double saldo;

        while (rs.next()) {
            idCliente = rs.getInt("id_cliente");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            email = rs.getString("email");
            telefono = rs.getString("telefono");
            saldo = rs.getDouble("saldo");

            clientes.add(new ClienteDTO(idCliente, nombre, apellido, email, telefono, saldo));
        }

        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);

        return clientes;
    }

    @Override
    public ClienteDTO encontrar(ClienteDTO cliente) throws SQLException {
        Connection conn = Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
        stmt.setInt(1, cliente.getIdCliente());
        ResultSet rs = stmt.executeQuery();
        rs.absolute(1); // Nos posicionamos en el primer registro devuelto.

        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String email = rs.getString("email");
        String telefono = rs.getString("telefono");
        double saldo = rs.getDouble("saldo");

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setSaldo(saldo);

        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);

        return cliente;
    }

    @Override
    public int insertar(ClienteDTO cliente) throws SQLException {
        Connection conn = Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getTelefono());
        stmt.setDouble(5, cliente.getSaldo());

        int rows = stmt.executeUpdate();

        Conexion.close(stmt);
        Conexion.close(conn);

        return rows;
    }

    @Override
    public int actualizar(ClienteDTO cliente) throws SQLException {
        Connection conn = Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);

        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getTelefono());
        stmt.setDouble(5, cliente.getSaldo());
        stmt.setInt(6, cliente.getIdCliente());

        int rows = stmt.executeUpdate();

        Conexion.close(stmt);
        Conexion.close(conn);

        return rows;
    }
    
    @Override
    public int eliminar(ClienteDTO cliente) throws SQLException {
        Connection conn = Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);

        stmt.setInt(1, cliente.getIdCliente());

        int rows = stmt.executeUpdate();

        Conexion.close(stmt);
        Conexion.close(conn);

        return rows;
    }
}
