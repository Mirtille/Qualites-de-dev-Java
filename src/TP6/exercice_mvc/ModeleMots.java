package TP6.exercice_mvc;

import java.util.ArrayList;

public class ModeleMots implements Sujet {
    private ArrayList<String> mots;
    private String plusGrandMot;
    private String plusPetitMot;
    private ArrayList<Observateur> observateurs;

    public ModeleMots() {
        this.mots = new ArrayList<>();
        this.plusGrandMot = "";
        this.plusPetitMot = "";
        this.observateurs = new ArrayList<>();
    }

    public void ajouterMot(String mot) {
        if (mot == null || mot.trim().isEmpty()) {
            return;
        }
        String motNettoye = mot.trim();
        this.mots.add(motNettoye);

        if (this.mots.size() == 1) {
            this.plusGrandMot = motNettoye;
            this.plusPetitMot = motNettoye;
        } else {
            if (motNettoye.length() > this.plusGrandMot.length() ||
                (motNettoye.length() == this.plusGrandMot.length() && motNettoye.compareTo(this.plusGrandMot) > 0)) {
                this.plusGrandMot = motNettoye;
            }

            // Mise à jour du plus petit mot (longueur < ou égalité avec ordre alphabétique inférieur)
            if (motNettoye.length() < this.plusPetitMot.length() ||
                (motNettoye.length() == this.plusPetitMot.length() && motNettoye.compareTo(this.plusPetitMot) < 0)) {
                this.plusPetitMot = motNettoye;
            }
        }

        notifierObservateurs();
    }

    public ArrayList<String> getMots() {
        return this.mots;
    }

    public String getPlusGrandMot() {
        return this.plusGrandMot;
    }

    public String getPlusPetitMot() {
        return this.plusPetitMot;
    }

    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    @Override
    public void supprimerObservateur(Observateur o) {
        this.observateurs.remove(o);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur o : this.observateurs) {
            o.actualiser(this);
        }
    }
}