package TP2;

import java.util.HashMap;
import java.util.List;

public class Etudiant {
    private Identite identite;
    private Formation formation;
    private HashMap<Matiere, List<Double>> resultat;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.resultat = new HashMap<>();
    }
}
