package edu.duke.adh39.battleship;

import java.io.*;
import java.io.InputStreamReader;

public class App {
    protected TextPlayer player1;
    protected TextPlayer player2;
    /**
     * App Class provides a interface for userInput & Output
     *
     * @field theBoard - The user's own board
     * @field inputSource - Reader for data Input
     * @field out - Stream for data output
     */
    public App(TextPlayer player1, TextPlayer player2) {
        this.player1=player1;
        this.player2=player2;
    }
    public void doPlacementPhase() throws IOException {
        player1.doPlacementPhase();
        player2.doPlacementPhase();
    }

    public static void main(String[] args) throws IOException{
        Board<Character> b1 = new BattleShipBoard<Character>(10, 20);
        Board<Character> b2 = new BattleShipBoard<Character>(10, 20);
        BoardTextView view1=new BoardTextView(b1);
        BoardTextView view2=new BoardTextView(b2);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        V1ShipFactory factory = new V1ShipFactory();
        TextPlayer p1 = new TextPlayer("A", b1, input, System.out, factory, view1);
        TextPlayer p2 = new TextPlayer("B", b2, input, System.out, factory, view2);
        App app=new App(p1,p2);
        app.doPlacementPhase();
    }
}
