package com.techlabs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    private StringUtil util;

    @BeforeEach
    void init(){
        util=new StringUtil();
    }

    @Test
    @DisplayName("Truncate 'A' in first two places")
    void testTruncateAInFirstTwoPlaces(){
        assertAll(
                ()->assertEquals("BC",util.truncateAInFirstTwoPlaces("AABC")),
                ()->assertEquals("BCA",util.truncateAInFirstTwoPlaces("BACA")),
                ()->assertEquals("BCD",util.truncateAInFirstTwoPlaces("ABCD")),
                ()->assertEquals("BC",util.truncateAInFirstTwoPlaces("ABC")),
                ()->assertEquals("BCDA", util.truncateAInFirstTwoPlaces("BCDA")),
                ()->assertEquals("",util.truncateAInFirstTwoPlaces("AA")),
                ()->assertEquals("B",util.truncateAInFirstTwoPlaces("AB")),
                ()->assertEquals("",util.truncateAInFirstTwoPlaces("A")),
                ()->assertEquals("",util.truncateAInFirstTwoPlaces("")),
                ()->assertEquals("BB",util.truncateAInFirstTwoPlaces("BB"))
        );
    }

    @Test
    @DisplayName("First and Last two characters are equal")
    void testFirstAndLastTwoCharactersAreEqual(){
        assertAll(
                ()->assertTrue(util.firstAndLastTwoCharactersAreEqual("ABAB")),
                ()->assertFalse(util.firstAndLastTwoCharactersAreEqual("ABBBA")),
                ()->assertTrue(util.firstAndLastTwoCharactersAreEqual("ABCDAB")),
                ()->assertFalse(util.firstAndLastTwoCharactersAreEqual("ABC")),
                ()->assertFalse(util.firstAndLastTwoCharactersAreEqual("AB")),
                ()->assertFalse(util.firstAndLastTwoCharactersAreEqual("A")),
                ()->assertFalse(util.firstAndLastTwoCharactersAreEqual(""))
        );
    }

}