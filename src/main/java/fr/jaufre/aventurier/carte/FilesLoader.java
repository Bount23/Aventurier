package fr.jaufre.aventurier.carte;

import fr.jaufre.aventurier.model.Aventurier;
import fr.jaufre.aventurier.model.Carte;
import fr.jaufre.aventurier.model.Position;
import fr.jaufre.aventurier.model.TypeCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe pour charger les fichier.
 */
public class FilesLoader {
    public static Carte chargerCarteDepuisFichier(String cheminFichier, Aventurier aventurier) throws Exception {
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));
        if (lignes.isEmpty()) {
            throw new IllegalArgumentException("Le fichier carte est vide.");
        }
        Map<Position, TypeCase> cases = new HashMap<Position, TypeCase>();

        for (int y = 0; y < lignes.size(); y++) {
            String ligne = lignes.get(y);
            for (int x = 0; x < ligne.length(); x++) {
                char symbole = ligne.charAt(x);
                TypeCase typeCase = TypeCase.depuisSymbole(symbole);
                if (typeCase != null) {
                    cases.put(new Position(x, y), typeCase);
                }
            }
        }

        return new Carte(cases, aventurier);
    }

    public static Aventurier chargerAventurierDepuisFichier(String cheminFichier) throws Exception {
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));
        if (lignes.isEmpty()) {
            throw new IllegalArgumentException("Le fichier de déplacements est vide.");
        }

        String[] infos = lignes.get(0).split(",");
        if (infos.length != 2 || !infos[0].matches("\\d+") || !infos[1].matches("\\d+")) {
            throw new IllegalArgumentException("Le format du fichier de déplacements est incorrect.");
        }

        Position positionInitiale = new Position(Integer.parseInt(infos[0]), Integer.parseInt(infos[1]));
        List<String> sequenceDeplacements = lignes.subList(1, lignes.size());

        return new Aventurier(positionInitiale, sequenceDeplacements);
    }
}