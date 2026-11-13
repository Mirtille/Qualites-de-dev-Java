package TP6.exercice_mvc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class ControleurMots implements EventHandler<ActionEvent> {
    private ModeleMots modele;

    public ControleurMots(ModeleMots modele) {
        this.modele = modele;
    }

    @Override
    public void handle(ActionEvent event) {
        TextField champSaisie = (TextField) event.getSource();
        String texte = champSaisie.getText();
        this.modele.ajouterMot(texte);
        champSaisie.clear();
    }
}