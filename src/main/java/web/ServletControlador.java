package web;

import datos.ClienteDAO;
import datos.ClienteDAOMySQL;
import dominio.ClienteDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author John
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @SuppressWarnings("FieldMayBeFinal")
    private static ClienteDAO db;

    static {
        db = new ClienteDAOMySQL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "INVALID";
        }

        switch (accion) {
            case "editar": {
                editarCliente(request, response);
                break;
            }
            case "eliminar": {
                eliminarCliente(request, response);
            }
            default: {
                listarClientes(request, response);
                response.sendRedirect("clientes.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "INVALID";
        }

        switch (accion) {
            case "insertar": {
                insertarCliente(request, response);
            }
            case "modificar": {
                actualizarCliente(request, response);
            }
            default: {
                response.sendRedirect("index.jsp");
            }
        }
    }

    // Private methods
    private double saldoTotal(List<ClienteDTO> clientes) {
        double saldoTotal = 0;
        for (ClienteDTO cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            ClienteDTO cliente = db.encontrar(new ClienteDTO(idCliente));
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("WEB-INF/paginas/cliente/editarCliente.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private ClienteDTO getCliente(HttpServletRequest request) {
        String idClienteString = request.getParameter("idCliente");
        int idCliente = idClienteString != null ? Integer.parseInt(idClienteString) : 0;
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String saldoString = request.getParameter("saldo");
        double saldo = saldoString != null ? Double.parseDouble(saldoString) : 0;

        return new ClienteDTO(idCliente, nombre, apellido, email, telefono, saldo);
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            List<ClienteDTO> clientes = db.listar();
            System.out.println("Clientes: " + clientes);
            session.setAttribute("clientes", clientes);
            session.setAttribute("totalClientes", clientes.size());
            session.setAttribute("saldoTotal", saldoTotal(clientes));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) {
        ClienteDTO cliente = getCliente(request);
        try {
            db.insertar(cliente);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response) {
        ClienteDTO cliente = getCliente(request);
        try {
            db.actualizar(cliente);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
        ClienteDTO cliente = getCliente(request);
        try {
            db.eliminar(cliente);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
