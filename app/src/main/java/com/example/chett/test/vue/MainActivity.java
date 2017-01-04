package com.example.chett.test.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.chett.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Listes des propriétés de la classe
    private ImageButton imgIng;
    private TextView txtIng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creerMenu();
        ecouteMenu(imgIng,IngreActivity.class);

    }

    /**
     * creer le menu de l'interface
     */
    public void creerMenu(){
    imgIng=(ImageButton)findViewById(R.id.imgIng);
    txtIng=(TextView)findViewById(R.id.txtIng);
    }

    /**
     * dirigera vers une autre activity sur le clic de l'image
     * @param image
     * @param classe
     */
    public void ecouteMenu(ImageButton image,final Class classe){
        image.setOnClickListener
                (new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent=new Intent(MainActivity.this,classe);
                        startActivity(intent);
                    }
                });
    }
}


