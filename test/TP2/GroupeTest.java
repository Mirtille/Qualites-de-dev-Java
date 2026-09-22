package TP2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        Etudiant etudiantMemeFormation = new Etudiant(new Identite("Test", "Paul", "E003"), formation1);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiantMemeFormation);

        etudiant1.ajouterNote(maths, 10.0);
        etudiant1.ajouterNote(maths, 14.0); // Moyenne = 12.0

        etudiantMemeFormation.ajouterNote(maths, 16.0); // Moyenne = 16.0

        assertEquals(14.0, groupe.calculerMoyenne(maths), 0.001);
    }

    @Test
    void testCalculerMoyenneGeneraleGroupe() {
        Matiere maths = new Matiere("Maths");
        Matiere info = new Matiere("Info");
        formation1.ajouterMatiere(maths, 2.0f);
        formation1.ajouterMatiere(info, 3.0f);

        Etudiant etudiantMemeFormation = new Etudiant(new Identite("Test", "Paul", "E003"), formation1);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiantMemeFormation);

        etudiant1.ajouterNote(maths, 10.0);
        etudiant1.ajouterNote(info, 15.0);

        etudiantMemeFormation.ajouterNote(maths, 14.0);
        etudiantMemeFormation.ajouterNote(info, 10.0);

        assertEquals(12.3, groupe.calculerMoyenneGenerale(), 0.001);
    }

    @Test
    void testTriAlpha() {
        Etudiant e1 = new Etudiant(new Identite("Zidane", "Zinedine", "E10"), formation1);
        Etudiant e2 = new Etudiant(new Identite("Dupont", "Alice", "E11"), formation1);
        Etudiant e3 = new Etudiant(new Identite("Bernard", "Lucas", "E12"), formation1);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);

        List<Etudiant> tries = groupe.triAlpha();

        assertEquals(3, tries.size());
        assertEquals("Bernard", tries.get(0).getIdentite().getNom());
        assertEquals("Dupont", tries.get(1).getIdentite().getNom());
        assertEquals("Zidane", tries.get(2).getIdentite().getNom());
    }

    @Test
    void testTriAntiAlpha() {
        Etudiant e1 = new Etudiant(new Identite("Zidane", "Zinedine", "E10"), formation1);
        Etudiant e2 = new Etudiant(new Identite("Dupont", "Alice", "E11"), formation1);
        Etudiant e3 = new Etudiant(new Identite("Bernard", "Lucas", "E12"), formation1);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);

        List<Etudiant> tries = groupe.triAntiAlpha();

        assertEquals(3, tries.size());
        assertEquals("Zidane", tries.get(0).getIdentite().getNom());
        assertEquals("Dupont", tries.get(1).getIdentite().getNom());
        assertEquals("Bernard", tries.get(2).getIdentite().getNom());
    }

    @Test
    void testTriAlphaHomonymes() {
        Etudiant e1 = new Etudiant(new Identite("Dupont", "Zoe", "E20"), formation1);
        Etudiant e2 = new Etudiant(new Identite("Dupont", "Alice", "E21"), formation1);

        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);

        List<Etudiant> tries = groupe.triAlpha();

        assertEquals(2, tries.size());
        assertEquals("Alice", tries.get(0).getIdentite().getPrenom());
        assertEquals("Zoe", tries.get(1).getIdentite().getPrenom());
    }

    @Test
    void testTriParMerite() {
        Matiere info = new Matiere("Info");
        formation1.ajouterMatiere(info, 1.0f);

        Etudiant ePremier = new Etudiant(new Identite("A", "Jean", "01"), formation1);
        Etudiant eDeuxieme = new Etudiant(new Identite("B", "Paul", "02"), formation1);
        Etudiant eDernier = new Etudiant(new Identite("C", "Luc", "03"), formation1);

        ePremier.ajouterNote(info, 18.0);
        eDeuxieme.ajouterNote(info, 14.0);
        eDernier.ajouterNote(info, 9.0);

        groupe.ajouterEtudiant(eDeuxieme);
        groupe.ajouterEtudiant(eDernier);
        groupe.ajouterEtudiant(ePremier);

        List<Etudiant> classement = groupe.triParMerite();

        assertEquals(3, classement.size());
        assertEquals(ePremier, classement.get(0));
        assertEquals(eDeuxieme, classement.get(1));
        assertEquals(eDernier, classement.get(2));
    }
}