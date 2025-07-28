package fr.jaufre.aventurier.model;

public enum Direction {
    N(0, -1),
    S(0, 1),
    E(1, 0),
    O(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Position appliquer(Position pos) {
        return new Position(pos.getX() + dx, pos.getY() + dy);
    }

    public static Direction fromChar(Character c) {
        switch (Character.toUpperCase(c)) {
            case 'N': return N;
            case 'S': return S;
            case 'E': return E;
            case 'O': return O;
            default: throw new IllegalArgumentException("Direction inconnue : " + c);
        }
    }
}