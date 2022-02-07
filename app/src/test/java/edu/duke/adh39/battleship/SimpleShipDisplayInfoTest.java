package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleShipDisplayInfoTest {
    @Test
    public void test_simpleShipDisplayInfo(){
        SimpleShipDisplayInfo<Character> ShipDisplay=new SimpleShipDisplayInfo<Character>('s','*');
        assertEquals('*',ShipDisplay.getInfo(new Coordinate(1,1),true));
        assertEquals('s',ShipDisplay.getInfo(new Coordinate(1,1),false));
    }
}
