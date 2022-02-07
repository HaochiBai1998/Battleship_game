package edu.duke.adh39.battleship;

public interface Board<T>{
    public int getWidth();

    public int getHeight();
    public String tryAddShip(Ship<T> toAdd);
    public T whatIsAt(Coordinate where);

}