package org.example.projetpoo;

public class Projet {
    private String nom;
    private String id;
    private String description;
    private String eleve;

    public Projet(String nom, String id, String description, String eleve) {
        this.nom = nom;
        this.id = id;
        this.description = description;
        this.eleve = eleve;
    }

    public String getNom() { return nom; }
    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getEleve() { return eleve; }

    @Override
    public String toString() {
        return nom + " (" + id + ") — " + eleve;
    }
}