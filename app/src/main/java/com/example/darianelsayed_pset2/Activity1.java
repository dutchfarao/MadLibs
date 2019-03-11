package com.example.darianelsayed_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Activity1 extends AppCompatActivity {
    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //setting up list with stories as content, hardcoded
        String[] arraySpinner = new String[] {
                "Simple", "Tarzan", "University", "Clothes", "Dance"
        };
        Spinner s = findViewById(R.id.spinner1);

        //creating arrayAdapter with list containing stories
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //applying arrayAdapter to spinner
        s.setAdapter(adapter);

        //create spinner listener
        onSpinnerClick onSpinnerClick = new onSpinnerClick();
        s.setOnItemSelectedListener(onSpinnerClick);
        //create listener for button
        Button btn = findViewById(R.id.activity1Button);
        onClick onButtonClick = new onClick();
        btn.setOnClickListener(onButtonClick);


    }


    //create 'onclick' for spinner
    private class onSpinnerClick implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();
            selectedItem = item.toLowerCase();



        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    //ceation of onclick for button
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Activity1.this, Activity2.class);
            intent.putExtra("selected_item", selectedItem);
            startActivity(intent);

        }
    }




}

