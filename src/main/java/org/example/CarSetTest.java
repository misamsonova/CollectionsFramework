package org.example;

import org.junit.Before;

import static org.junit.Assert.*;

public class CarSetTest {

    private CarSet<Car> carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet<>();
        for(int i=0;i<100;i++){
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @org.junit.Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1(){
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW",10)));
        assertFalse(carSet.add(new Car("BMW",10)));
        assertFalse(carSet.add(new Car("BMW",10)));
        assertEquals(101, carSet.size());
    }

    @org.junit.Test
    public void whenSetClearedThenSize0(){
        carSet.clear();
        assertEquals(0,carSet.size());
    }

    @org.junit.Test
    public void whenElementRemovedThenSizeDecreased(){
        assertTrue(carSet.remove(new Car("Brand30",30)));
        assertEquals(99,carSet.size());
        assertFalse(carSet.remove(new Car("Brand30",30)));
        assertEquals(99,carSet.size());

    }
}