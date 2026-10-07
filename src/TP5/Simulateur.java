package TP5;

import java.util.HashMap;
import java.util.Map;

public class Simulateur{

    private FabriqueVehicule vehicule;

    public Simulateur(FabriqueVehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Map<String, Integer> genererStats(){
        Map<String, Integer> stats = new HashMap<>();
        for (int i = 0; i < 100; i++){
            Vehicule v = this.vehicule.creerVehicule();
            String type = v.getType();
            stats.put(type, stats.getOrDefault(type, 0) + 1);
        }
        return stats;
    }

    public void ecrireStats(Map<String, Integer> stats) {
        System.out.println("--- Statistiques de circulation ---");
        for (Map.Entry<String, Integer> entree : stats.entrySet()) {
            System.out.println(entree.getKey() + " : " + entree.getValue() + " véhicules");
        }
    }
}
