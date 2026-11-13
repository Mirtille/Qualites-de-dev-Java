package TP6.compteur_mvc_exercice;

public class VueConsole implements Observateur {

    @Override
    public void actualiser(Sujet s) {
        ModelCompteur modele = (ModelCompteur) s;
        System.out.println("Valeur actuelle du compteur : " + modele.getCompteur());
    }
}