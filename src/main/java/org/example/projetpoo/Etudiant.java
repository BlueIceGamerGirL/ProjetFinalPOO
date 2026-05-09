package org.example.projetpoo;

public class Etudiant {
    private String nom;
    private String prenom;
    private String identifiant;
    private double coteR;

    public Etudiant(String nom, String prenom, String identifiant, double coteR) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.coteR = coteR;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getIdentifiant() { return identifiant; }
    public double getCoteR() { return coteR; }
}