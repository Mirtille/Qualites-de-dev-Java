package TP3;

public class ParcoursColonne extends Parcours{

    public ParcoursColonne(TableauEntier tabEntier) {
        super(tabEntier);
    }

    @Override
    public void suivant(){
        if (ligneCour < tabEntier.getHauteur() - 1) {
            ligneCour++;
        } else {
            ligneCour = 0;
            colonneCour++;
        }
    }
}
