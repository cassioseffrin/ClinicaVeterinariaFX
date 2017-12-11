package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, Integer> colunaId;
    @FXML
    private TableColumn<Cliente, Long> colunaCpf;
    @FXML
    private TableColumn<Cliente, String> colunaEndereco;

    private ObservableList<Cliente> observableListClientes;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtTelefone;

    private Integer clienteIdSel;

    @FXML
    private ComboBox comboSexo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        popularTableViewCliente();

        comboSexo.getItems().clear();
        comboSexo.getItems().addAll(
                "Masculino",
                "Feminino",
                "Homo Afetivo",
                "Indefinido",
                "Bi");
        comboSexo.setEditable(true);
        comboSexo.setOnAction((Event ev) -> {
            String sel = comboSexo.getSelectionModel().getSelectedItem().toString();
            System.out.println("sel: " + sel);
        });

        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTabela(newValue));

    }

    public void popularTableViewCliente() {

        ClienteDAO cliDao = new ClienteDAO();

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

    @FXML

    public void handlerRemoverCliente() throws IOException {

        if (clienteIdSel != null) {
            ClienteDAO cliDao = new ClienteDAO();
            cliDao.remover(clienteIdSel);

            popularTableViewCliente();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha ao selecioanar cliente");
        }

    }

    private void selecionarItemTabela(Cliente cli) {

        if (cli != null) {
            clienteIdSel = cli.getId();
            Cliente clidb = getClienteDb(cli.getId());
            txtNome.setText(clidb.getNome());
            txtEndereco.setText(clidb.getEndereco());
            txtTelefone.setText(clidb.getTelefone());

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha ao selecioanar cliente");
        }

    }

    private Cliente getClienteDb(int id) {

   
        ClienteDAO cliDao = new ClienteDAO();
     

        return cliDao.buscar(id);

    }

}
