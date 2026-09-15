package TP2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormationTest {

    private Formation formation;
    private Matiere java;
    private Matiere bd;

    @BeforeEach
    void setUp() {
        formation = new Formation();
        java = new Matiere("Java");
        bd = new Matiere("BD");
    }

    @Test
    void testAjouterMatiereEtGetCoeff() {
        formation.ajouterMatiere(java, 2.0f);
        assertEquals(2.0f, formation.getCoeff(java), 0.001f);
    }

    @Test
    void testModifierCoeffMatiereExistante() {
        formation.ajouterMatiere(java, 2.0f);
        formation.ajouterMatiere(java, 3.5f);
        assertEquals(3.5f, formation.getCoeff(java), 0.001f);
    }

    @Test
    void testGetCoeffMatiereInexistante() {
        assertEquals(0.0f, formation.getCoeff(bd), 0.001f);
    }

    @Test
    void testGetMatieres() {
        formation.ajouterMatiere(java, 2.0f);
        formation.ajouterMatiere(bd, 1.5f);

        Set<Matiere> matieres = formation.getMatieres();
        assertEquals(2, matieres.size());
        assertTrue(matieres.contains(java));
        assertTrue(matieres.contains(bd));
    }
}