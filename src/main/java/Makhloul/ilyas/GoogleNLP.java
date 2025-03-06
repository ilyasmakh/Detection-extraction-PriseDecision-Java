package Makhloul.ilyas;

import com.google.cloud.language.v1.*;

public class GoogleNLP {
    public static void main(String[] args) throws Exception {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            Document doc = Document.newBuilder()
                    .setContent("Cet appel d’offre concerne la digitalisation des marchés publics.")
                    .setType(Document.Type.PLAIN_TEXT)
                    .build();

            AnalyzeEntitiesResponse response = language.analyzeEntities(doc);
            for (Entity entity : response.getEntitiesList()) {
                System.out.printf("Entité : %s, Type : %s%n", entity.getName(), entity.getType());
            }
        }
    }
}
