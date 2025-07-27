package fr.jaufre.aventurier;

import fr.jaufre.aventurier.model.Aventurier;
import fr.jaufre.aventurier.model.Carte;
import fr.jaufre.aventurier.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting aventurier");

        if (args.length != 2) {
            logger.error("Usage: java -jar aventurier.jar <chemin-carte> <chemin-mouvements>");
            System.exit(1);
        }

        String cheminCarte = args[0];
        String cheminDeplacements = args[1];

        // Vérification de l'existence des fichiers
        if (!Files.exists(Paths.get(cheminCarte)) || !Files.isRegularFile(Paths.get(cheminCarte))) {
            logger.error("Erreur : Le fichier carte n'existe pas ou n'est pas un fichier valide.");
            System.exit(2);
        }
        if (!Files.exists(Paths.get(cheminDeplacements)) || !Files.isRegularFile(Paths.get(cheminDeplacements))) {
            logger.error("Erreur : Le fichier de déplacements n'existe pas ou n'est pas un fichier valide.");
            System.exit(2);
        }

        logger.debug("Chargement de la carte depuis : " + cheminCarte);
        logger.debug("Chargement des déplacements depuis : " + cheminDeplacements);

        try {
            Aventurier aventurier = FilesLoader.chargerAventurierDepuisFichier(cheminDeplacements);
            Carte carte = FilesLoader.chargerCarteDepuisFichier(cheminCarte, aventurier);

            logger.debug("{}", carte);
            logger.info("{}", carte.toStringCarte());

            logger.debug("Déplacement de l'aventurier");
            Position nouvellePosition = aventurier.getNewPosition();
            while (nouvellePosition != null) {
                logger.debug("L'aventurier souhaite aller sur la position {}", nouvellePosition);
                if(carte.deplacementIsValide(nouvellePosition)) {
                    aventurier.setPosition(nouvellePosition);
                } else {
                    logger.warn("Déplacement non valide vers la position {}", nouvellePosition);
                }
                logger.info("Carte actuelle :\n{}", carte.toStringCarte());

                nouvellePosition = aventurier.getNewPosition();
            }
            logger.info("Aventurier final : {}", aventurier.getPosition());
        } catch (Exception e) {
            logger.error("Erreur pendant l'exécution", e);
        }
    }
}