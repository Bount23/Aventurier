package fr.jaufre.aventurier.model;

import java.util.List;

/**
 * Classe Aventurier
 * Définit les informations liées à l'aventurier
 */
public class Aventurier {

    private Position position;
    private List<Character> sequenceDeplacements;

    public Aventurier(Position positionInitiale, List<Character> sequenceDeplacements) {
        this.position = positionInitiale;
        this.sequenceDeplacements = sequenceDeplacements;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    private Character getNextDeplacement() {
        if (sequenceDeplacements.isEmpty()) return null;
        return sequenceDeplacements.remove(0);
    }

    public Position getNewPosition() {
        Character deplacement = getNextDeplacement();
        if (deplacement == null) return null;
        Position newPosition = new Position(position.getX(), position.getY());

        switch (deplacement) {
            case 'N':
                newPosition.setY(newPosition.getY() - 1);
                break;
            case 'S':
                newPosition.setY(newPosition.getY() + 1);
                break;
            case 'E':
                newPosition.setX(newPosition.getX() + 1);
                break;
            case 'O':
                newPosition.setX(newPosition.getX() - 1);
                break;
            default:
                throw new IllegalArgumentException("Direction inconnue : " + deplacement);
        }
        return newPosition;
    }

    @Override
    public String toString() {
        return "Aventurier{" +
                "x=" + position.getX() +
                ", y=" + position.getY() +
                '}';
    }
}
