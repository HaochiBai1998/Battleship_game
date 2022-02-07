package edu.duke.adh39.battleship;
import java.nio.charset.CoderResult;
import java.util.HashSet;

public class RectangleShip<T> extends BasicShip<T>{
    final String name;
    /**
     * Get the name of this Ship, such as "submarine".
     * @return the name of this ship
     */
    public String getName(){
        return name;
    }
    static HashSet<Coordinate> makeCoords(Coordinate upperLeft, int width, int height) {
        HashSet<Coordinate> hashSet = new HashSet<Coordinate>();
        int row = upperLeft.getRow();
        int col = upperLeft.getColumn();
        for (int i = row; i < row + height; ++i) {
            for (int j = col; j < col + width; ++j) {
                hashSet.add(new Coordinate(i, j));
            }
        }
        return hashSet;
    }
    public RectangleShip(String name,Coordinate upperLeft, int width, int height,SimpleShipDisplayInfo<T> shipDisplayInfo) {
        super(makeCoords(upperLeft, width, height),shipDisplayInfo);
        this.name=name;
    }
    public RectangleShip(String name,Coordinate upperLeft, int width, int height, T data, T onHit) {
        this(name,upperLeft, width, height, new SimpleShipDisplayInfo<T>(data, onHit));
    }
    public RectangleShip(Coordinate upperLeft, T data, T onHit) {
        this("testship",upperLeft, 1, 3, data, onHit);
    }

}
