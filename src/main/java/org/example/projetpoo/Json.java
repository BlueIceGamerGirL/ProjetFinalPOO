package org.example.projetpoo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Json {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void sauvegarderProfesseurs(List<Professeur> liste) {
        try (FileWriter writer = new FileWriter("profs.json")) {
            gson.toJson(liste, writer);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static List<Professeur> chargerProfesseurs() {
        File fichier = new File("profs.json");
        if (!fichier.exists()) return new ArrayList<>();
        Type type = new TypeToken<List<Professeur>>() {}.getType();
        try (FileReader reader = new FileReader(fichier)) {
            List<Professeur> liste = gson.fromJson(reader, type);
            return liste != null ? liste : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void sauvegarderEtudiants(List<Etudiant> liste) {
        try (FileWriter writer = new FileWriter("etudiants.json")) {
            gson.toJson(liste, writer);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static List<Etudiant> chargerEtudiants() {
        File fichier = new File("etudiants.json");
        if (!fichier.exists()) return new ArrayList<>();
        Type type = new TypeToken<List<Etudiant>>() {}.getType();
        try (FileReader reader = new FileReader(fichier)) {
            List<Etudiant> liste = gson.fromJson(reader, type);
            return liste != null ? liste : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void sauvegarderCours(List<Cours> liste) {
        try (FileWriter writer = new FileWriter("cours.json")) {
            gson.toJson(liste, writer);
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static List<Cours> chargerCours() {
        File fichier = new File("cours.json");
        if (!fichier.exists()) return new ArrayList<>();
        Type type = new TypeToken<List<Cours>>() {}.getType();
        try (FileReader reader = new FileReader(fichier)) {
            List<Cours> liste = gson.fromJson(reader, type);
            return liste != null ? liste : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}