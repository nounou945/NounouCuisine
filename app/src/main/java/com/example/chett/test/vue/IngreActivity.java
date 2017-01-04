package com.example.chett.test.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.chett.test.R;
import com.example.chett.test.controleur.Controle;
import com.example.chett.test.modele.Ingredients;

import java.util.ArrayList;

public class IngreActivity extends AppCompatActivity {

    //Listes des propriétés de la classe

    private ImageButton imgAc;
    private Controle controle;

    //Constructeur de IngreActivity
    public IngreActivity() {
        controle=Controle.getInstance(IngreActivity.this);
        controle.setIngreActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingre);
        retourMenu();
        creerListeIng();


    }

    /**
     * permet de retourner à l'interface d'accueil
     */
    public void retourMenu(){
    imgAc=(ImageButton)findViewById(R.id.imgAc);
    ecoutemenu(imgAc,MainActivity.class);
    }

    /**
     * necessaire au fonctionnement du menu
     * @param image
     * @param classe
     */
    public void ecoutemenu(ImageButton image,final Class classe){
        image.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent=new Intent(IngreActivity.this,classe);
                        startActivity(intent);
                    }
                });

    }

    /**
     * sert à creer la liste des ingredients
     * en recuperant les ingredients avec le getter
     */
    public void creerListeIng(){
        ArrayList<Ingredients>liste=new ArrayList<Ingredients>();
        liste=controle.getLesIngredients();
        ListView lstIng=(ListView)findViewById(R.id.lstIng);
        IngreListAdapter objet=new IngreListAdapter(IngreActivity.this,liste);
        lstIng.setAdapter(objet);
    }


}
