package TP6.compteur_mvc_exercice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo0_MVC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ModelCompteur model = new ModelCompteur();			//Creation du modele

        VueClics vueClics = new VueClics();
        VueGraphique vue = new VueGraphique(model);
        VueConsole vueConsole = new VueConsole();

        model.enregistrerObservateur(vue); //La vue s'enregistre comme vue du modele
        model.enregistrerObservateur(vueConsole);
        model.enregistrerObservateur(vueClics);

        vue.setMinWidth(70);
        vue.setAlignment(Pos.CENTER);

        Controler control= new Controler(model);  //Creation du controleur - le modele en parametre

        VBox hb= new VBox(10);
        hb.setAlignment(Pos.CENTER);

         Button bplus 	= new Button("Plus");
        bplus.setMinWidth(120);
        bplus.setMinHeight(40);
        bplus.setOnAction (control);

        Button bmoins    = new Button("Moins");
        bmoins.setMinWidth(120);
        bmoins.setMinHeight(40);
        bmoins.setOnAction (control);

        hb.getChildren().addAll(vueClics, bmoins, vue, bplus);

        Scene scene = new Scene(hb);
        stage.setTitle("MVC");
        stage.setScene(scene);
        stage.show();
    }
}
