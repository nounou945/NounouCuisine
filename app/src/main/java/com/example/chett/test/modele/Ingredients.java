package com.example.chett.test.modele;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by chett on 30/12/2016.
 */

public class Ingredients implements Serializable {

    private int idIn;
    private String nomI;
    private String images;

    public Ingredients(int idIn,String nomI,String images) {
        this.idIn = idIn;
        this.nomI=nomI;
        this.images=images;
    }

    public String getNomI() {
        return nomI;
    }

    public int getIdIn() {
        return idIn;
    }

    public String getImages() {
        return images;
    }


}
