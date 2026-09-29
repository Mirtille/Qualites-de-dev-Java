package TP3;

public class ParcoursLigne extends Parcours {

    public ParcoursLigne(TableauEntier tabEntier) {
        super(tabEntier);
    }

    @Override
    public void suivant() {
        if (colonneCour < tabEntier.getLargeur() - 1) {
            colonneCour++;
        } else {
            colonneCour = 0;
            ligneCour++;
        }
    }
}
