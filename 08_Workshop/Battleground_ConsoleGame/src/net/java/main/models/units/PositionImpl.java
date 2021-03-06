package net.java.main.models.units;

import net.java.main.interfaces.Position;

public class PositionImpl implements Position {
    private int x;
    private int y;

    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y +")";
    }
}
