package TP6.exercice_mvc;

import javafx.scene.control.TextArea;

public class VueListeMots extends TextArea implements Observateur {

    public VueListeMots() {
        super();
        this.setEditable(false);
    }

    @Override
    public void actualiser(Sujet s) {
        ModeleMots modele = (ModeleMots) s;
        StringBuilder sb = new StringBuilder();
        for (String mot : modele.getMots()) {
            sb.append(mot).append("\n");
        }
        this.setText(sb.toString());
    }
}