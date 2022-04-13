package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomNumberGenerator() //for repeating the game
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }
    public void onGuess(View view)
    {
        try {
            String message;
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if(guessedNumber < randomNumber){
                Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();}
            else if(guessedNumber > randomNumber){
                Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();}
            else
            {
                Toast.makeText(this, message="You got me !!", Toast.LENGTH_SHORT).show();
                randomNumberGenerator();    //kinda recurtion !
            }
        }
        catch (Exception a){
            EditText editTextNumber = findViewById(R.id.editTextNumber);
            editTextNumber.setError("Mampus Gagal");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //limit upto 20 from 1
    }
}