package TP5;

import java.util.Map;

public class MainSimulation {
    public static void main(String[] args) {
        // 1. Test avec la fabrique qui ne produit que des voitures
        System.out.println("=== Test Fabrique Voiture ===");
        FabriqueVehicule fVoiture = new FabriqueVoiture();
        Simulateur sim1 = new Simulateur(fVoiture);
        Map<String, Integer> stats1 = sim1.genererStats();
        sim1.ecrireStats(stats1);

        // 2. Test avec la fabrique qui ne produit que des piétons
        System.out.println("\n=== Test Fabrique Pieton ===");
        FabriqueVehicule fPieton = new FabriquePieton();
        Simulateur sim2 = new Simulateur(fPieton);
        Map<String, Integer> stats2 = sim2.genererStats();
        sim2.ecrireStats(stats2);

        // 3. Test avec la fabrique intersection (valeurs par défaut : 80% voiture, 10% piéton, 5% bus, 5% vélo)
        System.out.println("\n=== Test Fabrique Intersection (par défaut) ===");
        FabriqueVehicule fIntersection = new FabriqueIntersection();
        Simulateur sim3 = new Simulateur(fIntersection);
        Map<String, Integer> stats3 = sim3.genererStats();
        sim3.ecrireStats(stats3);

        // 4. Test avec la fabrique intersection paramétrée (ex: 50% voiture, 50% bus)
        System.out.println("\n=== Test Fabrique Intersection (personnalisée 50/50) ===");
        FabriqueVehicule fPerso = new FabriqueIntersection(50.0, 50.0, 0.0, 0.0);
        Simulateur sim4 = new Simulateur(fPerso);
        Map<String, Integer> stats4 = sim4.genererStats();
        sim4.ecrireStats(stats4);

        System.out.println("\n=== Test Fabrique Jonction (Voiture / Pieton) ===");
        FabriqueVehicule fJonction = new FabriqueJonction(new FabriqueVoiture(), new FabriquePieton());
        Simulateur simJonction = new Simulateur(fJonction);
        Map<String, Integer> statsJonction = simJonction.genererStats();
        simJonction.ecrireStats(statsJonction);
    }
}