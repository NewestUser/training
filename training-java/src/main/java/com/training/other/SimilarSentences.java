package com.training.other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PROBLEM:
 * <p>
 * Write a an algorithm that given a sentence and an array of sentences will return the <tt>indexes</tt> of
 * the sentences that it is <tt>familiar</tt> to. The algorithm will be composed of two parts,
 * one for <tt>indexing</tt> the array of sentences {@link SimilarSentences#init(String[], Integer)}
 * and one for performing the <tt>search</tt> {@link SimilarSentences#findSecondImpl(String)}.
 * <p>
 * <p>
 * Two sentences are considered <tt>familiar</tt> if they have at least N common words. N is defined in the indexing phase.
 * <p>
 * <p>
 * During the <tt>indexing</tt> phase there are no time-based constraints.<p>
 * The algorithm should be able to do a fast <tt>search</tt>.<p>
 * No synchronization is required.<p>
 */
class SimilarSentences {

    private static Map<String, List<Integer>> INDEXED_SENTENCES = new HashMap<>();
    private static Integer THRESHOLD;

    /**
     * Index the text given as array of sentences.
     *
     * @param text      text to index.
     * @param threshold definition of similarity.
     */
    static void init(String[] text, Integer threshold) {

        THRESHOLD = threshold;

        for (int i = 0; i < text.length; i++) {
            String sentence = text[i];

            String[] words = sentence.split("\\s");
            for (String word : words) {

                List<Integer> wordFoundInSentence = INDEXED_SENTENCES.getOrDefault(word, new ArrayList<>());
                wordFoundInSentence.add(i);
                INDEXED_SENTENCES.put(word.toLowerCase(), wordFoundInSentence);
            }
        }
    }

    /**
     * Find the indexes of the sentences that were indexed in {@link SimilarSentences#init(String[], Integer)}
     * that are considered familiar to the given sentence.
     *
     * @param sentence the sentence that will be used to search for familiarities.
     * @return an int[] with the indexes of the familiar sentences.
     */
    static int[] findFirstImpl(String sentence) {

        List<Integer> occurrencesInSentences = new ArrayList<>();

        for (String word : sentence.split("\\s")) {

            List<Integer> sentenceIndexes = INDEXED_SENTENCES.get(word.toLowerCase());
            if (sentenceIndexes == null) {
                continue;
            }

            occurrencesInSentences.addAll(sentenceIndexes);
        }

        Map<Integer, Integer> sentenceToOccurrences = new HashMap<>();
        for (Integer sentenceIndex : occurrencesInSentences) {

            Integer occurrences = sentenceToOccurrences.getOrDefault(sentenceIndex, 0);
            occurrences++;
            sentenceToOccurrences.put(sentenceIndex, occurrences);
        }

        List<Integer> similarSentences = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sentenceToOccurrences.entrySet()) {

            Integer wordOccurrences = entry.getValue();

            if (wordOccurrences >= THRESHOLD) {
                Integer sentenceIndex = entry.getKey();

                similarSentences.add(sentenceIndex);
            }
        }

        return convertIntegers(similarSentences);
    }

    /**
     * Same as {@link SimilarSentences#findFirstImpl(String)}.
     *
     * @see SimilarSentences#findFirstImpl(String)
     */
    static int[] findSecondImpl(String sentence) {

        Map<Integer, Integer> sentenceToOccurrences = new HashMap<>();
        Set<Integer> similarSentences = new HashSet<>();

        for (String word : sentence.split("\\s")) {

            List<Integer> sentenceIndexes = INDEXED_SENTENCES.get(word.toLowerCase());
            if (sentenceIndexes == null) {
                continue;
            }

            for (Integer sentenceIndex : sentenceIndexes) {
                Integer occurrences = sentenceToOccurrences.getOrDefault(sentenceIndex, 0);
                occurrences++;
                sentenceToOccurrences.put(sentenceIndex, occurrences);

                if (occurrences >= THRESHOLD) {
                    similarSentences.add(sentenceIndex);
                }
            }
        }

        return convertIntegers(similarSentences);
    }

    private static int[] convertIntegers(Collection<Integer> integers) {
        int[] ret = new int[integers.size()];

        Iterator<Integer> iterator = integers.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            ret[i++] = iterator.next();
        }

        return ret;
    }
}
