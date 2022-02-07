package edu.duke.adh39.battleship;

import java.util.Locale;

public class Coordinate {
    private final int row;
    private final int column;
    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }
    public Coordinate(int row,int column) {
        this.column = column;
        this.row=row;
    }
    public Coordinate(String descr){
        if(descr.length()!=2){
            throw new IllegalArgumentException("description should be length of two but is:"+descr.length()+"\n");
        }
        descr=descr.toUpperCase();
        char c0=descr.charAt(0);
        char c1=descr.charAt(1);
        if(c0<'A'||c0>'Z'){
            throw new IllegalArgumentException("the first letter should be a character but:"+c0+"\n");
        }
        if(c1<'0'||c1>'9'){
            throw new IllegalArgumentException("the second letter should be a number but:"+c1+"\n");
        }
        this.row=c0-'A';
        this.column=c1-'0';
    }
    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(getClass())) {
            Coordinate c = (Coordinate) o;
            return row == c.row && column == c.column;
        }
        return false;
    }
    @Override
    public String toString() {
        return "("+row+", " + column+")";
    }
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
