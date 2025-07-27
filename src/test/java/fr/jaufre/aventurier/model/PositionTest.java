package fr.jaufre.aventurier.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests unitaires de la classe Position")
class PositionTest {

    @Test
    @DisplayName("Deux positions identiques doivent être égales")
    void testEqualsTrue() {
        Position p1 = new Position(2, 3);
        Position p2 = new Position(2, 3);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode(), "hashCode doit aussi être égal");

        Position p3 = new Position(4, 5);
        Position p4 = new Position(4, 5);
        assertEquals(p3, p4);
        assertEquals(p3.hashCode(), p4.hashCode(), "hashCode doit aussi être égal");
    }

    @Test
    @DisplayName("Deux positions différentes ne doivent pas être égales")
    void testEqualsFalse() {
        Position p1 = new Position(2, 3);
        Position p2 = new Position(4, 5);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode(), "hashCode doit aussi être différent");

        Position p3 = new Position(1, 2);
        Position p4 = new Position(2, 1);
        assertNotEquals(p3, p4);
        assertNotEquals(p3.hashCode(), p4.hashCode(), "hashCode doit aussi être différent");
    }

    @Test
    @DisplayName("doit permettre la modification des coordonnées avec les setters")
    void testSetters() {
        Position p1 = new Position(0, 0);
        assertEquals(0, p1.getX());
        assertEquals(0, p1.getY());
        p1.setX(5);
        p1.setY(7);
        assertEquals(5, p1.getX());
        assertEquals(7, p1.getY());

        Position p2 = new Position(0, 2);
        assertEquals(0, p2.getX());
        assertEquals(2, p2.getY());
        p2.setX(3);
        p2.setY(1);
        assertEquals(3, p2.getX());
        assertEquals(1, p2.getY());
    }
}
