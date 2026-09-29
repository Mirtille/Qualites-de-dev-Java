package TP3;

public class TableauEntier {

    private int[][] tab;

    public TableauEntier(int[][] t) {
        this.tab = t;
    }

    public int valeurA(int l, int c) {
        return this.tab[l][c];
    }

    public int getHauteur() {
        return this.tab.length;
    }

    public int getLargeur() {
        if (this.tab.length == 0) {
            return 0;
        }
        return this.tab[0].length;
    }

    public ParcoursLigne iterateurLigne() {
        return new ParcoursLigne(this);
    }

    public ParcoursZigZag iterateurZigZag() {
        return new ParcoursZigZag(this);
    }

    public ParcoursColonne iterateurColonne() {
        return new ParcoursColonne(this);
    }
}