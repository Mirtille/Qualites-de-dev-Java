package TP2;

import java.util.HashMap;

public class Formation {
    private HashMap<Matiere, Float> formation;

    public Formation() {
        this.formation = new HashMap<>();
    }

    public void ajouterMatiere(Matiere m, float coeff) {
        this.formation.put(m, coeff);
    }

    public float getCoeff(Matiere m) {
        return this.formation.get(m);
    }
}
