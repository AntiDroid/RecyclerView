package com.example.talip.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CityAdapter a;

    private City fakeCity(){
        String syllables[] = {"bi", "be", "bo", "bu", "lu",
                "da", "tri", "gus", "dar", "ean", "sans", "el"};

        Random r = new Random();

        String c = "";

        for (int i = 0; i < 3; i++)
            c += syllables[r.nextInt(syllables.length)];

        c += "ville";
        c = c.substring(0,1).toUpperCase()+c.substring(1);

        City city = new City(c, Integer.toString(r.nextInt(9999)), Integer.toString(r.nextInt(9999)));

        return city;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rView);
        a = new CityAdapter(this);
        a.addCity("London", "1234", "4321");
        a.addCity("Paris", "7890", "0987");
        a.addCity("Berlin", "4831", "9340");
        rv.setAdapter(a);

        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickAddButton(View v){

        City fakeCity = fakeCity();
        a.addCity(fakeCity.getName(), fakeCity.getPopulation(), fakeCity.getAltitude());

        //Damit die Änderung sichtbar wird.
        a.notifyItemInserted(a.getItemCount()-1);
    }
}
