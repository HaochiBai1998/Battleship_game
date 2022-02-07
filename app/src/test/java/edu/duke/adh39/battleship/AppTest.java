package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class AppTest {
//
//    @Disabled
//    @Test
//    @ResourceLock(value = Resources.SYSTEM_OUT, mode = ResourceAccessMode.READ_WRITE)
//    void test_main() throws IOException {
//        ;
//    }
//}
//    @Test
//    void test_read_placement() throws IOException{
//        StringReader sr = new StringReader("B2V\nC8H\na4v\n");
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(bytes, true);
//        Board<Character> b = new BattleShipBoard<Character>(10, 20);
//        App app = new App(b, sr, ps);
//
//
//        String prompt = "Please enter a location for a ship:";
//        Placement[] expected = new Placement[3];
//        expected[0] = new Placement(new Coordinate(1, 2), 'V');
//        expected[1] = new Placement(new Coordinate(2, 8), 'H');
//        expected[2] = new Placement(new Coordinate(0, 4), 'V');
//
//
//        for (int i = 0; i < expected.length; i++) {
//            Placement p = app.readPlacement(prompt);
//            assertEquals(p, expected[i]); //did we get the right Placement back
//            //assertEquals(prompt+"\n", bytes.toString()); //should have printed prompt and newline
//            bytes.reset(); //clear out bytes for next time around
//        }
//    }
//}
