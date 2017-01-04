package com.example.chett.test.vue;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chett.test.R;
import com.example.chett.test.controleur.Controle;
import com.example.chett.test.modele.Ingredients;
import com.example.chett.test.modele.Recettes;
import com.example.chett.test.outils.MesOutils;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by chett on 30/12/2016.
 */

public class IngreListAdapter extends BaseAdapter {

    ////Listes des propriétés de la classe
    private static ArrayList<Ingredients> lesIngredients=new ArrayList<Ingredients>();
    private LayoutInflater inflater;
    private Context context;


    //Constructeur de IngreLisAdapter
    public IngreListAdapter(Context context,ArrayList<Ingredients>objIngredients) {
        this.lesIngredients=objIngredients;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }

    //Classe interne utile à la liaison de nos champ à voir
    private class  ViewHolder {

        TextView txtListIng;
        ImageButton imgListIng;
        TextView txtIdIng;

    }

    /**
     * retourne le nombre de ligne de l'arraylist
     * @return
     */
    @Override
    public int getCount() {
        return lesIngredients.size();
    }

    /**
     * retourne la position des elements de l'arraylist
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return lesIngredients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //methode pour afficher les elements et leurs actions
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // holder est un objet de la petite classe
        ViewHolder holder ;
        // si la ligne n'existe pas encore
        if (convertView == null) {
            holder = new ViewHolder() ;
            // la ligne est construite à partir de la structure de la ligne (récupéré dans layout_list_ing)
            convertView = inflater.inflate(R.layout.layout_liste_ing, null) ;
            // chaque propriété de holder (correspondant aux objets graphiques) est liée à un des objets graphiques
            holder.txtListIng = (TextView)convertView.findViewById(R.id.txtListIng) ;
            holder.imgListIng = (ImageButton)convertView.findViewById(R.id.imgListIng) ;
            holder.imgListIng.setImageResource(getImageBdd(""+lesIngredients.get(position).getImages()));

            Log.d("titreimage", "************" +lesIngredients.get(position).getImages());
            //holder.txtIdIng=(TextView)convertView.findViewById(R.id.txtIdIng);
            // affecte un tag (un indice) à la ligne (qui permettra de la repérer facilement)
            convertView.setTag(holder) ;
        }else{
            // si la ligne existe déjà, holder récupère le contenu (à partir de son tag, donc son indice)
            holder = (ViewHolder)convertView.getTag();
        }
        // holder est maintenant lié à la ligne graphique
        // valorisation des propriétés de holder avec ingredient de lesIngredients (à un indice précis : position)
        holder.txtListIng.setText(lesIngredients.get(position).getNomI());
        Log.d("txtListIng", "************" + holder.txtListIng);
        //holder.txtIdIng.setText(""+lesIngredients.get(position).getIdIn());
        holder.imgListIng.setImageResource(getImageBdd(""+lesIngredients.get(position).getImages()));
        holder.imgListIng.setTag(position) ;
        Log.d("imgdelabdd",""+""+(getImageBdd(lesIngredients.get(position).getImages())));

        // gestion de l'événement clic sur le bouton de l'image
        holder.imgListIng.setOnClickListener(new View.OnClickListener(){

            /**
             * action sur le clic des images
             * @param v
             */
            @Override
            public void onClick(View v) {


                // récupère l'indice de la ligne concernée
                int position = (Integer)v.getTag() ;

                // averti le controleur qu'il faut charger les infos des recettes selon l'img de ling
                Controle controle = Controle.getInstance(context);

                Log.d("clic image","clic image");

                controle.chargerLaListeAvecRecettes(lesIngredients.get(position).getNomI());

                //se dirige vers la deuxieme liste
                Intent intent= new Intent(context, RecActivity.class);

                context.startActivity(intent);





                // rafraichi la liste visuelle

                notifyDataSetChanged() ;
            }
        }) ;
        return convertView ;

    }

    /**
     * selon le nom de nom de l'image recuperer dans la base affiche la bonne image
     * @param nomimg
     * @return
     */
    public int getImageBdd(String nomimg){
        if(nomimg.equals("chocolat.png")){
            return R.drawable.chocolat;
        }
        if(nomimg.equals("pomme.png")){
            return R.drawable.pomme;
        }
         if(nomimg.equals("caramel.png")){
            return R.drawable.caramel;
        }
        if(nomimg.equals("fraise.png")){
            return R.drawable.fraise;
        }
        return 0;
    }

}
