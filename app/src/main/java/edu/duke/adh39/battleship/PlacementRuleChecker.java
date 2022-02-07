package edu.duke.adh39.battleship;

public abstract class PlacementRuleChecker<T> {
    private final PlacementRuleChecker<T> next;
    protected abstract String checkMyRule(Ship<T> theShip, Board<T> theBoard);
    protected PlacementRuleChecker(PlacementRuleChecker<T> next) {
        this.next = next;
    }
    //more stuff
    public String checkPlacement (Ship<T> theShip, Board<T> theBoard) {
        //if we fail our own rule: stop the placement is not legal
        String str=checkMyRule(theShip, theBoard);
        if (str!=null) {
            return str;
        }
        //otherwise, ask the rest of the chain.
        if (next != null) {
            return next.checkPlacement(theShip, theBoard);
        }
        //if there are no more rules, then the placement is legal
        return null;
    }
}