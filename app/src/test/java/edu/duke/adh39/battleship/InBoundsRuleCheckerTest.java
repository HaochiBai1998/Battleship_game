package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InBoundsRuleCheckerTest {
    @Test
    void test_in_bounds_rule(){
        V1ShipFactory v1ShipFactory=new V1ShipFactory();
        BattleShipBoard<Character> battleShipBoard=new BattleShipBoard<Character>(3,5);
        Placement placement=new Placement(new Coordinate(1,1),'V');
        Ship<Character> submarine=v1ShipFactory.makeSubmarine(placement);
        Placement placement2=new Placement(new Coordinate(1,0),'H');
        Ship<Character> destroyer=v1ShipFactory.makeDestroyer(placement2);
        Placement placement3=new Placement(new Coordinate(2,2),'H');
        Ship<Character> battleship=v1ShipFactory.makeBattleship(placement3);
        Placement placement4=new Placement(new Coordinate(2,4),'V');
        Ship<Character> carrier=v1ShipFactory.makeCarrier(placement4);
        InBoundsRuleChecker<Character> inBoundsRuleChecker=new InBoundsRuleChecker<>(null);
        assertNull(inBoundsRuleChecker.checkPlacement(submarine,battleShipBoard));
        assertNull(inBoundsRuleChecker.checkPlacement(destroyer,battleShipBoard));
        assertNotNull(inBoundsRuleChecker.checkPlacement(battleship,battleShipBoard));
        assertNotNull(inBoundsRuleChecker.checkPlacement(carrier,battleShipBoard));


    }
}
