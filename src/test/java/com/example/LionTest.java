package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void lionHaveMane() throws Exception {
        Lion lion = new Lion ("Самец",feline);
        boolean haveMane = lion.doesHaveMane();
        assertTrue("У самца должны быть грива",haveMane);
    }
    @Test
    public void lionDontHaveMane() throws Exception {
        Lion lion = new Lion ("Самка",feline);
        boolean haveMane = lion.doesHaveMane();
        assertFalse("У самки не должно быть гривы",haveMane);
    }
    @Test(expected = Exception.class)
    public void lionManeError() throws Exception {
        Lion lion = new Lion ("Хухундель",feline);
    }
    @Test
    public void getKittensTest() throws Exception {
        int kittensCount = 3;
        Lion lion = new Lion ("Самка",feline);
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals(kittensCount,lion.getKittens());
        Mockito.verify(feline,Mockito.times(1)).getKittens();
    }
    @Test
    public void getFoodTest() throws Exception {
        List<String> foodTypes = new ArrayList<>();
        Lion lion = new Lion ("Самка",feline);
        Mockito.when(feline.getFood(eq("Хищник"))).thenReturn(foodTypes);
        assertEquals(foodTypes,lion.getFood());
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }

}