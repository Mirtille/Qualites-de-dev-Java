package TP2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    Etudiant etudiant;
    Identite identite;
    Formation formation;
    Matiere java;

    @BeforeEach
    void setUp() {
        java = new Matiere("Java");
        identite = new Identite("Edouard","Justin","123456789");
        formation = new Formation();
        formation.ajouterMatiere(java,2);
        etudiant = new Etudiant(identite,formation);
    }

    @Test
    void testAjouterNote() {
        etudiant.ajouterNote(java,10);
        assertEquals(10,etudiant.calculerMoyenne(new Matiere("Java")));
    }

    @Test
    void testCalculerMoyenneGenerale() {
        etudiant.ajouterNote(java,10);
        etudiant.ajouterNote(java,10);
        assertEquals(10,etudiant.calculerMoyenneGenerale(),0.001);
    }
}