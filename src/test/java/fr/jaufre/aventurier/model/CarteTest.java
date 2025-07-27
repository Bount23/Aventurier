package fr.jaufre.aventurier.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests unitaires de la classe Carte")
class CarteTest {

    private Carte carte;
    private Aventurier aventurier;
    private Map<Position, TypeCase> cases;

    @BeforeEach
    @DisplayName("Initialisation d'une carte 3x3 avec un aventurier en (0,0) et une case mur en (1,1)")
    void setUp() {
        cases = new HashMap<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cases.put(new Position(x, y), TypeCase.LIBRE);
            }
        }
        cases.put(new Position(1, 1), TypeCase.BOIS); // case bloquée

        aventurier = new Aventurier(new Position(0, 0), new ArrayList<Character>(Arrays.asList('E', 'O')));
        carte = new Carte(cases, aventurier);
    }

    @Test
    @DisplayName("Case libre")
    void testDeplacementSurCaseLibre() {
        assertTrue(carte.deplacementIsValide(new Position(0, 1)));
        assertTrue(carte.deplacementIsValide(new Position(2, 1)));
        assertTrue(carte.deplacementIsValide(new Position(1, 2)));
    }

    @Test
    @DisplayName("Case bois")
    void testDeplacementSurCaseMur() {
        assertFalse(carte.deplacementIsValide(new Position(1, 1)));
    }

    @Test
    @DisplayName("Hors carte")
    void testDeplacementHorsCarte() {
        assertFalse(carte.deplacementIsValide(new Position(5, 5)));
        assertFalse(carte.deplacementIsValide(new Position(-5, 5)));
        assertFalse(carte.deplacementIsValide(new Position(2, 3)));
        assertFalse(carte.deplacementIsValide(new Position(3, 2)));
    }

    @Test
    @DisplayName("Case de type null")
    void testDeplacementSurCaseNulle() {
        cases.put(new Position(2, 2), null);
        assertFalse(carte.deplacementIsValide(new Position(2, 2)));
    }

    @Test
    @DisplayName("Doit retourner les éléments de la carte")
    void testGetters() {
        assertEquals(cases, carte.getCases());
        assertEquals(aventurier, carte.getAventurier());
    }

    @Test
    @DisplayName("Doit modifier l'aventurier de la carte")
    void testSetAventurier() {
        Aventurier nouveau = new Aventurier(new Position(2, 2), new ArrayList<Character>(Arrays.asList('E', 'O')));
        carte.setAventurier(nouveau);
        assertEquals(nouveau, carte.getAventurier());
    }
}