package com.clinicaveterinariamobile.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.clinicaveterinariamobile.ClinicaVeterinariaMobile;

import com.gluonhq.charm.glisten.control.CharmListView;

import com.gluonhq.connect.GluonObservableList;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.RestClient;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.clinica.Cliente;

public class SecondaryPresenter {

    @FXML
    private View secondary;

    @FXML
   // CharmListView<String, Integer> charmListView;
    CharmListView<Cliente, Integer> charmListView;

    public void initialize() {

        secondary.setShowTransitionFactory(BounceInRightTransition::new);

        secondary.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info")).getLayer());

        secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e
                        -> MobileApplication.getInstance().showLayer(ClinicaVeterinariaMobile.MENU_LAYER)));
                appBar.setTitleText("Clientes");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e
                        -> System.out.println("Favorite")));
            }

        });
        populaList();

    }

    public void populaList() {
        RestClient restClient = RestClient.create()
                .host("http://localhost:8080")
                .path("clinica/rest/getClientes")
                .method("GET");
        GluonObservableList<Cliente> clientes = DataProvider.retrieveList(
                restClient.createListDataReader(Cliente.class));

        charmListView.setItems(clientes);
        
        
       // ObservableList<String> conteudo = FXCollections.observableArrayList("Cassio", "Fabio", "Catia");

       // charmListView.setItems(conteudo);


    }
}
