package com.example.darianelsayed_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    String newStory;
    TextView fullstory;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent intent = getIntent();
        //create string to put in txtfield later
        newStory = intent.getExtras().getString("newStory");
        fullstory = findViewById(R.id.activity3TextView);
        fullstory.setText(newStory);

        //create listener for button




    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Activity3.this, Activity1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            resetButton = findViewById(R.id.activity3Button);
            Intent intent = new Intent(Activity3.this, Activity1.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    }
}
