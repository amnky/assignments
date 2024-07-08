package com.techlabs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {
    @Test
    void palindromeTest(){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int expected = 12221;
        assertEquals(expected,palindromeNumber.palindromeNumber(12221));
    }

}