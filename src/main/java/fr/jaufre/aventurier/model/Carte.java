package fr.jaufre.aventurier.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Carte {
    private Map<Position, TypeCase> cases;
    private Aventurier aventurier;

    public Carte(Map<Position, TypeCase> cases, Aventurier aventurier) {
        this.cases = cases;
        this.aventurier = aventurier;
    }

    public Map<Position, TypeCase> getCases() {
        return cases;
    }
    public Aventurier getAventurier() {
        return aventurier;
    }
    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "cases=" + cases +
                ", aventurier=" + aventurier +
                '}';
    }
    public String toStringCarte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carte :\n");

        // Déterminer les dimensions de la carte
        int maxX = 0;
        int maxY = 0;
        for (Position pos : cases.keySet()) {
            if (pos.getX() > maxX) maxX = pos.getX();
            if (pos.getY() > maxY) maxY = pos.getY();
        }

        for (int y = 0; y <= maxY; y++) {
            sb.append("\n");
            sb.append(y+1);
            sb.append("\t");
            for (int x = 0; x <= maxX; x++) {
                Position pos = new Position(x, y);
                if(aventurier.getPosition().equals(pos)){
                    sb.append("+");
                } else {
                    TypeCase type = cases.get(pos);
                    if (type != null) {
                        sb.append(type.equals(TypeCase.LIBRE) ? " " : "#");
                    }
                }
            }
        }

        return sb.toString();
    }

    public boolean deplacementIsValide(Position position) {
        if(!cases.containsKey(position)) return false; // On est à l'extérieur de la cartes
        TypeCase typeCase = cases.get(position);
        if (typeCase == null) return false; // Case non définie
        return typeCase.equals(TypeCase.LIBRE); // On ne peut se déplacer que sur des cases libres
    }
}