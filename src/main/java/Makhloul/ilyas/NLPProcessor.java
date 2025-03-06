package Makhloul.ilyas ;

import opennlp.tools.tokenize.SimpleTokenizer;

public class NLPProcessor {
    public static void main(String[] args) {
        String text = "Cet appel d’offre concerne un marché public de prestation de services.";
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(text);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}