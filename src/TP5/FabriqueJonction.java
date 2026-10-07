package TP5;

public class FabriqueJonction implements FabriqueVehicule {

    private FabriqueVehicule fabrique1;
    private FabriqueVehicule fabrique2;
    private boolean tourFabrique1;

    public FabriqueJonction(FabriqueVehicule fabrique1, FabriqueVehicule fabrique2) {
        this.fabrique1 = fabrique1;
        this.fabrique2 = fabrique2;
        this.tourFabrique1 = true;
    }

    @Override
    public Vehicule creerVehicule() {
        Vehicule v;
        if (this.tourFabrique1) {
            v = this.fabrique1.creerVehicule();
        } else {
            v = this.fabrique2.creerVehicule();
        }
        this.tourFabrique1 = !this.tourFabrique1;
        return v;
    }
}