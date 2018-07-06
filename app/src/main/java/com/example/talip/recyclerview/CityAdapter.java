package com.example.talip.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// DIESE DINGE MUSS MAN EINFACH SO MACHEN, WEIL GOOGLE ES SO WOLLTE.

// Ein ViewHolder hält eine View.
// Ein Adapter, der den für RecyclerViews bereitgestellten
// Adapter erweitert. Der bereitgestellte Adapter wird für
// den ViewHolder definiert, den wir innerhalb der Klasse
// speziell neu definieren.
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    ArrayList<City> citiesList;

    // Der speziell für den CityAdapter definierte ViewHolder.
    // Der ViewHolder hat nur die Informationen für eine einzelne
    // View der Liste.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView nameText;
        public TextView popText;
        public TextView altText;

        public ViewHolder(View itemView) {
            super(itemView);

            // Du ViewHolder, halte eine View (hier TextView nameText)
            // entsprechend der Konfiguration, die ich für diese View
            // im a_row TextView aufgebaut habe.
            nameText = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(this);

            popText = itemView.findViewById(R.id.pop);
            itemView.setOnClickListener(this);

            altText = itemView.findViewById(R.id.alt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Toast.makeText(view.getContext(), citiesList.get(pos).getName(), Toast.LENGTH_SHORT).show();
        }
    }

    public CityAdapter(Context c){
        citiesList = new ArrayList<City>();
    }

    // Wie viele Einträge gebe ich denn gerade aus?
    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    public void addCity(String c, String p, String a) {
        citiesList.add(new City (c, p, a));
    }

    // This is just how Google wants it to be.
    // Diese Methode ist ein Bestandteil von RecyclerView.Adapter,
    // die wir selber zusammenbasteln wollen (anscheinend).
    //
    // Wenn Android eine solche Liste darstellen will:
    // "Position 0.. ich brauche den ViewHolder"
    // "Position 1.. ich brauche den ViewHolder" usw.
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Programmieren dieser einzelnen cityView-Row des RecyclerViews mit der
        // XML my_row, die das Design einer solchen einzelnen Row hat.
        View cityView = inflater.inflate(R.layout.my_row, parent, false);
        CityAdapter.ViewHolder viewHolder = new ViewHolder(cityView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        holder.nameText.setText(citiesList.get(position).getName());
        holder.popText.setText(citiesList.get(position).getPopulation());
        holder.altText.setText(citiesList.get(position).getAltitude());
    }
}
