package com.example.chett.test.modele;

import java.io.Serializable;

/**
 * Created by chett on 31/12/2016.
 */

public class Recettes implements Serializable {

    private int idR;
    private String titreR;
    private String preparationR;
    private String dureeR;
    private String qte ;


    public Recettes(int idR,String titreR,String preparationR,String dureeR, String qte) {
        this.idR = idR;
        this.titreR=titreR;
        this.dureeR=dureeR;
        this.preparationR = preparationR;
        this.qte = qte;
    }

    public String getTitreR() {
        return titreR;
    }

    public String getPreparationR() {
        return preparationR;
    }

    public String getDureeR() {
        return dureeR;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public void setTitreR(String titreR) {
        this.titreR = titreR;
    }

    public void setPreparationR(String preparationR) {
        this.preparationR = preparationR;
    }

    public void setDureeR(String dureeR) {
        this.dureeR = dureeR;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }
}
