package fr.jaufre.aventurier.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests unitaires de la classe Aventurier")
public class AventurierTest {

    @Test
    @DisplayName("L'aventurier retourne une nouvelle position correcte pour un seul déplacement")
    void testGetNewPosition() {
        Aventurier aventurier = new Aventurier(
                new Position(3, 3),
                new ArrayList<>(Arrays.asList('S'))
        );

        Position nouvellePosition = aventurier.getNewPosition();

        assertEquals(new Position(3, 4), nouvellePosition);
        assertEquals(new Position(3, 3), aventurier.getPosition(), "La position de l'aventurier ne doit pas être modifiée");
    }

    @Test
    @DisplayName("L'aventurier retourne null s'il n'y a plus de déplacements")
    void testGetNewPositionAvecSequenceVide() {
        Aventurier aventurier = new Aventurier(new Position(2, 2), new ArrayList<>());

        assertNull(aventurier.getNewPosition());
    }

    @Test
    @DisplayName("L'aventurier peut effectuer une séquence complète de déplacements")
    void testDeplacementsSuccessifs() {
        Aventurier aventurier = new Aventurier(
                new Position(0, 0),
                new ArrayList<>(Arrays.asList('S', 'S', 'E', 'E', 'N'))
        );

        aventurier.setPosition(aventurier.getNewPosition());
        assertEquals(new Position(0, 1), aventurier.getPosition());

        aventurier.setPosition(aventurier.getNewPosition());
        assertEquals(new Position(0, 2), aventurier.getPosition());

        aventurier.setPosition(aventurier.getNewPosition());
        assertEquals(new Position(1, 2), aventurier.getPosition());

        aventurier.setPosition(aventurier.getNewPosition());
        assertEquals(new Position(2, 2), aventurier.getPosition());

        aventurier.setPosition(aventurier.getNewPosition());
        assertEquals(new Position(2, 1), aventurier.getPosition());

        assertNull(aventurier.getNewPosition(), "Plus aucun déplacement ne doit rester");
    }

    @Test
    @DisplayName("Une direction invalide dans la séquence lève une exception")
    void testDeplacementInvalide() {
        Aventurier aventurier = new Aventurier(
                new Position(0, 0),
                new ArrayList<>(Arrays.asList('X')) // direction inconnue
        );

        Exception exception = assertThrows(IllegalArgumentException.class, aventurier::getNewPosition);
        assertEquals("Direction inconnue : X", exception.getMessage());
    }
}