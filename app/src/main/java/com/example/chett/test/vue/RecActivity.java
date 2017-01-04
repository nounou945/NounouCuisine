package com.example.chett.test.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.chett.test.R;
import com.example.chett.test.controleur.Controle;
import com.example.chett.test.modele.Recettes;

import java.util.ArrayList;

public class RecActivity extends AppCompatActivity {

    //Listes des propriétés de la classe
    private Controle controle;
    private ImageButton imgRetour ;

    //Constructeur de RecActivity
    public RecActivity() {
        controle=Controle.getInstance(RecActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);
        creerListeRec();
        retourListeIngredients();
    }

    /**
     * creer la liste de recettes grace au getter de l'arraylist lesRecettes
     */
    public void creerListeRec(){
        ArrayList<Recettes> liste=new ArrayList<Recettes>();
        liste=controle.getLesRecettes();
        ListView lstRec=(ListView)findViewById(R.id.lstRec);
        RecListAdapter objet=new RecListAdapter(RecActivity.this,liste);
        lstRec.setAdapter(objet);
    }

    /**
     * permet de rediriger vers la liste d'ingredients
     */
    public void retourListeIngredients(){
        imgRetour=(ImageButton)findViewById(R.id.imgRetour);
        ecoutemenu(imgRetour,IngreActivity.class);
    }

    /**
     * necessaire au retour à l'accueil
     * @param image
     * @param classe
     */
    public void ecoutemenu(ImageButton image,final Class classe){
        image.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent=new Intent(RecActivity.this,classe);
                        startActivity(intent);
                    }
                });

    }

}
