package com.example.chett.test.controleur;

import android.content.Context;

import com.example.chett.test.modele.AccesDistant;
import com.example.chett.test.modele.Ingredients;
import com.example.chett.test.modele.Recettes;
import com.example.chett.test.vue.IngreActivity;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by chett on 30/12/2016.
 */

public final class Controle {

    //Listes des propriétés de la classe
    private static Controle instance=null;
    private static AccesDistant accesDistant;
    private ArrayList<Ingredients> lesIngredients=new ArrayList<Ingredients>();
    private ArrayList<Recettes>lesRecettes=new ArrayList<Recettes>();
    private static Context context;
    private static IngreActivity ingreActivity ;

    //Constructeur

    private Controle() {
        super();
    }

    /**
     * créer de l'instance si elle n'existe pas encore ou de retourner l'instance crée
     * @param context
     * @return
     */
    public final static Controle getInstance(Context context){

        if(Controle.instance==null){

            Controle.context = context;
            Controle.instance=new Controle();
            accesDistant = new AccesDistant();
            accesDistant.envoi("tous", new JSONArray());
            accesDistant.envoi("recette",new JSONArray());
        }

        return Controle.instance;

    }

    /**
     * retourne le nom de l'ingredient
     * @return
     */
    public String getNomI(){

        if(lesIngredients!=null){

            return (lesIngredients.get(lesIngredients.size()-1).getNomI()); // on recup l'img du profil instancié

        }

        return null;

    }

    /**
     * retourne l'image de l'ingredient
     * @return
     */
    public String getImageI(){

        if(this.lesIngredients!=null){

            return lesIngredients.get(lesIngredients.size()-1).getImages();

        }

        return null ;

    }

    /**
     * retourne l'id de l'ingredient
     * @return
     */
    public int getIdIng(){

        if(this.lesIngredients!=null){

            return lesIngredients.get(lesIngredients.size()-1).getIdIn();

        }

        return 0 ;

    }

    /**
     * getter de l'arraylist lesIngredients
     * @return
     */
    public ArrayList<Ingredients> getLesIngredients() {
        return lesIngredients;
    }

    /**
     * getter de l'arraylist lesRecettes
     * @return
     */

    public ArrayList<Recettes> getLesRecettes() {
        return lesRecettes;
    }


    /*public void chargerLaListeAvecRecettes(){
        accesDistant.envoi("recette",new JSONArray());
    }*/


    /**
     * utile pour charger la liste des recettes selon l'ingredient choisie
     * @param nomIngre
     */
    public void chargerLaListeAvecRecettes(String nomIngre){
        accesDistant.envoi(nomIngre, new JSONArray());
    }

    /**
     * Setter sur lesIngredients
     * @param lesIngredients
     */
    public void setLesIngredients(ArrayList<Ingredients>lesIngredients){

        this.lesIngredients=lesIngredients;
        // permet de d'afficher la liste d'ing du premier coup
        ingreActivity.creerListeIng();
    }

    /**
     * Setter sur lesRecettes
     * @param lesRecettes
     */
    public void setLesRecettes(ArrayList<Recettes>lesRecettes){

        this.lesRecettes=lesRecettes;
    }

    /**
     * Setter sur Ingreactivity
     * @param ingreActivity
     */
    public void setIngreActivity(IngreActivity ingreActivity) {

        Controle.ingreActivity = ingreActivity;



    }
}
