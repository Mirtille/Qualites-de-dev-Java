package TP6.compteur_mvc_exercice;

import javafx.scene.control.Label;

public class VueClics extends Label implements Observateur {

    public VueClics() {
        super("Nb clics: 0");
    }

    @Override
    public void actualiser(Sujet s) {
        ModelCompteur model = (ModelCompteur) s;
        this.setText("Nb clics: " + model.getNbClics());
    }
}