package TP2;

import java.util.ArrayList;
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

    public void ajouterNote(Matiere m, double note) {
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("La note doit etre entre 0 et 20");
        }
        if (formation.getCoeff(m) <= 0) {
            throw new IllegalArgumentException("Matiere absente");
        }
        if (!resultat.containsKey(m)) {
            resultat.put(m, new ArrayList<>());
        }
        resultat.get(m).add(note);
    }

    public double calculerMoyenne(Matiere m) {
        if (this.formation.getCoeff(m) <= 0){
            throw new IllegalArgumentException("Matiere absente");
        }
        if (!resultat.containsKey(m) || resultat.get(m).isEmpty()) {
            return 0.0;
        }
        double moyenne = 0;
        for (double note : resultat.get(m)) {
            moyenne += note;
        }
        return moyenne/resultat.get(m).size();
    }

    public double calculerMoyenneGenerale() {
        double sommeNotes = 0.0;
        double sommeCoeff = 0.0;
        for (Matiere m : this.formation.getMatieres()) {
            float coeff = this.formation.getCoeff(m);
            sommeNotes += this.calculerMoyenne(m) * coeff;
            sommeCoeff += coeff;
        }
        if (sommeCoeff == 0.0) {
            return 0.0;
        }
        return sommeNotes / sommeCoeff;
    }

    public Formation getFormation() {
        return formation;
    }
}
