package com.example.darianelsayed_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;

public class Activity2 extends AppCompatActivity {
    Story newStory;
    TextView wordCounter;
    EditText inputField;
    String selectedItem;
    String input;
    InputStream stream;
    private static final String TAG = "Activity1";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        inputField = findViewById(R.id.activity2Input);
        wordCounter = findViewById(R.id.activity2TextView);
        Intent intent = getIntent();
        selectedItem = intent.getStringExtra("selected_item");
        Log.d(TAG, "this is the selected item:    " + selectedItem );


        //call storymaker
        StoryMaker();
        inputField.setHint(newStory.getNextPlaceholder());
        wordCounter.setText(newStory.getPlaceholderCount() + " " +"words remaining." );
        //create listener for button
        Button btn = findViewById(R.id.activity2Button);
        onClick onButtonClick = new onClick();
        btn.setOnClickListener(onButtonClick);
        //put first hint inside EditText







    }

    public Story StoryMaker(){
        //InputStream corresponds with story chosen in first screen
        if(selectedItem.equals("simple")){
            stream = getResources().openRawResource(R.raw.madlib0_simple);
            newStory = new Story(stream);
            Log.d(TAG, "inputstream" +   stream);

        }
     if(selectedItem.equals("tarzan")){
            stream = getResources().openRawResource(R.raw.madlib1_tarzan);
            newStory = new Story(stream);
        }
        if(selectedItem.equals("university")){
            stream = getResources().openRawResource(R.raw.madlib2_university);
            newStory = new Story(stream);
        }
        if(selectedItem.equals("clothes")) {
            stream = getResources().openRawResource(R.raw.madlib3_clothes);
            newStory = new Story(stream);
        }
        if(selectedItem.equals("dance")) {
            stream = getResources().openRawResource(R.raw.madlib4_dance);

            newStory = new Story(stream);
        }
        return newStory;


    }


    //method for getting the input of user in EditText
    public String getUserInput(){
        inputField = findViewById(R.id.activity2Input);
        input = String.valueOf(inputField.getText());
        Log.d(TAG, "Value of inputfield =" + input);
        Log.d(TAG, "this is the story:    " + newStory );

        return input;
    }

    public void setWord(View view){
        //check if user didn't leave the EditText empty
        inputField = findViewById(R.id.activity2Input);
        if(inputField.length() == 0){
            inputField.setError("You forgot to put in a word!");
        }
        else {
            //use the word the user just inputted in the story then reset the Edit text en reset hint


            newStory.fillInPlaceholder(getUserInput());
            inputField.setText("");
            inputField.setHint(newStory.getNextPlaceholder());
            // update word count
            wordCounter.setText(newStory.getPlaceholderRemainingCount() + " " +" words remaining." );
            if(newStory.getPlaceholderRemainingCount() == 0){
                Intent intent = new Intent(Activity2.this, Activity3.class);
                intent.putExtra("newStory", newStory.toString());
                startActivity(intent);
            }



        }


    }

    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            inputField = findViewById(R.id.activity2Input);
            setWord(inputField);

        }
    }




}