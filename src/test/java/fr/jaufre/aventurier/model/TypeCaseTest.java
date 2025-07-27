package fr.jaufre.aventurier.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests unitaires de l'enum TypeCase")
class TypeCaseTest {

    @Test
    @DisplayName("LIBRE doit être accessible")
    void testEstAccessibleLibre() {
        assertTrue(TypeCase.LIBRE.estAccessible());
    }

    @Test
    @DisplayName("BOIS ne doit pas être accessible")
    void testEstAccessibleBois() {
        assertFalse(TypeCase.BOIS.estAccessible());
    }

    @Test
    @DisplayName("Retourne le bon enum depuis le symbole")
    void testDepuisSymboleValide() {
        assertEquals(TypeCase.LIBRE, TypeCase.depuisSymbole(' '));
        assertEquals(TypeCase.BOIS, TypeCase.depuisSymbole('#'));
    }

    @Test
    @DisplayName("Doit lever une exception pour un symbole invalide")
    void testDepuisSymboleInvalide() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            TypeCase.depuisSymbole('X');
        });
        assertTrue(e.getMessage().contains("Caractère invalide"));
    }
}