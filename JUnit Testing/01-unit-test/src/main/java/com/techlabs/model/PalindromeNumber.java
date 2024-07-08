package com.techlabs.model;

public class PalindromeNumber {
    public int palindromeNumber(int number){
        int remainder;
        int reversed=0;

        while (number>0){
            remainder = number%10;
            reversed = reversed*10+remainder;
            number/=10;
        }
        return reversed;
    }
}
