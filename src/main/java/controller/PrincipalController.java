/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.clinica.Cliente;
import model.dao.ClienteDAO;
import model.database.DatabaseMySQL;

/**
 * FXML Controller class
 *
 * @author cassioseffrin
 */
public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPanePrincipal;

    @FXML
    private MenuItem menuCliente;

    @FXML
    private TableView tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaCpf;
    private ObservableList<Cliente> observableListClientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            telaInicial();
        } catch (IOException ex) {

        }
    }

    @FXML
    public void handlerMenuCliente(ActionEvent e) throws IOException {
        System.out.println("impmentar cadastro de cliente");
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Clientes.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    public void telaInicial() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/TelaInicial.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    public void gridClientes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/gridClientes.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
     //   carregarTableViewCliente();

    }

    public void carregarTableViewCliente() {
        DatabaseMySQL db = new DatabaseMySQL();
        Connection con = db.conectar();

        ClienteDAO cliDao = new ClienteDAO();
        cliDao.setConnection((com.mysql.jdbc.Connection) con);
        List<Cliente> lst = cliDao.listar();

        System.out.println("lst: " + lst.size());

        //   colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        //  colunaCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
        //  colunaNome.setCellValueFactory(cellData -> cellData.getValue().colunaNomeProperty());
        //   System.out.println("colunas"+colunaNome.getColumns());
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

        //  observableListClientes = FXCollections.observableArrayList(lst);
        //  tableViewClientes.setItems(observableListClientes);
    }

}
