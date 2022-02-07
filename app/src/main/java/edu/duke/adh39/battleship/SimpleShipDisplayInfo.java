package edu.duke.adh39.battleship;


public class SimpleShipDisplayInfo<T> implements ShipDisplayInfo<T> {
    protected T myData;
    protected T onHit;

    public SimpleShipDisplayInfo(T myData, T onHit) {
        this.myData = myData;
        this.onHit = onHit;
    }

    @Override
    public T getInfo(Coordinate where, boolean hit) {
        if(hit){
            return onHit;
        }
        return myData;
    }
}