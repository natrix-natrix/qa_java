package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class FelineTest {
    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        assertThat(feline.eatMeat(), containsInAnyOrder("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void getFamilyTest(){
        Feline feline = new Feline();
        assertEquals("Кошачьи",feline.getFamily());
    }
    @Test
    public void getKittensTest(){
        Feline feline = new Feline();
        assertEquals(1,feline.getKittens());
    }
}