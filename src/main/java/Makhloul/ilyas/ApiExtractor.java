package Makhloul.ilyas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiExtractor {

    public static void main(String[] args) {
        // URL de l'API BOAMP pour récupérer les appels d'offres
        String url = "https://www.boamp.fr/api/explore/v2.0/catalog/datasets/boamp/records?limit=100";

        // Création de l'ObjectMapper pour gérer le JSON
        ObjectMapper objectMapper = new ObjectMapper();
         int i = 1 ;
        try {
            // Récupérer la réponse JSON depuis l'API
            JsonNode rootNode = objectMapper.readTree(new URL(url));

            // Accéder au tableau "records"
            JsonNode recordsNode = rootNode.path("records");

            // Itérer sur chaque appel d'offre dans le tableau
            for (JsonNode record : recordsNode) {
                // Extraire l'objet "record" contenant les détails de l'appel d'offre
                JsonNode recordData = record.path("record");

                // Extraire l'attribut "objet" de l'appel d'offre
                String objet = recordData.path("fields").path("objet").asText();

                // Afficher l'objet dans la console
                System.out.println(i+" - Objet : " + objet);
                i++ ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

