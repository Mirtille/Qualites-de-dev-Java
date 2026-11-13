package TP5Singleton;

class Avion extends Thread {
    private String nom;
    private Aeroport a;
    public Avion(String s){
        this.nom=s;
    }

    @Override
    public void run() {
        this.a = Aeroport.getInstance();
        System.out.println("Je suis avion " + this.nom + " sur aeroport " + this.a);

        try {
            while (!this.a.autoriserAdecoller()) {
                System.out.println(this.nom + " attend que la piste se libère...");
                Thread.sleep(500);
            }

            System.out.println(">>> " + this.nom + " décolle !");
            Thread.sleep((long) (Math.random() * 2000 + 1000));

            this.a.liberer_piste();
            System.out.println("<<< " + this.nom + " a décollé, piste libre.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}