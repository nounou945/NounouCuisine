package com.example.chett.test.modele;

import android.util.Log;

import com.example.chett.test.controleur.Controle;
import com.example.chett.test.outils.AccesHTTP;
import com.example.chett.test.outils.AsyncResponse;
import com.example.chett.test.outils.MesOutils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by chett on 25/12/2016.
 */

public class AccesDistant implements AsyncResponse {

    //Listes des propriétés de la classe
    //final String SERVERADDR="http://192.168.0.21/test/serveurtest.php";
   final String SERVERADDR="http://192.168.43.219/test/serveurtest.php";
   private Controle controle ;

    //Constructeur de AccesDistant
    public AccesDistant(){
        //super();
      this.controle=Controle.getInstance(null);

    }

    /**
     * permettre de gérer le retour du serveur
     * @param output
     */
    @Override
    public void processFinish(String output) {
        Log.d("serveur", "************" + output);
        String[] message = output.split("%");
        //String[] messager = output.split("%");
        if(message.length>1)
        {

        if(message[0].equals("tous")){
            try{
                //JSONObject info= new JSONObject(message[1]);
                JSONArray tab= new JSONArray(message[1]);
                ArrayList listIng=new ArrayList<Ingredients>();
                for(int i=0;i<tab.length();i++ ){
                JSONObject info=(JSONObject)(tab.get(i));
                Integer id=info.getInt("idI");
                String nomI=info.getString("nomI");
                String images=info.getString("images");
                listIng.add(new Ingredients(id,nomI,images));
                }
                controle.setLesIngredients(listIng);

            }


            catch (JSONException e) {
                e.printStackTrace();


            }

             }
            if(message[0].equals("recette")){
                try{
                    //JSONObject info= new JSONObject(message[1]);
                    JSONArray tab2= new JSONArray(message[1]);
                    ArrayList listRec=new ArrayList<Recettes>();
                    for(int i=0;i<tab2.length();i++ ){
                        JSONObject info=(JSONObject)(tab2.get(i));
                        Integer idR=info.getInt("idR");
                        String titreR=info.getString("titreR");
                        String dureeR=info.getString("dureeR");
                        String preparationR=info.getString("preparationR");
                        String qte = info.getString("qte");
                        listRec.add(new Recettes(idR,titreR,preparationR,dureeR,qte));
                    }
                    controle.setLesRecettes(listRec);

                }


                catch (JSONException e) {
                    e.printStackTrace();


                }

            }
        }
    }

    /**
     * qui reçoit en paramètre l'opération et la donnée à envoyer au format JSON
     * @param operation
     * @param lesDonneesJSON
     */
    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees= new AccesHTTP();
        accesDonnees.delegate = this; // le lien de délégation entre AccesDistant et AccesHTTP
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }
}
