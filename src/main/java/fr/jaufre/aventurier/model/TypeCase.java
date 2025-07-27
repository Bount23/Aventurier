package fr.jaufre.aventurier.model;

public enum TypeCase {
    LIBRE(' '),
    BOIS('#');

    private final char symbole;

    TypeCase(char symbole) {
        this.symbole = symbole;
    }

    public boolean estAccessible() {
        return this == LIBRE;
    }

    public static TypeCase depuisSymbole(char c) {
        for (TypeCase type : values()) {
            if (type.symbole == c) {
                return type;
            }
        }
        throw new IllegalArgumentException("Caractère invalide dans la carte : '" + c + "'");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
