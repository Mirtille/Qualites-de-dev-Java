package TP2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {

    private Formation formation1;
    private Formation formation2;
    private Groupe groupe;
    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    void setUp() {
        formation1 = new Formation();
        formation2 = new Formation();
        groupe = new Groupe(formation1);

        Identite id1 = new Identite("Dupont", "Jean", "E001");
        Identite id2 = new Identite("Martin", "Claire", "E002");

        etudiant1 = new Etudiant(id1, formation1);
        etudiant2 = new Etudiant(id2, formation2);
    }

    @Test
    void testAjouterEtudiantMemeFormation() {
        groupe.ajouterEtudiant(etudiant1);
        assertTrue(groupe.getEtudiants().contains(etudiant1));
    }

    @Test
    void testAjouterEtudiantFormationDifferente() {
        assertThrows(IllegalArgumentException.class, () -> {
            groupe.ajouterEtudiant(etudiant2);
        });
    }

    @Test
    void testSupprimerEtudiant() {
        groupe.ajouterEtudiant(etudiant1);
        groupe.supprimerEtudiant(etudiant1);
        assertFalse(groupe.getEtudiants().contains(etudiant1));
    }
}