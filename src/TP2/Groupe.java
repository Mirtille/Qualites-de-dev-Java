package TP2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

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

    public double calculerMoyenne(Matiere m){
        if (formation.getCoeff(m) <= 0){
            throw new IllegalArgumentException("Matiere absente");
        }
        if (this.etudiants.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (Etudiant e : this.etudiants) {
            somme += e.calculerMoyenne(m);
        }

        return somme / this.etudiants.size();
    }

    public double calculerMoyenneGenerale() {
        if (this.etudiants.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (Etudiant e : this.etudiants) {
            somme += e.calculerMoyenneGenerale();
        }
        return somme / this.etudiants.size();
    }

    public List<Etudiant> triAlpha() {
        List<Etudiant> copie = new ArrayList<>(this.etudiants);
        copie.sort(Comparator.comparing((Etudiant e) -> e.getIdentite().getNom())
                .thenComparing(e -> e.getIdentite().getPrenom()));
        return copie;
    }

    public List<Etudiant> triAntiAlpha() {
        List<Etudiant> copie = new ArrayList<>(this.etudiants);
        copie.sort(Comparator.comparing((Etudiant e) -> e.getIdentite().getNom())
                .thenComparing(e -> e.getIdentite().getPrenom())
                .reversed());
        return copie;
    }

    public List<Etudiant> triParMerite() {
        List<Etudiant> copie = new ArrayList<>(this.etudiants);
        copie.sort(Comparator.comparingDouble((Etudiant e) -> e.calculerMoyenneGenerale())
                .reversed());
        return copie;
    }
}
