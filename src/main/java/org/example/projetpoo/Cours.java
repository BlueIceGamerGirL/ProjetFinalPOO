package org.example.projetpoo;

public class Cours {
    private String nom;
    private String code;
    private String description;
    private String professeur;

    public Cours(String nom, String code, String description, String professeur) {
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.professeur = professeur;
    }

    public String getNom() { return nom; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getProfesseur() { return professeur; }
}