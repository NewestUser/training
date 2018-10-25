package com.training.other;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SimilarSentencesTest {

    @Test
    public void findSimilarSentences() {

        String[] shakespeare = new String[]{
                "This is a small cat",  // index[0]
                "Rhinos are mammals",   // index[1]
                "The lion is a cat",    // index[2]
        };

        SimilarSentences.init(shakespeare, 3);

        int[] expected = new int[]{0, 2};

        String sentence = "An elephant is not a Cat";

        assertArrayEquals(expected, SimilarSentences.findFirstImpl(sentence));
        assertArrayEquals(expected, SimilarSentences.findSecondImpl(sentence));
    }

    @Test
    public void compareTimeComplexity() {

        String[] shakespeare = new String[]{
                "This is a small cat",
                "Rhinos are mammals",
                "The lion is a cat",
        };

        SimilarSentences.init(shakespeare, 3);

        StringBuilder stressSentence = new StringBuilder(100_000);

        for (int i = 0; i < 1_000_000; i++) {
            stressSentence.append("a\\s");
        }

        String sentence = stressSentence.toString();

        long firstStart = System.currentTimeMillis();
        SimilarSentences.findFirstImpl(sentence);
        long firstEnd = System.currentTimeMillis();

        long secondStart = System.currentTimeMillis();
        SimilarSentences.findSecondImpl(sentence);
        long secondEnd = System.currentTimeMillis();

        long firstDuration = firstEnd - firstStart;
        long secondDuration = secondEnd - secondStart;

        assertTrue(secondDuration < firstDuration);
    }
}