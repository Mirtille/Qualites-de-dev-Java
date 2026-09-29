package TP3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Parcours implements Iterator<Integer> {

    private TableauEntier tabEntier;
    private int ligneCour, colonneCour, nbParcour;

    public Parcours(TableauEntier tabEntier) {
        this.tabEntier = tabEntier;
        this.ligneCour = 0;
        this.colonneCour = 0;
        this.nbParcour = 0;
    }

    @Override
    public boolean hasNext() {
        return nbParcour < (tabEntier.getHauteur() * tabEntier.getLargeur());
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Toutes les cases ont été parcourues.");
        }
        int valeur = tabEntier.valeurA(ligneCour, colonneCour);
        nbParcour++;
        if (hasNext()) {
            suivant();
        }
        return valeur;
    }

    public abstract void suivant();
}
