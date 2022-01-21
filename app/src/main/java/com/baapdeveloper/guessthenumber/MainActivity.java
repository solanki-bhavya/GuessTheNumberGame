package com.baapdeveloper.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    long number;
    int tries;
    boolean gameon=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guess=findViewById(R.id.guess);
        guess.setClickable(false);
        TextView t=findViewById(R.id.status);
        t.setText("Welcome To Number Guessing Game\nPress New Game Button To Start The Game");
        Button b=findViewById(R.id.newgame);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameon=true;
                t.setText("Guess the Number between 1 to 10000");
                Random r=new Random();
                number = r.nextInt(9990)+10;
                tries=0;
                b.setClickable(false);
                guess.setClickable(true);
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameon==false)
                {
                    t.setText("Please Start The Game By Clicking New Game Button");
                    return;
                }
                tries++;
                TextView n=findViewById(R.id.decimalnumber);
                String s=n.getText().toString();
                if(s.isEmpty())
                    t.setText("Please Enter the Number");
                else {
                    long enteredNumber=Integer.parseInt(s);
                    if(enteredNumber==number) {
                        t.setText("Congratulations! You have guessed the number in " + tries + " treis\nPress New Game to start New Game");
                        gameon=false;
                        guess.setClickable(false);
                        b.setClickable(true);
                    }
                    else if(enteredNumber<number)
                        t.setText("Guess something bigger");
                    else
                        t.setText("Guess something smaller");
                }
            }
        });
    }
}