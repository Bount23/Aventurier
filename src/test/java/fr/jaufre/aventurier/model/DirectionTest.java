package fr.jaufre.aventurier.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("Déplace correctement la position selon les directions")
    void testAppliquerDirection() {
        Position start = new Position(5, 5);

        assertEquals(new Position(5, 4), Direction.N.appliquer(start), "Nord");
        assertEquals(new Position(5, 6), Direction.S.appliquer(start), "Sus");
        assertEquals(new Position(6, 5), Direction.E.appliquer(start), "Est");
        assertEquals(new Position(4, 5), Direction.O.appliquer(start), "Ouest");
    }

    @Test
    @DisplayName("Retourne la bonne direction pour les lettres valides")
    void testFromCharValide() {
        assertEquals(Direction.N, Direction.fromChar('N'));
        assertEquals(Direction.S, Direction.fromChar('S'));
        assertEquals(Direction.E, Direction.fromChar('E'));
        assertEquals(Direction.O, Direction.fromChar('O'));
    }

    @Test
    @DisplayName("Lève une exception sur un caractère invalide")
    void testFromCharInvalide() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Direction.fromChar('X')
        );
        assertEquals("Direction inconnue : X", exception.getMessage());
    }
}