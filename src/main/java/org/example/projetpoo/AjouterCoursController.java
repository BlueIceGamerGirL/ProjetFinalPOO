package org.example.projetpoo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.List;

public class AjouterCoursController {

    @FXML private TextField champNom;
    @FXML private TextField champCode;
    @FXML private TextArea champDescription;
    @FXML private ComboBox<String> dropdownProf;

    private HelloController parentController;

    public void setParentController(HelloController controller) {
        this.parentController = controller;
    }

    @FXML
    public void initialize() {
        List<Professeur> profs = Json.chargerProfesseurs();
        for (Professeur p : profs) {
            dropdownProf.getItems().add(p.getPrenom() + " " + p.getNom());
        }
    }

    @FXML
    private void ajouter() {
        String nom = champNom.getText().trim();
        String code = champCode.getText().trim();
        String description = champDescription.getText().trim();
        String prof = dropdownProf.getValue();

        if (nom.isEmpty() || code.isEmpty() || description.isEmpty() || prof == null) {
            return;
        }

        Cours cours = new Cours(nom, code, description, prof);

        List<Cours> listeCours = Json.chargerCours();
        listeCours.add(cours);
        Json.sauvegarderCours(listeCours);

        if (parentController != null) {
            parentController.rafraichirCours();
        }

        fermer();
    }

    @FXML
    private void annuler() {
        fermer();
    }

    private void fermer() {
        Stage stage = (Stage) champNom.getScene().getWindow();
        stage.close();
    }
}