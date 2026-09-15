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

    @Test
    void testCalculerMoyenneMatiereGroupe() {
        Matiere maths = new Matiere("Maths");
        formation1.ajouterMatiere(maths, 2.0f);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        etudiant1.ajouterNote(maths, 10.0);
        etudiant1.ajouterNote(maths, 14.0); // Moyenne etudiant1 = 12.0

        etudiant2.ajouterNote(maths, 16.0); // Moyenne etudiant2 = 16.0

        assertEquals(14.0, groupe.calculerMoyenne(maths), 0.001);
    }

    @Test
    void testCalculerMoyenneGeneraleGroupe() {
        Matiere maths = new Matiere("Maths");
        Matiere info = new Matiere("Info");
        formation1.ajouterMatiere(maths, 2.0f);
        formation1.ajouterMatiere(info, 3.0f);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        etudiant1.ajouterNote(maths, 10.0);
        etudiant1.ajouterNote(info, 15.0);

        etudiant2.ajouterNote(maths, 14.0);
        etudiant2.ajouterNote(info, 10.0);

        assertEquals(12.3, groupe.calculerMoyenneGenerale(), 0.001);
    }
}