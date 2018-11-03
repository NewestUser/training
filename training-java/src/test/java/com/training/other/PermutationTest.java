package com.training.other;

import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class PermutationTest {

    @Test
    public void generateUniquePermutations() {

        assertThat(Permutation.uniquePermutation('A', 'B'), containsInAnyOrder(
                "AB", "BA"
        ));

        assertThat(Permutation.uniquePermutation('A', 'B', 'C'), containsInAnyOrder(
                "ABC", "ACB", "BAC", "BCA", "CBA", "CAB"
        ));

        assertThat(Permutation.uniquePermutation('A', 'B', 'C', 'D'), containsInAnyOrder(
                "ABCD", "BACD", "CABD", "ACBD", "BCAD", "CBAD", "CBDA", "BCDA",
                "DCBA", "CDBA", "BDCA", "DBCA", "DACB", "ADCB", "CDAB", "DCAB",
                "ACDB", "CADB", "BADC", "ABDC", "DBAC", "BDAC", "ADBC", "DABC"
        ));
    }
}