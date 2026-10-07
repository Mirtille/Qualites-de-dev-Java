package TP5;

public abstract class Vehicule {

    private double vitesse, vitesseMax;
    private String type;

    public Vehicule(double vitesseMax, String type) {
        this.vitesseMax = vitesseMax;
        this.type = type;
        this.vitesse = 0;
    }

    public double getVitesse() {
        return vitesse;
    }

    public String getType() {
        return type;
    }

    public void accelerer(double acceleration) {
        vitesse = Math.min(vitesseMax, vitesse + acceleration);
    }

    public void decelerer(double deceleration) {
        vitesse = Math.max(0, vitesse - deceleration);
    }
}
