package edu.duke.adh39.battleship;

public class Placement {
    final Coordinate where;
    final char orientation;

    public char getOrientation() {
        return orientation;
    }
    public Coordinate getWhere() {
        return where;
    }
    public Placement(Coordinate where, char orientation) {
        this.where = where;
        this.orientation=orientation;
    }
    public Placement(String descr) {
        if(descr.length()!=3){
            throw new IllegalArgumentException("description should be length of three but is:"+descr.length()+"\n");
        }
        descr=descr.toUpperCase();
        Coordinate c=new Coordinate(descr.substring(0,2));
        char c2=descr.charAt(2);
        if(c2!='V'&&c2!='H'){
            throw new IllegalArgumentException("Direction should be 'H' or 'V' but is:"+c2+"\n");
        }
        where=c;
        orientation=c2;
    }
    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(getClass())) {
            Placement p = (Placement) o;
            return where.equals(p.where) && orientation == p.orientation;
        }
        return false;
    }
    @Override
    public String toString() {
        return "("+where.toString()+", " + orientation+")";
    }
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
