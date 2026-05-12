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

    @FXML private TableView<Etudiant> tableEtudiants;
    @FXML private TableColumn<Etudiant, String> colEtudNom;
    @FXML private TableColumn<Etudiant, String> colEtudPrenom;
    @FXML private TableColumn<Etudiant, String> colEtudId;
    @FXML private TableColumn<Etudiant, Double> colEtudCoteR;

    @FXML private TableView<Cours> tableCours;
    @FXML private TableColumn<Cours, String> colCoursNom;
    @FXML private TableColumn<Cours, String> colCoursCode;
    @FXML private TableColumn<Cours, String> colCoursDesc;
    @FXML private TableColumn<Cours, String> colCoursProf;

    @FXML
    public void initialize() {
        // Professeurs
        colProfNom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        colProfPrenom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrenom()));
        colProfId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdentifiant()));
        colProfSalaire.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getSalaire()).asObject());
        tableProfesseurs.getItems().addAll(Json.chargerProfesseurs());

        // Étudiants
        colEtudNom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        colEtudPrenom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrenom()));
        colEtudId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdentifiant()));
        colEtudCoteR.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getCoteR()).asObject());
        tableEtudiants.getItems().addAll(Json.chargerEtudiants());

        // Cours
        colCoursNom.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNom()));
        colCoursCode.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCode()));
        colCoursDesc.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
        colCoursProf.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProfesseur()));
        tableCours.getItems().addAll(Json.chargerCours());
    }

    @FXML
    private void ajouterProfesseur() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterProfesseurs.fxml"));
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

    @FXML
    private void ajouterEtudiant() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEtudiant.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Ajouter un étudiant");
            popup.setScene(new Scene(loader.load(), 400, 420));
            popup.initModality(Modality.WINDOW_MODAL);
            AjouterEtudiantController ctrl = loader.getController();
            ctrl.setParentController(this);
            popup.showAndWait();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @FXML
    private void ajouterCours() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCours.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Ajouter un cours");
            popup.setScene(new Scene(loader.load(), 400, 480));
            popup.initModality(Modality.WINDOW_MODAL);
            AjouterCoursController ctrl = loader.getController();
            ctrl.setParentController(this);
            popup.showAndWait();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void rafraichirProfesseurs() {
        tableProfesseurs.getItems().clear();
        tableProfesseurs.getItems().addAll(Json.chargerProfesseurs());
    }

    public void rafraichirEtudiants() {
        tableEtudiants.getItems().clear();
        tableEtudiants.getItems().addAll(Json.chargerEtudiants());
    }

    public void rafraichirCours() {
        tableCours.getItems().clear();
        tableCours.getItems().addAll(Json.chargerCours());
    }
}