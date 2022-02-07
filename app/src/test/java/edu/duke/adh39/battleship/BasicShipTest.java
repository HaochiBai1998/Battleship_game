package edu.duke.adh39.battleship;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BasicShipTest {
    @Test
    void test_hit_ship() {
        RectangleShip<Character> ship1
                = new RectangleShip<Character>(new Coordinate(1, 1), 's', '*');
        assertThrows(IllegalArgumentException.class,
                ()->ship1.checkCoordinateInThisShip(new Coordinate(0,0)));
        assertThrows(IllegalArgumentException.class,
                ()->ship1.checkCoordinateInThisShip(new Coordinate(2,2)));
        assertThrows(IllegalArgumentException.class,
                ()->ship1.checkCoordinateInThisShip(new Coordinate(4,1)));
        //check initial state
        assertFalse(ship1.wasHitAt(new Coordinate(1,1)));
        assertFalse(ship1.wasHitAt(new Coordinate(2,1)));
        assertFalse(ship1.wasHitAt(new Coordinate(3,1)));
        //record hit and check status
        ship1.recordHitAt(new Coordinate(1,1));
        assertThrows(IllegalArgumentException.class,
                ()->ship1.recordHitAt(new Coordinate(6,6)));
        assertTrue(ship1.wasHitAt(new Coordinate(1,1)));
        assertThrows(IllegalArgumentException.class,
                ()->ship1.wasHitAt(new Coordinate(6,6)));
        ship1.recordHitAt(new Coordinate(2,1));
        assertTrue(ship1.wasHitAt(new Coordinate(2,1)));
        assertFalse(ship1.isSunk());
        //hit whole ship
        ship1.recordHitAt(new Coordinate(3,1));
        assertTrue(ship1.isSunk());
        SimpleShipDisplayInfo<Character> shipDisplayInfo=new SimpleShipDisplayInfo<Character>('s','*');
    }
    @Test
    public void test_ship_name(){
        RectangleShip<Character> ship1
                = new RectangleShip<Character>(new Coordinate(1, 1), 's', '*');
        assertEquals(ship1.getName(),"testship");
    }
}
