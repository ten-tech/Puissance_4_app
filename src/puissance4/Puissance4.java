package puissance4;

import java.util.Arrays;

public class Puissance4 {
    private static final int LIGNES = 6;
    private static final int COLONNES = 7;
    private static final char VIDE = ' ';

    private char[][] grille;

    public Puissance4() {
        initialiserGrille();
    }

    private void initialiserGrille() {
        grille = new char[LIGNES][COLONNES];
        for (char[] ligne : grille) {
            Arrays.fill(ligne, VIDE);
        }
    }

    public void viderGrille() {
        initialiserGrille();
    }

    public void afficherGrille() {
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < LIGNES; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < COLONNES; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Puissance4 jeu = new Puissance4();

        // Exercice 2 : Vider la grille
        jeu.viderGrille();
        jeu.afficherGrille();
    }

}
