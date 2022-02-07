package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlacementTest {
    @Test
    public void test_where_and_orientation() {
        Coordinate c1 = new Coordinate(10, 20);
        Placement p1=new Placement(c1,'H');
        assertEquals('H', p1.getOrientation());
        assertEquals(c1, p1.getWhere());
    }

    @Test
    public void test_equals() {
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 2);
        Coordinate c3 = new Coordinate(1, 3);
        Coordinate c4 = new Coordinate(3, 2);
        Placement p1=new Placement(c1,'H');
        Placement p2=new Placement(c1,'V');
        Placement p3=new Placement(c2,'H');
        Placement p4=new Placement(c3,'H');
        Placement p5=new Placement(c4,'H');
        assertEquals(p1, p1);   //equals should be reflexsive
        assertEquals(p1, p3);   //different objects bu same contents
        assertNotEquals(p1, p2);  //different contents
        assertNotEquals(p1, p4);
        assertNotEquals(p1, p5);
        assertNotEquals(p2, "((1, 2), V)"); //different types
    }

    @Test
    public void test_hashCode() {
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 2);
        Coordinate c3 = new Coordinate(0, 3);
        Placement p1=new Placement(c1,'H');
        Placement p2=new Placement(c1,'V');
        Placement p3=new Placement(c2,'H');
        Placement p4=new Placement(c3,'H');
        assertEquals(p1.hashCode(), p3.hashCode());
        assertNotEquals(p2.hashCode(), p3.hashCode());
        assertNotEquals(p2.hashCode(), p4.hashCode());
    }
    @Test
    void test_string_constructor_valid_cases() {
        Placement p1 = new Placement("B3h");
        assertEquals(1, p1.getWhere().getRow());
        assertEquals(3, p1.getWhere().getColumn());
        assertEquals('H', p1.getOrientation());
        Placement p2 = new Placement("D5V");
        assertEquals(3, p2.getWhere().getRow());
        assertEquals(5, p2.getWhere().getColumn());
        assertEquals('V', p2.getOrientation());
        Placement p3 = new Placement("A9H");
        assertEquals(0, p3.getWhere().getRow());
        assertEquals(9, p3.getWhere().getColumn());
        assertEquals('H', p3.getOrientation());
        Placement p4 = new Placement("Z0v");
        assertEquals(25, p4.getWhere().getRow());
        assertEquals(0, p4.getWhere().getColumn());
        assertEquals('V', p4.getOrientation());

    }
    @Test
    public void test_string_constructor_error_cases() {
        assertThrows(IllegalArgumentException.class, () -> new Placement("A0V1"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("AAH"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("@0V"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("[0H"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A/V"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A:H"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A12"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A1D"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A1:"));
        assertThrows(IllegalArgumentException.class, () -> new Placement("A1"));
    }
}
