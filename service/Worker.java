package com.gmail.goyter012.Interpolation.service;

import com.gmail.goyter012.Interpolation.models.Res;
import com.gmail.goyter012.Interpolation.models.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class Worker {




    public static double[] xi(double a, double b, int iter) {
        double h = (b - a) / 10;

        double[] res = new double[iter];
        for (int i = 0; i < res.length; i++) {
            res[i] = a + h * i;
        }
        return res;
    }


    public static double[] fxi(int a, int b, int iter){
            double[] res = new double[iter];
            for(int i = 0; i < res.length; i++){
                res[i] = Math.pow(Math.sin(xi(a,b,iter)[i]),3) + 3*Math.pow(Math.cos(xi(a,b,iter)[i]),2);
            }

            return res;
    }



    public static double lagrange(double x , int a , int b, int points){
        double res = 1;
        double sum = 0;
        for(int i = 0; i < points; i++){
            for(int j = 0; j < points; j++){
                if(j!=i){
                    res*=(x - xi(a,b,points)[j])/(xi(a,b,points)[i] - xi(a,b,points)[j]);
                }
            }

            sum+= res * fxi(a,b,points)[i];
            res = 1;
        }
        return sum;
    }



    public static void saveToJsonFile(model model, File file ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String st = gson.toJson(model);
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(st);
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static model loaderFromJsonFile(File file){
        Gson gson = new Gson();
        model model = null;
        try{
            model = gson.fromJson(new FileReader(file),model.class);
        }catch (JsonIOException | JsonSyntaxException | FileNotFoundException e ){
            return null;
        }
        return model;
    }


    public static void saveToJsonFile(Res model, File file ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String st = gson.toJson(model);
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(st);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
















}
