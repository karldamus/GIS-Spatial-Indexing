package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class Point {
    ArrayList<Integer> coordinates;
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        setLocation(x, y);
    }

    public Point(int x, int y, int z) {
        setLocation(x, y, z);
    }

    public Point(ArrayList<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    // getters
    public boolean equals(Point p) {return (this.x == p.getX() && this.y == p.getY());}
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getZ() {return this.z;}

    // setters
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;

        coordinates = new ArrayList<Integer>(Arrays.asList(x, y));
    }

    public void setLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        coordinates = new ArrayList<Integer>(Arrays.asList(x, y, z));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < coordinates.size(); i++) {
            if (i+1 == coordinates.size())
                s.append(coordinates.get(i));
            else
                s.append(coordinates.get(i)).append(", ");
        }

        return s.toString();
    }
}
