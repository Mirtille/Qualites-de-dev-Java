package TP3;

public class ParcoursZigzag extends Parcours{

    public ParcoursZigzag(TableauEntier tabEntier) {
        super(tabEntier);
    }

    @Override
    public void suivant() {
        if (ligneCour % 2 == 0) {
            if (colonneCour < tabEntier.getLargeur() - 1) {
                colonneCour++;
            } else {
                colonneCour = tabEntier.getLargeur() - 1;
                ligneCour++;
            }
        } else {
            if (colonneCour > 0) {
                colonneCour--;
            } else {
                colonneCour = 0;
                ligneCour++;
            }
        }
    }
}
