package TP2;

import java.util.ArrayList;
import java.util.List;

public class Groupe {

    Formation formation;
    List<Etudiant> etudiants;

    public Groupe(Formation formation) {
        this.formation = formation;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public void ajouterEtudiant(Etudiant e) {
        if (e == null) {
            throw new IllegalArgumentException("l'etudiant ne peut pas etre null.");
        }
        if (!this.formation.equals(e.getFormation())) {
            throw new IllegalArgumentException("l'etudiant ne suit pas la formation du groupe.");
        }
        if (!this.etudiants.contains(e)) {
            this.etudiants.add(e);
        }
    }

    public void supprimerEtudiant(Etudiant e) {
        this.etudiants.remove(e);
    }

    public List<Etudiant> getEtudiants() {
        return this.etudiants;
    }
}
