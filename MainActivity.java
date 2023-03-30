package com.example.dailygita;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView slokaTextView = (TextView) findViewById(R.id.slokaTextView);
        slokaTextView.setText(getRandomVerse());
    }

    public String getRandomVerse(){

        //get random int (0-699) for verse selection
        Random random  = new Random();
        int verseSelectInt = random.nextInt(700);
        String verseContainer = null;
        int lineIndex = 1;
        boolean found = false;
        
        try {
            BufferedReader readGita = new BufferedReader(new InputStreamReader(getAssets().open("gita.txt")));
            //loop through gita.txt until reaching desired verse
            while((verseContainer = readGita.readLine())!= null){
                if (lineIndex == verseSelectInt){
                    verseContainer = readGita.readLine();
                    found = true;
                    break;
                }else{
                    lineIndex++;
                }
            }
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return verseContainer;
    }



    public void onSlokaBtnClick (View view){
        TextView slokaTextView = (TextView) findViewById(R.id.slokaTextView);
        slokaTextView.setText(getRandomVerse());
    }
}