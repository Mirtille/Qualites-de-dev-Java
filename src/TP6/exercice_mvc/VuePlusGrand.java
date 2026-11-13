package TP6.exercice_mvc;

import javafx.scene.control.TextField;

public class VuePlusGrand extends TextField implements Observateur {

    public VuePlusGrand() {
        super();
        this.setEditable(false);
    }

    @Override
    public void actualiser(Sujet s) {
        ModeleMots modele = (ModeleMots) s;
        this.setText(modele.getPlusGrandMot());
    }
}