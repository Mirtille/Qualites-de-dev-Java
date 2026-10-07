package TP5;

public class FabriqueIntersection implements FabriqueVehicule {

    private double probaVoiture, probaBus, probaByc, probaPieton;

    public FabriqueIntersection() {
        this.probaVoiture = 80.0;
        this.probaPieton = 10.0;
        this.probaBus = 5.0;
        this.probaByc = 5.0;
    }

    public FabriqueIntersection(double probaVoiture, double probaBus, double probaPieton, double probaByc) {
        if (probaVoiture < 0 || probaBus < 0 || probaPieton < 0 || probaByc < 0) {
            throw new IllegalArgumentException("Les probabilités doivent être positives.");
        }
        if (probaVoiture + probaBus + probaPieton + probaByc != 100.0) {
            throw new IllegalArgumentException("La somme des probabilités doit être égale à 100.");
        }
        this.probaVoiture = probaVoiture;
        this.probaBus = probaBus;
        this.probaPieton = probaPieton;
        this.probaByc = probaByc;
    }

    @Override
    public Vehicule creerVehicule() {
        double prob = Math.random() * 100;
        if (prob < this.probaVoiture) {
            return new Voiture();
        } else if (prob < this.probaVoiture + this.probaBus) {
            return new Bus();
        } else if (prob < this.probaVoiture + this.probaBus + this.probaByc) {
            return new Bicyclette();
        } else {
            return new Pieton();
        }
    }
}
