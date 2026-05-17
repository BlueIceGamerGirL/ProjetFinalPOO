package org.example.projetpoo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.List;

public class AjouterProjetController {

    @FXML private TextField champNom;
    @FXML private TextField champId;
    @FXML private TextArea champDescription;
    @FXML private TextField champEleve;

    private HelloController parentController;

    public void setParentController(HelloController controller) {
        this.parentController = controller;
    }

    @FXML
    private void ajouter() {
        String nom = champNom.getText().trim();
        String id = champId.getText().trim();
        String description = champDescription.getText().trim();
        String eleve = champEleve.getText().trim();

        if (nom.isEmpty() || id.isEmpty() || description.isEmpty() || eleve.isEmpty()) {
            return;
        }

        Projet projet = new Projet(nom, id, description, eleve);

        List<Projet> projets = Json.chargerProjets();
        projets.add(projet);
        Json.sauvegarderProjets(projets);

        if (parentController != null) {
            parentController.rafraichirProjets();
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