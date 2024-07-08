package com.techlabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

    @Test
    void addtest() {
        MathUtil util = new MathUtil();
        int expected = 4;
        assertEquals(expected, util.add(2, 2));
    }

    @Test
    void dividetest(){
        MathUtil util = new MathUtil();
        int expected = 1;
        assertEquals(expected, util.divide(3,3));
    }

    @Test
    void testDivide_check_ArithmeticException() {
        MathUtil util = new MathUtil();

        assertThrows(ArithmeticException.class, ()->{
            util.divide(4, 0);
        });
    }

    @Test
    void testSortArray() {
        MathUtil util = new MathUtil();
        int[] arr = { 10, 40, 30, 2, 1 };
        int[] expected = { 1, 2, 10, 30, 40 };
        assertArrayEquals(expected, util.sortArray(arr));
    }

}