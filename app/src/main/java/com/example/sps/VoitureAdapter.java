package com.example.sps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VoitureAdapter extends RecyclerView.Adapter<VoitureAdapter.VoitureViewHolder>
{
        private Context context;
        private List<Voiture> listeVoiture;

    public VoitureAdapter(Context context, List<Voiture> listeVoiture)
    {
        this.context = context;
        this.listeVoiture = listeVoiture;
    }

    //creation de viewholer
        @NonNull
        @Override
        public VoitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem,parent,false);
            VoitureViewHolder VoitureViewHolder = new VoitureViewHolder(view);

            return VoitureViewHolder;
        }

        //affichage des lignes
        @Override
        public void onBindViewHolder(@NonNull VoitureViewHolder holder,@SuppressLint("RecyclerView") int position)
        {
            Voiture voiture = listeVoiture.get(position);
            holder.Matricule.setText(voiture.getMatricule());
            holder.Modele.setText(voiture.getModele());
            holder.Prop.setText(voiture.getProp());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(context,listeVoiture.get(position).getMatricule(), Toast.LENGTH_LONG).show();
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Confirmation de Suppression");
                    builder.setMessage("Suppression définitive de cette Voiture"+listeVoiture.get(position).getModele()+"("+listeVoiture.get(position).getMatricule()+")"+" de cette liste");
                    builder.setPositiveButton("Oui !", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            listeVoiture.remove(position);
                            notifyItemRemoved(position);
                        }
                    });

                    builder.setNegativeButton("Non ! ", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                    return false;
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return listeVoiture.size();
        }

        public static class VoitureViewHolder extends RecyclerView.ViewHolder
        {
            TextView Matricule;
            TextView Modele;
            TextView Prop;

            public VoitureViewHolder(@NonNull View itemView)
            {
                super(itemView);
                Matricule = itemView.findViewById(R.id.Matricule);
                Modele = itemView.findViewById(R.id.modele);
                Prop = itemView.findViewById(R.id.prop);
            }
        }
}
