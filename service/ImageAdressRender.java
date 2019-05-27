package com.gmail.goyter012.Interpolation.service;

import java.io.File;
import java.net.MalformedURLException;

public class ImageAdressRender {
    public static String imRender(String filename){
        File file = new File(filename);
        String uri = null;
        try{
            uri = file.toURI().toURL().toString();
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }
        return uri;

    }

}
