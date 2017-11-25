
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


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
    private MenuItem menuAnimal;

 
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

    @FXML
    public void handlerMenuAnimais(ActionEvent e) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/Animais.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }
    
    public void telaInicial() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/TelaInicial.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    public void gridClientes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/gridClientes.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }
}
