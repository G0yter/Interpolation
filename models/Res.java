package com.gmail.goyter012.Interpolation.models;

public class Res {


    private double x;
    private double fx;

    public Res(double x, double fx) {
        this.x = x;
        this.fx = fx;
    }


    public Res() {
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }


    @Override
    public String toString() {
        return "Res{" +
                "x=" + x +
                ", fx=" + fx +
                '}';
    }
}
