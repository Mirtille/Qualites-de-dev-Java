package TP5Singleton;

public class Aeroport{
    private boolean piste_libre;
    private static Aeroport instance;

    public Aeroport(){
        this.piste_libre=true;
    }

    public static synchronized Aeroport getInstance() {
        if (instance == null) {
            instance = new Aeroport();
        }
        return instance;
    }

    public synchronized boolean autoriserAdecoller() {
        if (this.piste_libre) {
            this.piste_libre = false;
            return true;
        }
        return false;
    }

public synchronized boolean liberer_piste() {
    this.piste_libre = true;
        return true;
    }
}