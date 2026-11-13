package TP6.exercice_mvc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrincipaleIG extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // 1. Création du modèle
        ModeleMots modele = new ModeleMots();

        // 2. Création des vues et abonnement au modèle
        VueListeMots vListe = new VueListeMots();
        VuePlusGrand vMax = new VuePlusGrand();
        VuePlusPetit vMin = new VuePlusPetit();

        modele.enregistrerObservateur(vListe);
        modele.enregistrerObservateur(vMax);
        modele.enregistrerObservateur(vMin);

        // 3. Création du contrôleur
        ControleurMots controleur = new ControleurMots(modele);

        // Panel principal
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10));

        // Panel haut
        GridPane gpHaut = new GridPane();
        gpHaut.setPadding(new Insets(10));
        gpHaut.setHgap(25);
        gpHaut.setVgap(15);

        TextField control = new TextField();
        control.setOnAction(controleur);

        gpHaut.add(new Label(" Donner une chaîne "), 0, 0, 1, 1);
        gpHaut.add(control, 1, 0, 1, 1);
        bp.setTop(gpHaut);

        // Panel au centre
        bp.setCenter(vListe);

        // Panel en bas
        GridPane gpBas = new GridPane();
        gpBas.setPadding(new Insets(10));
        gpBas.setHgap(25);
        gpBas.setVgap(15);

        gpBas.add(new Label("     Plus grand mot     "), 0, 0, 1, 1);
        gpBas.add(vMax, 1, 0, 1, 1);
        gpBas.add(new Label("     Plus petit mot     "), 0, 1, 1, 1);
        gpBas.add(vMin, 1, 1, 1, 1);
        bp.setBottom(gpBas);

        Scene scene = new Scene(bp, 350, 350);
        stage.setScene(scene);
        stage.setTitle("MVC et observateur");
        stage.show();
    }
}