package edu.duke.adh39.battleship;
import java.lang.Character;
import java.util.*;

/**
 * Rectangle BasicShip, a implement of Ship<T>
 *
 */

public abstract class BasicShip<T> implements Ship<T> {
    protected HashMap<Coordinate, Boolean> myPieces;
    protected ShipDisplayInfo<T> myDisplayInfo;
    protected void checkCoordinateInThisShip(Coordinate c){
        if(!myPieces.containsKey(c)){
            throw new IllegalArgumentException("Coordinate ("+
                    c.getRow() +","+c.getColumn()+") is not in this ship\n");
        }
    }

    /**
     * Get all of the Coordinates that this Ship occupies.
     * @return An Iterable with the coordinates that this Ship occupies
     */
    public Iterable<Coordinate> getCoordinates() {
        return myPieces.keySet();
    }
    /**
     * check whether this ship occupy a particular coordinate
     *
     * @field where - a coordinate to check
     */
    @Override
    public boolean occupiesCoordinates(Coordinate where) {
        return myPieces.containsKey(where);
    }
    @Override
    public boolean isSunk() {
        for(Map.Entry<Coordinate,Boolean> mapEntry:myPieces.entrySet()){
            if(!mapEntry.getValue()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void recordHitAt(Coordinate where) {
        checkCoordinateInThisShip(where);
        myPieces.put(where,true);
    }

    @Override
    public boolean wasHitAt(Coordinate where) {
        checkCoordinateInThisShip(where);
        return myPieces.get(where);
    }

    @Override
    public T getDisplayInfoAt(Coordinate where) {
        //look up the hit status of this coordinate
        checkCoordinateInThisShip(where);
        return myDisplayInfo.getInfo(where, myPieces.get(where));
    }
    public BasicShip(Iterable<Coordinate> where, ShipDisplayInfo<T> myDisplayInfo) {
        this.myDisplayInfo=myDisplayInfo;
        myPieces = new HashMap<Coordinate, Boolean>();
        for(Coordinate c:where){
            myPieces.put(c,false);
        }
    }
//    public BasicShip(Coordinate c, ShipDisplayInfo<T> myDisplayInfo) {
//        this.myDisplayInfo=myDisplayInfo;
//        myPieces = new HashMap<Coordinate, Boolean>();
//        myPieces.put(c, false);
//    }
}
