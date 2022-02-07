package edu.duke.adh39.battleship;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleShipTest {
    @Test
    public void test_rectangleShip() {
        RectangleShip<Character> rectangleShip=
                new RectangleShip<Character>(new Coordinate(1,2),'s','*');
        assertEquals(rectangleShip.getName(),"testship");
        assertTrue(rectangleShip.occupiesCoordinates(new Coordinate(1,2)));
        assertTrue(rectangleShip.occupiesCoordinates(new Coordinate(2,2)));
        assertTrue(rectangleShip.occupiesCoordinates(new Coordinate(3,2)));
        assertFalse(rectangleShip.occupiesCoordinates(new Coordinate(3,3)));
        assertFalse(rectangleShip.occupiesCoordinates(new Coordinate(2,3)));
    }

}
