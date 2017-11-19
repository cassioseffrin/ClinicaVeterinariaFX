package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.clinica.Cliente;
import model.dao.ClienteDAO;
import model.database.DatabaseMySQL;

/**
 * FXML Controller class
 *
 * @author cassioseffrin
 */
public class GridClientesController implements Initializable {

    @FXML
    private AnchorPane anchorPaneGrid;

    @FXML
    private TableView tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, Integer> colunaId;
    @FXML
    private TableColumn<Cliente, Long> colunaCpf;
    @FXML
    private TableColumn<Cliente, String> colunaEndereco;

    private ObservableList<Cliente> observableListClientes;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        popularTableViewCliente();
    }

    public void popularTableViewCliente() {
        DatabaseMySQL db = new DatabaseMySQL();
        Connection con = db.conectar();
        ClienteDAO cliDao = new ClienteDAO();
        cliDao.setConnection((com.mysql.jdbc.Connection) con);
        List<Cliente> lst = cliDao.listar();
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        observableListClientes = FXCollections.observableArrayList(lst);
        tableViewClientes.setItems(observableListClientes);
    }

    @FXML
    public void handlerTelaInicial(ActionEvent e) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/TelaInicial.fxml"));
        anchorPaneGrid.getChildren().setAll(a);
    }

}
