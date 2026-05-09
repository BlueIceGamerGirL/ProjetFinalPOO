package org.example.projetpoo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;

public class AjouterEtudiantController {

    @FXML private TextField champNom;
    @FXML private TextField champPrenom;
    @FXML private TextField champId;
    @FXML private TextField champCoteR;

    private HelloController parentController;

    public void setParentController(HelloController controller) {
        this.parentController = controller;
    }

    @FXML
    private void ajouter() {
        String nom = champNom.getText().trim();
        String prenom = champPrenom.getText().trim();
        String id = champId.getText().trim();
        String coteRTexte = champCoteR.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || id.isEmpty() || coteRTexte.isEmpty()) {
            return;
        }

        double coteR = Double.parseDouble(coteRTexte);
        Etudiant etudiant = new Etudiant(nom, prenom, id, coteR);

        List<Etudiant> etudiants = Json.chargerEtudiants();
        etudiants.add(etudiant);
        Json.sauvegarderEtudiants(etudiants);

        if (parentController != null) {
            parentController.rafraichirEtudiants();
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