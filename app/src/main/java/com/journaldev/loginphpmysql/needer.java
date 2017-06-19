package com.journaldev.loginphpmysql;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class needer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String servicesArray[] = {"ELECTRICIAN","PLUMBER","MECHANIC","MAID","NEWSPAPER","MILK","GROCERY","CARPENTER"};
    String locationsArray[] = {"RANCHI","JAMSHEDPUR","BOKARO","HAZARIBAGH","RAMGARH"};
    TextView text;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needer);




        Spinner spinner1 = (Spinner) findViewById(R.id.servicesSpinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.locationSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter adapter =new ArrayAdapter(this,android.R.layout.simple_spinner_item,servicesArray){


            public View getDropDownView(int position, View convertView,ViewGroup parent) {
                // TODO Auto-generated method stub

                View view = super.getView(position, convertView, parent);

                 text = (TextView)view.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);

                return view;

            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub

                View view = super.getView(position, convertView, parent);

                 text = (TextView)view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);

                return view;

            }

        };



        ArrayAdapter adapter2 =new ArrayAdapter(this,android.R.layout.simple_spinner_item,locationsArray){


            public View getDropDownView(int position, View convertView,ViewGroup parent) {
                // TODO Auto-generated method stub

                View view = super.getView(position, convertView, parent);

                 text = (TextView)view.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);

                return view;

            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub

                View view = super.getView(position, convertView, parent);

                 text1 = (TextView)view.findViewById(android.R.id.text1);
                text1.setTextColor(Color.BLACK);

                return view;

            }

        };

// Specify the layout to use when the list of choices appears


        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }




}
