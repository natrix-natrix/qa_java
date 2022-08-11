package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundTest(){
        Cat cat = new Cat (feline);
        assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodTypes = new ArrayList<>();
        Cat cat = new Cat (feline);
        Mockito.when(feline.eatMeat()).thenReturn(foodTypes);
        assertEquals(foodTypes,cat.getFood());
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }

}