
package edu.duke.adh39.battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoardTextViewTest {
    private void emptyBoardHelper(int w, int h, String expectedHeader, String body){
        Board<Character> b1 = new BattleShipBoard<Character>(w, h);
        BoardTextView view = new BoardTextView(b1);
        assertEquals(expectedHeader, view.makeHeader());
        String expected = expectedHeader + body + expectedHeader;
        assertEquals(expected, view.displayMyOwnBoard());
    }
    @Test
    public void test_invalid_board_size() {
        Board<Character> wideBoard = new BattleShipBoard<Character>(11,20);
        Board<Character> tallBoard = new BattleShipBoard<Character>(10,27);
        //you should write two assertThrows here
        assertThrows(IllegalArgumentException.class,()->new BoardTextView(wideBoard));
        assertThrows(IllegalArgumentException.class,()->new BoardTextView(tallBoard));
    }
    @Test
    public void test_display_empty_2by2() {
        emptyBoardHelper(2,2,"  0|1\n",
                "A  |  A\n"+ "B  |  B\n");
    }
    @Test
    public void test_display_empty_3by2() {
        emptyBoardHelper(3,2,"  0|1|2\n",
                "A  | |  A\n"+ "B  | |  B\n");
    }
    @Test
    public void test_display_empty_3by5() {
        emptyBoardHelper(3,5,"  0|1|2\n",
                "A  | |  A\n"+ "B  | |  B\n"+ "C  | |  C\n"+ "D  | |  D\n"+ "E  | |  E\n");
    }
    @Test
    public void test_display_ships_3by4() {
        //build a 3x4 board
        Board<Character> b = new BattleShipBoard<Character>(3, 4);
        b.tryAddShip(new RectangleShip<Character>(new Coordinate(1,1),'s','*'));
        //check display after add to (1,1)
        BoardTextView view = new BoardTextView(b);
        assertTrue(view.displayMyOwnBoard().equals(
                view.makeHeader()+
                        "A  | |  A\n"+
                        "B  |s|  B\n"+
                        "C  |s|  C\n"+
                        "D  |s|  D\n"+view.makeHeader()));
        //check display after add to (3,2)
//        b.tryAddShip(new RectangleShip<Character>(new Coordinate(3,2),'s','*'));
//        view = new BoardTextView(b);
//        assertTrue(view.displayMyOwnBoard().equals(
//                view.makeHeader()+
//                        "A  | |  A\n"+
//                        "B  |s|  B\n"+
//                        "C  | |  C\n"+
//                        "D  | |s D\n"+view.makeHeader()));
//        //check display after add to (0,0)
//        b.tryAddShip(new RectangleShip<Character>(new Coordinate(0,0),'s','*'));
//        view = new BoardTextView(b);
//        assertTrue(view.displayMyOwnBoard().equals(
//                view.makeHeader()+
//                        "A s| |  A\n"+
//                        "B  |s|  B\n"+
//                        "C  | |  C\n"+
//                        "D  | |s D\n"+view.makeHeader()));
//        //check display after add to (0,1)
//        b.tryAddShip(new RectangleShip<Character>(new Coordinate(0,1),'s','*'));
//        view = new BoardTextView(b);
//        assertTrue(view.displayMyOwnBoard().equals(
//                view.makeHeader()+
//                        "A s|s|  A\n"+
//                        "B  |s|  B\n"+
//                        "C  | |  C\n"+
//                        "D  | |s D\n"+view.makeHeader()));
    }
}