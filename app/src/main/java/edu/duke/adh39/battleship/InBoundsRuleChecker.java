package edu.duke.adh39.battleship;

public class InBoundsRuleChecker<T> extends PlacementRuleChecker<T>{
    protected InBoundsRuleChecker(PlacementRuleChecker<T> next) {
        super(next);
    }
    @Override
    protected String checkMyRule(Ship<T> theShip, Board<T> theBoard) {
        Iterable<Coordinate> coords=theShip.getCoordinates();
        for(Coordinate c:coords){
            int col=c.getColumn();
            int row=c.getRow();
            if(col>=theBoard.getWidth()||col<0||row>= theBoard.getHeight()||row<0){
                return "That placement is invalid: it does not have the correct format.";
            }
        }
        return null;
    }
}
