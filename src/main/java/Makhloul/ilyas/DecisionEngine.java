package Makhloul.ilyas;

import org.apache.commons.text.similarity.CosineSimilarity;
import java.util.HashMap;
import java.util.Map;

public class DecisionEngine {
    public static void main(String[] args) {
        String offre = "Cet appel d’offre concerne un marché public pour la fourniture de logiciels.";
        String critere = "Cet appel d’offre concerne un marché public pour la fourniture de logiciels.";

        CosineSimilarity similarity = new CosineSimilarity();
        Map<CharSequence, Integer> vectorOffre = getVector(offre);
        Map<CharSequence, Integer> vectorCritere = getVector(critere);

        double score = similarity.cosineSimilarity(vectorOffre, vectorCritere);
        System.out.println("Score de pertinence : " + score);
    }

    private static Map<CharSequence, Integer> getVector(String text) {
        Map<CharSequence, Integer> vector = new HashMap<>();
        for (String word : text.split(" ")) {
            vector.put(word, vector.getOrDefault(word, 0) + 1);
        }
        return vector;
    }
}

