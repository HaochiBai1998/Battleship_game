package edu.duke.adh39.battleship;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;

public class TextPlayer {
    final Board<Character> theBoard;
    final BoardTextView view;
    final BufferedReader inputReader;
    final PrintStream out;
    final String name;
    final V1ShipFactory v1ShipFactory;

    final ArrayList<String> shipsToPlace;
    final HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns;


    protected HashMap<String, Function<Placement, Ship<Character>>> setupShipCreationMap(){
        V1ShipFactory shipFactory=new V1ShipFactory();
        HashMap<String, Function<Placement, Ship<Character>>> shipCreationFns=
                new HashMap<String, Function<Placement, Ship<Character>>>();
        shipCreationFns.put("Submarine", (p) -> shipFactory.makeSubmarine(p));
        shipCreationFns.put("Destroyer", (p) -> shipFactory.makeDestroyer(p));
        shipCreationFns.put("Carrier", (p) -> shipFactory.makeCarrier(p));
        shipCreationFns.put("Battleship", (p) -> shipFactory.makeBattleship(p));
        return shipCreationFns;
    }

    protected ArrayList<String>  setupShipCreationList(){
        ArrayList<String> shipsToPlace=new ArrayList<>();
        shipsToPlace.addAll(Collections.nCopies(2, "Submarine"));
        shipsToPlace.addAll(Collections.nCopies(3, "Destroyer"));
        shipsToPlace.addAll(Collections.nCopies(3, "Battleship"));
        shipsToPlace.addAll(Collections.nCopies(2, "Carrier"));
        return shipsToPlace;
    }
    /**
     * print prompt to out and read a line from inputReader
     *
     * @field prompt - String to print to out
     */
    public Placement readPlacement(String prompt) throws IOException {
        out.println(prompt);
        String s = inputReader.readLine();
        if(s==null){
            throw new IllegalArgumentException("Invalid read a empty line\n");
        }
        return new Placement(s);
    }
    /**
     * read a line from inputReader and add a ship into board if its valid
     */
    public String printInsMsg(){
        StringBuilder ans=new StringBuilder();
        ans.append("--------------------------------------------------------------------------------\n" +
                "Player "+name+": you are going to place the following ships (which are all\n" +
                "rectangular). For each ship, type the coordinate of the upper left\n" +
                "side of the ship, followed by either H (for horizontal) or V (for\n" +
                "vertical).  For example M4H would place a ship horzontally starting\n" +
                "at M4 and going to the right.  You have\n" +
                "\n" +
                "2 \"Submarines\" ships that are 1x2 \n" +
                "3 \"Destroyers\" that are 1x3\n" +
                "3 \"Battleships\" that are 1x4\n" +
                "2 \"Carriers\" that are 1x6\n" +
                "--------------------------------------------------------------------------------\n");
        return ans.toString();
    }
    public void doPlacementPhase() throws IOException{
        view.displayMyOwnBoard();
        out.println(printInsMsg());
        this.doOnePlacement();
    }

    public void doOnePlacement() throws IOException {
        V1ShipFactory shipFactory=new V1ShipFactory();
        Ship<Character> rectangle_ship;
        String s = inputReader.readLine();
        for(String str:shipsToPlace){
            if(s.equals(str)) {
                Placement p = readPlacement("Player " + name + " where do you want to place a " + s + "?");
                rectangle_ship = shipCreationFns.get(str).apply(p);
                String addProblem=theBoard.tryAddShip(rectangle_ship);
                if(addProblem!=null){
                    throw new IllegalArgumentException(addProblem);
                }
                out.println(view.displayMyOwnBoard());
                return;
            }
        }
    }
    public TextPlayer(String name, Board<Character> theBoard, BufferedReader inputReader,
                      PrintStream out, V1ShipFactory v1ShipFactory, BoardTextView view) {
        this.v1ShipFactory=v1ShipFactory;
        this.name=name;
        this.theBoard = theBoard;
        this.inputReader = inputReader;
        this.out = out;
        this.view=view;
        this.shipCreationFns=setupShipCreationMap();
        this.shipsToPlace=setupShipCreationList();
    }
}
