package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList<Car> carList;
    @Before
    public void setUp() throws Exception{
        carList = new CarArrayList<>();
        for(int i=0;i<100;i++){
            carList.add(new Car("BMX" + i, i));
        }
    }

    @org.junit.Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100,carList.size());
    }

    @org.junit.Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        assertTrue(carList.removeAt(5));
        assertEquals(99,carList.size());

    }

    @org.junit.Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        Car car = new Car("Audi",16);
        carList.add(car);
        assertEquals(101,carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100,carList.size());

    }

    @org.junit.Test
    public void whenNinExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Audi",16);
        assertFalse(carList.remove(car));
        assertEquals(100,carList.size());
    }

    @org.junit.Test
    public void whenListClearedThenSizeMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());

    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class )
    public void whenIndexOutOfBoundsThenThrownException(){
        carList.get(100);
    }

    @org.junit.Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("BMX0", car.getBrand());
    }

    @org.junit.Test
    public void insertIntoMiddle(){
        Car car = new Car("BMW",1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @org.junit.Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW",1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @org.junit.Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW",1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}