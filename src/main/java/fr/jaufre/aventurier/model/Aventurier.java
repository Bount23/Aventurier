package fr.jaufre.aventurier.model;

import java.util.List;

/**
 * Classe Aventurier
 * Définit les informations liées à l'aventurier
 */
public class Aventurier {

    private Position position;
    private List<String> sequenceDeplacements;

    public Aventurier(Position positionInitiale, List<String> sequenceDeplacements) {
        this.position = positionInitiale;
        this.sequenceDeplacements = sequenceDeplacements;
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNextDeplacement() {
        if (sequenceDeplacements.isEmpty()) return null;
        return sequenceDeplacements.remove(0);
    }

    @Override
    public String toString() {
        return "Aventurier{" +
                "x=" + position.getX() +
                ", y=" + position.getY() +
                '}';
    }
}
