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

    @GET
    @Path("/getClientes")
    @Produces("application/json")
    public  Cliente  getClientes() {

        DatabaseMySQL db = new DatabaseMySQL();
        Connection con = db.conectar();
        ClienteDAO aniDao = new ClienteDAO();
        aniDao.setConnection((com.mysql.jdbc.Connection) con);
        List<Cliente> lst = aniDao.listar();
        
        System.out.println("tamanho lista:::: " + lst.size());
        return lst.get(1);
    }

}
