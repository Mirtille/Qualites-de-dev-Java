package TP6.exercice_mvc;

public interface Sujet {
    void enregistrerObservateur(Observateur o);
    void supprimerObservateur(Observateur o);
    void notifierObservateurs();
}