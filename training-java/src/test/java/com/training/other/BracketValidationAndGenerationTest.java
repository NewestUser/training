package com.training.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketValidationAndGenerationTest {

    @Test
    public void validBracketSyntax() {
        List<String> validBracesSyntax = new ArrayList<>() {{
            add("{}");
            add("{}[]");
            add("{}[]()");
            add("{}[]{{}}");
            add("{[]}");
        }};

        for (String syntax : validBracesSyntax) {
            assertTrue(BracketValidationAndGeneration.validateSyntax(syntax));
        }
    }

    @Test
    public void invalidBracketSyntax() {
        List<String> validBracesSyntax = new ArrayList<>() {{
            add("{");
            add("}{");
            add("{]");
            add("{(}");
            add("[{]}[]");
            add("][{()");
        }};

        for (String syntax : validBracesSyntax) {
            assertFalse(BracketValidationAndGeneration.validateSyntax(syntax));
        }
    }
}