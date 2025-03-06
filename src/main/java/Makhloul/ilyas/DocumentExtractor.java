package Makhloul.ilyas ;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class DocumentExtractor {
    public static void main(String[] args) throws IOException, TikaException, URISyntaxException {
        // Charger le fichier depuis le classpath
        ClassLoader classLoader = DocumentExtractor.class.getClassLoader();
        URL resource = classLoader.getResource("appel d'offre.pdf");

        if (resource == null) {
            System.out.println("Fichier non trouvé !");
            return;
        }

        // Convertir l'URL en fichier
        File file = Paths.get(resource.toURI()).toFile();

        // Extraire le texte avec Tika
        Tika tika = new Tika();
        String text = tika.parseToString(file);
        System.out.println("Texte extrait : " + text);
    }
}