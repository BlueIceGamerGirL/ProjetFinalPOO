package org.example.projetpoo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;

public class AjouterProfesseurController {

    @FXML private TextField champNom;
    @FXML private TextField champPrenom;
    @FXML private TextField champId;
    @FXML private TextField champSalaire;

    private HelloController parentController;

    public void setParentController(HelloController controller) {
        this.parentController = controller;
    }

    @FXML
    private void ajouter() {
        String nom = champNom.getText().trim();
        String prenom = champPrenom.getText().trim();
        String id = champId.getText().trim();
        String salaireTexte = champSalaire.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || id.isEmpty() || salaireTexte.isEmpty()) {
            return;
        }

        double salaire = Double.parseDouble(salaireTexte);
        Professeur prof = new Professeur(nom, prenom, id, salaire);

        List<Professeur> profs = Json.chargerProfesseurs();
        profs.add(prof);
        Json.sauvegarderProfesseurs(profs);

        if (parentController != null) {
            parentController.rafraichirProfesseurs();
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