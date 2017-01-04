package com.example.chett.test.vue;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chett.test.R;
import com.example.chett.test.modele.Recettes;

import java.util.ArrayList;

/**
 * Created by chett on 31/12/2016.
 */

public class RecListAdapter extends BaseAdapter {

    //Listes des propriétés de la classe
    private static ArrayList<Recettes> lesRecettes=new ArrayList<Recettes>();
    private LayoutInflater inflater;
    private Context context;

    ////Constructeur de RecLisAdapter
    public RecListAdapter(Context context,ArrayList<Recettes>objRecettes) {
        this.lesRecettes=objRecettes;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }

    //Classe interne utile à la liaison de nos champ à voir
    private class  ViewHolder {

        TextView txtTitre;
        TextView txtDuree;
        TextView txtPrep;
        TextView txtId ;
        TextView txtQter;


    }

    /**
     * retourne le nombre de ligne de l'arraylist
     * @return
     */
    @Override
    public int getCount() {
        return lesRecettes.size();
    }

    /**
     * retourne la position des elements de l'arraylist
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return lesRecettes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

        //methode pour afficher les elements et leurs actions
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // holder est un objet de la petite classe
            ViewHolder holder ;
            // si la ligne n'existe pas encore
            if (convertView == null) {
                holder = new ViewHolder() ;
                // la ligne est construite à partir de la structure de la ligne (récupéré dans layout_list_recette)
                convertView = inflater.inflate(R.layout.layout_liste_recette, null) ;

                // chaque propriété de holder (correspondant aux objets graphiques) est liée à un des objets graphiques
                holder.txtPrep = (TextView)convertView.findViewById(R.id.txtPrep) ;
                holder.txtDuree=(TextView)convertView.findViewById(R.id.txtDuree);
                holder.txtTitre=(TextView)convertView.findViewById(R.id.txtTitre);
                //holder.txtId=(TextView)convertView.findViewById(R.id.txtId);
                holder.txtQter=(TextView)convertView.findViewById(R.id.txtQter);


                // affecte un tag (un indice) à la ligne (qui permettra de la repérer facilement)
                convertView.setTag(holder) ;
            }else{
                // si la ligne existe déjà, holder récupère le contenu (à partir de son tag, donc son indice)
                holder = (ViewHolder)convertView.getTag();
                Log.d("txtListrec", "************" + holder.txtPrep);
                //
            }
            // holder est maintenant lié à la ligne graphique
            // valorisation des propriétés de holder avec la recette de les recettes (à un indice précis : position)
            holder.txtPrep.setText(lesRecettes.get(position).getPreparationR());
            Log.d("Preparation R", "************" + lesRecettes.get(position).getPreparationR());
            Log.d("txtListrec", "************" + holder.txtPrep);
            holder.txtDuree.setText(lesRecettes.get(position).getDureeR());
            holder.txtTitre.setText(lesRecettes.get(position).getTitreR());
           // holder.txtId.setText(""+lesRecettes.get(position).getIdR());
            holder.txtQter.setText(lesRecettes.get(position).getQte());

            //raffraichit la liste
            notifyDataSetChanged() ;
            return convertView ;
        }

    }

