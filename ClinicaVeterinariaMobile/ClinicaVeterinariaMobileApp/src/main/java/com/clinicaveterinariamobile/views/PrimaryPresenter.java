package com.clinicaveterinariamobile.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.clinicaveterinariamobile.ClinicaVeterinariaMobile;
import com.gluonhq.connect.GluonObservableObject;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.RestClient;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.clinica.Cliente;

public class PrimaryPresenter {

    @FXML
    private View primary;

    @FXML
    private Label label;
    
 

    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e
                        -> MobileApplication.getInstance().showLayer(ClinicaVeterinariaMobile.MENU_LAYER)));
                appBar.setTitleText("Primary");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e
                        -> System.out.println("Search")));
            }

 

        });

    }

   

    @FXML
    void buttonClick() {

        RestClient restClient = RestClient.create()
                .host("http://localhost:8080")
                .path("clinica/rest/findCliente?codigo=29")
                .method("GET");
        
        GluonObservableObject<Cliente> gluonCli = DataProvider.retrieveObject(
                restClient.createObjectDataReader(Cliente.class
                ));
        
        
        gluonCli.initializedProperty().addListener((cliente, ov, nv) -> {
            if (nv) {

                System.out.println("Cliente " + gluonCli.getValue());
                label.setText("Cliente: " + gluonCli.getValue().getNome());
            }
        });
        
        
    }

}

//GluonObservableList<Cliente> sample =  DataProvider.retrieveList(get.createListDataReader(Cliente.class));
        // label.setText("Cliente 1 do REST: " +sample.getValue());
