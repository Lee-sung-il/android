package com.example.graphic0314;

public class MyPoint {
    float x;
    float y;
    boolean draw;

    public MyPoint(float x, float y, boolean draw) {
        this.x = x;
        this.y = y;
        this.draw = draw;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
