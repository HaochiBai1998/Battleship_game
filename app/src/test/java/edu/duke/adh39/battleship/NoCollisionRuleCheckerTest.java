package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoCollisionRuleCheckerTest {
    @Test
    void test_collision(){

        V1ShipFactory v1ShipFactory=new V1ShipFactory();
        BattleShipBoard<Character> battleShipBoard=new BattleShipBoard<Character>(3,5);
        NoCollisionRuleChecker<Character> noCollisionRuleChecker=new NoCollisionRuleChecker<>(null);
        InBoundsRuleChecker<Character> inBoundsRuleChecker=new InBoundsRuleChecker<>(noCollisionRuleChecker);

        Placement placement1=new Placement(new Coordinate(1,1),'V');
        Ship<Character> ship1=v1ShipFactory.makeBattleship(placement1);
        assertNull(inBoundsRuleChecker.checkPlacement(ship1,battleShipBoard));
        battleShipBoard.tryAddShip(ship1);
        Placement placement2=new Placement(new Coordinate(1,2),'H');
        Ship<Character> ship2=v1ShipFactory.makeBattleship(placement2);
        assertNotNull(inBoundsRuleChecker.checkPlacement(ship2,battleShipBoard));
    }
}
