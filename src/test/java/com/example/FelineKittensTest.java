package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FelineKittensTest {
    private final int kittensCountExpected;
    private final int kittensCountParameter;

    public FelineKittensTest(int kittensCountExpected, int kittensCountParameter) {
        this.kittensCountExpected = kittensCountExpected;
        this.kittensCountParameter = kittensCountParameter;
    }

    @Test
    public void withCountGetKittensTest(){
        Feline feline = new Feline();
        assertEquals(kittensCountExpected,feline.getKittens(kittensCountParameter));
    }
    @Parameterized.Parameters
    public static Object[][] getCount() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {10, 10},
                {Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
    }
}