package com.example.firstmaven;

import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;
import edu.mit.jwi.morph.WordnetStemmer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.morph.SimpleStemmer;

public class Step2SentenceRephraser {
    private IDictionary dict;

    public Step2SentenceRephraser(String wordNetPath) throws IOException {
        // Load WordNet dictionary
        URL url = new URL("file", null, wordNetPath);
        dict = new Dictionary(new File(url.getFile()));
        dict.open();
    }

    public String rephraseSentence(String sentence) {
        // Tokenize the sentence
        String[] tokens = sentence.split("\\s+");

        List<String> rephrasedTokens = new ArrayList<>();

        for (String token : tokens) {
            // Perform stemming to get the base form of the word
            WordnetStemmer stemmer = new WordnetStemmer(dict);
            List<String> stems = stemmer.findStems(token, POS.NOUN);

            if (!stems.isEmpty()) {
                // Use the first stem as the rephrased token
                rephrasedTokens.add(stems.get(0));
            } else {
                // Use the original token if no stem is found
                rephrasedTokens.add(token);
            }
        }

        // Join the rephrased tokens to form the rephrased sentence
        String rephrasedSentence = String.join(" ", rephrasedTokens);

        return rephrasedSentence;
    }

    public static void main(String[] args) {
        try {
            String wordNetPath = "/path/to/wordnet/dict";  // Replace with the actual path to WordNet dictionary
            Step2SentenceRephraser rephraser = new Step2SentenceRephraser(wordNetPath);

            String inputSentence = "The weather is very nice today.";
            String rephrasedSentence = rephraser.rephraseSentence(inputSentence);

            System.out.println("Original Sentence: " + inputSentence);
            System.out.println("Rephrased Sentence: " + rephrasedSentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
