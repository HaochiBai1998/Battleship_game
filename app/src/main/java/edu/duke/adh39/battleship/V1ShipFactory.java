package edu.duke.adh39.battleship;
import java.lang.*;
import java.io.*;
public class V1ShipFactory implements AbstractShipFactory<Character>{
    /**
     * create a new character ship
     *
     * @param where specifies the location and orientation of the ship to make
     * @param w specifies ship width
     * @param h specifies ship height
     * @param letter specifies the data of this ship
     * @param name specifies the name of this ship class
     * @return a Rectangle ship created
     *
     * */
    protected Ship<Character> createShip(Placement where, int w, int h, char letter, String name){
        return new RectangleShip<Character>(name,where.getWhere(),w,h, letter,'*');
    }
    /**
     * Make a submarine.
     *
     * @param where specifies the location and orientation of the ship to make
     * @return the Ship created for the submarine.
     */
    @Override
    public Ship<Character> makeSubmarine(Placement where) {
        if(where.getOrientation()=='V') {
            return createShip(where, 1, 2, 's', "Submarine");
        }
        else{
            return createShip(where, 2, 1, 's', "Submarine");
        }
    }
    /**
     * Make a battleship.
     *
     * @param where specifies the location and orientation of the ship to make
     * @return the Ship created for the battleship.
     */
    @Override
    public Ship<Character> makeBattleship(Placement where) {
        if(where.getOrientation()=='V') {
            return createShip(where, 1, 4, 'b', "Battleship");
        }
        else{
            return createShip(where, 4, 1, 'b', "Battleship");
        }
    }

    /**
     * Make a carrier.
     *
     * @param where specifies the location and orientation of the ship to make
     * @return the Ship created for the carrier.
     */
    @Override
    public Ship<Character> makeCarrier(Placement where) {
        if(where.getOrientation()=='V') {
            return createShip(where, 1, 6, 'c', "Carrier");
        }
        else{
            return createShip(where, 6, 1, 'c', "Carrier");
        }
    }

    /**
     * Make a destroyer.
     *
     * @param where specifies the location and orientation of the ship to make
     * @return the Ship created for the destroyer.
     */

    @Override
    public Ship<Character> makeDestroyer(Placement where) {
        if(where.getOrientation()=='V') {
            return createShip(where, 1, 3, 'd', "Destroyer");
        }
        else{
            return createShip(where, 3, 1, 'd', "Destroyer");
        }
    }
}
