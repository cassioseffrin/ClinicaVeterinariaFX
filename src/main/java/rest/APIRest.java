package rest;

/**
 *
 * @author cassioseffrin
 */
import java.sql.Connection;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.clinica.Cliente;
import model.dao.ClienteDAO;
import model.database.DatabaseMySQL;

@Path("/")
public class APIRest {

    
    public ClienteDAO getClienteDAO (){
        DatabaseMySQL db = new DatabaseMySQL();
        Connection con = db.conectar();
        ClienteDAO cliDao = new ClienteDAO();
        cliDao.setConnection((com.mysql.jdbc.Connection) con);
        return cliDao;
    }
    
    @GET
    @Path("/getClientes")
    @Produces("application/json")
    public  List<Cliente>  getClientes() {
        List<Cliente> lst = getClienteDAO().listar();
        return lst;
    }
    
    
    @GET
    @Path("/findCliente")
    @Produces("application/json")
    public  Cliente  getCliente() {
        List<Cliente> lst = getClienteDAO().listar();
        return lst.get(0);
    }
    

}
