package rest;

/**
 *
 * @author cassioseffrin
 */
import java.sql.Connection;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import model.clinica.Cliente;
import model.dao.ClienteDAO;
import model.database.DatabaseMySQL;

@Path("/")
public class APIRest {

    public ClienteDAO getClienteDAO() {
        ClienteDAO cliDao = new ClienteDAO();
        return cliDao;
    }

    @GET
    @Path("/getClientes")
    @Produces("application/json")
    public List<Cliente> getClientes() {
        List<Cliente> lst = getClienteDAO().listar();
        return lst;
    }

    @GET
    @Path("/findCliente")
    @Produces("application/json")
    public Cliente getCliente(@QueryParam("codigo") int codigo) {
        System.out.println("codigo " + codigo);
        return getClienteDAO().buscar(codigo);
    }

    @POST
    @Consumes("application/json")
    public Response setFoo(Cliente foo) {
        //salvar o cliente
        return Response.ok().entity("Gravado!").build();
    }

}
