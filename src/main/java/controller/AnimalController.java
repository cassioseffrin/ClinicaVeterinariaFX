package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.clinica.Animal;
import model.clinica.Cliente;
import model.dao.AnimalDAO;
import model.dao.ClienteDAO;
import model.database.DatabaseMySQL;

/**
 * FXML Controller class
 *
 * @author cassioseffrin
 */
public class AnimalController implements Initializable {

    @FXML
    private AnchorPane anchorPaneAnimal;

    @FXML
    private TableView<Animal> tableViewAnimal;

    @FXML
    private TableColumn<Animal, String> colunaNome;
    @FXML
    private TableColumn<Cliente, Integer> colunaId;

    private ObservableList<Animal> observableListAnimal;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtCor;
    @FXML
    private TextField txtPeso;

    private Integer clienteIdSel;

    private Integer idAnimalSelecionado;
    private Animal animalSelecionado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        popularTableViewAnimal();

        tableViewAnimal.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTabela(newValue));

    }

    public void popularTableViewAnimal() {

        AnimalDAO aniDao = new AnimalDAO();

        List<Animal> lst = aniDao.listar();
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        observableListAnimal = FXCollections.observableArrayList(lst);
        tableViewAnimal.setItems(observableListAnimal);
    }

    private void selecionarItemTabela(Animal animal) {

        idAnimalSelecionado = animal.getId();
        animalSelecionado = animal;

        txtId.setText(String.valueOf(animal.getId()));
        txtNome.setText(animal.getNome());
        txtCor.setText(animal.getCor());

        System.out.println("animal da tabela: " + animal.getNome());

    }

    @FXML

    public void handlerRemoverAnimal() throws IOException {

        if (idAnimalSelecionado != null) {
            AnimalDAO aniDao = new AnimalDAO();
            aniDao.remover(idAnimalSelecionado);
            popularTableViewAnimal();

        }
    }

    @FXML
    public void handlerAtualizarAnimal() throws IOException {

        if (idAnimalSelecionado != null) {
            AnimalDAO aniDao = new AnimalDAO();
            Animal animalAtualizar = new Animal();
            animalAtualizar.setId(idAnimalSelecionado);
            animalAtualizar.setNome(txtNome.getText());
            animalAtualizar.setPeso(Integer.parseInt(txtPeso.getText()));
            animalAtualizar.setCor(txtCor.getText());

            aniDao.atualizar(animalAtualizar);
            popularTableViewAnimal();

        }
    }
}
