package com.gmail.goyter012.Interpolation.models;

public class model {

    private int a;
    private int b;
    private int points;


    public model(int a, int b, int points) {
        this.a = a;
        this.b = b;
        this.points = points;
    }


    public model() {
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public String toString() {
        return "model{" +
                "a=" + a +
                ", b=" + b +
                ", points=" + points +
                '}';
    }








}
