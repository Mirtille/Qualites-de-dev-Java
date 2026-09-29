package TP3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TableauEntierTest {

    @Test
    void testIterateurLigne() {
        int[][] donnees = {
                {1, 2, 3},
                {4, 5, 6}
        };
        TableauEntier tableau = new TableauEntier(donnees);

        ParcoursLigne it = tableau.iterateurLigne();
        List<Integer> resultat = new ArrayList<>();

        while (it.hasNext()) {
            resultat.add(it.next());
        }

        List<Integer> attendu = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(attendu, resultat);
    }

    @Test
    void testIterateurZigZag() {
        int[][] donnees = {
                {1, 2, 3},
                {4, 5, 6}
        };
        TableauEntier tableau = new TableauEntier(donnees);

        ParcoursZigZag it = tableau.iterateurZigZag();
        List<Integer> resultat = new ArrayList<>();

        while (it.hasNext()) {
            resultat.add(it.next());
        }

        List<Integer> attendu = List.of(1, 2, 3, 6, 5, 4);

        assertEquals(attendu, resultat);
    }
}