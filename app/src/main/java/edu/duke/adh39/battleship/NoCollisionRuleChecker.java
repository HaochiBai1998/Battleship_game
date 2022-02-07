package edu.duke.adh39.battleship;

public class NoCollisionRuleChecker<T> extends PlacementRuleChecker<T>{
    protected NoCollisionRuleChecker(PlacementRuleChecker<T> next) {
        super(next);
    }
    @Override
    protected String checkMyRule(Ship<T> theShip, Board<T> theBoard) {
        Iterable<Coordinate> coords=theShip.getCoordinates();
        for(Coordinate c: coords){
            if(theBoard.whatIsAt(c)!=null){
                return "That placement is invalid: it meets other ship";
            }
        }
        return null;
    }
}
