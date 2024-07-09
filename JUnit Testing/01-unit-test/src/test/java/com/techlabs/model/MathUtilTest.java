package com.techlabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class MathUtilTest {

    private MathUtil util;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Initialized before object creation by compiler");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Cleaned up all the held up resources after all tests");
//        After all tests compiler disposes of the object so need to make afterAll() static
    }

    @BeforeEach
    void init(){
        util=new MathUtil();
    }

    @AfterEach
    void cleanUp(){
        System.out.println("After each- cleans up resources that should be cleared after every test");
    }

    @Test
    void addtest() {

//        int expected = 4;
        assertAll(
                ()->assertEquals(10,util.add(6,4)),
                ()->assertEquals(20,util.add(18,2)),
                ()->assertTrue(util.add(2,6)==8)
        );
//        assertEquals(expected, util.add(2, 2));
    }

    @Test
    @Tag("Demo")
    void dividetest(){

        int expected = 1;
        assertEquals(expected, util.divide(3,3));
    }

    @Test
    @Tag("Demo")
    void testDivide_check_ArithmeticException() {

        assertThrows(ArithmeticException.class, ()->{
            util.divide(4, 0);
        });
    }

    @Test
    @DisplayName("Compare result array after sorting")
    void testSortArray() {

        int[] arr = { 10, 40, 30, 2, 1 };
        int[] expected = { 1, 2, 10, 30, 40 };
        assertArrayEquals(expected, util.sortArray(arr));
    }

    @Test
    @Disabled
    void testFail(){
        fail("This test failed");
    }

}