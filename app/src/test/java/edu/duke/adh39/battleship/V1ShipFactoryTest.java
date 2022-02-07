package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class V1ShipFactoryTest {

    public ArrayList<Coordinate> getCoordinates(Coordinate upperLeft,int width,int height){
        ArrayList<Coordinate> arrayList=new ArrayList<>();
        int y=upperLeft.getRow();
        int x=upperLeft.getColumn();
        for(int i=y;i<y+height;++i){
            for(int j=x; j<x+width;++j){
                arrayList.add(new Coordinate(i,j));
            }
        }
        return arrayList;
    }
    private void checkShip(Ship<Character> testShip, String expectedName,
                           char expectedLetter, ArrayList<Coordinate> expectedLocs){
        assertEquals(testShip.getName(),expectedName);

        for(Coordinate c:expectedLocs){
            assertEquals(testShip.getDisplayInfoAt(c),expectedLetter);
        }
    }
    @Test
    public void test_make_different_ship(){
        V1ShipFactory shipFactory=new V1ShipFactory();
        Ship<Character> s_ship_v=shipFactory.makeSubmarine(
                new Placement(new Coordinate(1,1),'V'));
        ArrayList<Coordinate> arrayList_s_ship_v=getCoordinates(new Coordinate(1,1),1,2);
        checkShip(s_ship_v,"Submarine",'s',arrayList_s_ship_v);


        Ship<Character> s_ship_h=shipFactory.makeSubmarine(
                new Placement(new Coordinate(1,1),'H'));
        ArrayList<Coordinate> arrayList_s_ship_h=getCoordinates(new Coordinate(1,1),2,1);
        checkShip(s_ship_h,"Submarine",'s',arrayList_s_ship_h);
//
//
        Ship<Character> b_ship_v=shipFactory.makeBattleship(
                new Placement(new Coordinate(1,1),'V'));
        ArrayList<Coordinate> arrayList_b_ship_v=getCoordinates(new Coordinate(1,1),1,4);
        checkShip(b_ship_v,"Battleship",'b',arrayList_b_ship_v);

        Ship<Character> d_ship_v=shipFactory.makeDestroyer(
                new Placement(new Coordinate(1,1),'V'));
        ArrayList<Coordinate> arrayList_d_ship_v=getCoordinates(new Coordinate(1,1),1,3);
        checkShip(d_ship_v,"Destroyer",'d',arrayList_d_ship_v);

        Ship<Character> c_ship_v=shipFactory.makeCarrier(
                new Placement(new Coordinate(1,1),'V'));
        ArrayList<Coordinate> arrayList_c_ship_v=getCoordinates(new Coordinate(1,1),1,6);
        checkShip(c_ship_v,"Carrier",'c',arrayList_c_ship_v);


    }

}
