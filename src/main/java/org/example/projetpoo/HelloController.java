package org.example.projetpoo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class HelloController {

    @FXML private TableView<Professeur> tableProfesseurs;
    @FXML private TableColumn<Professeur, String> colProfNom;
    @FXML private TableColumn<Professeur, String> colProfPrenom;
    @FXML private TableColumn<Professeur, String> colProfId;
    @FXML private TableColumn<Professeur, Double> colProfSalaire;

    @FXML
    public void initialize() {
        colProfNom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        colProfPrenom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrenom()));
        colProfId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdentifiant()));
        colProfSalaire.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getSalaire()).asObject());

        List<Professeur> profs = Json.chargerProfesseurs();
        tableProfesseurs.getItems().addAll(profs);
    }

    @FXML
    private void ajouterProfesseur() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterProfesseur.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Ajouter un professeur");
            popup.setScene(new Scene(loader.load(), 400, 420));
            popup.initModality(Modality.WINDOW_MODAL);

            AjouterProfesseurController ctrl = loader.getController();
            ctrl.setParentController(this);

            popup.showAndWait();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void rafraichirProfesseurs() {
        tableProfesseurs.getItems().clear();
        List<Professeur> profs = Json.chargerProfesseurs();
        tableProfesseurs.getItems().addAll(profs);
    }
}