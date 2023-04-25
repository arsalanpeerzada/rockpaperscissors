package com.example.rps;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4;

    int Scr2, Scr1 = 0;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txt4 = findViewById(R.id.txtPlayerSelect);
        txt3 = findViewById(R.id.txtCompSelect);
        txt2 = findViewById(R.id.txtScore);
        txt1 = findViewById(R.id.txtWin);

        txt4.setText("hello");
        txt3.setText("hello");
        txt1.setText("");

        random = new Random();
    }
    public void Reset (View view)
    {
        txt4.setText("");
        txt3.setText("");
        txt1.setText("");
        txt2.setText("0 : 0");

        Scr1 = 0;
        Scr2 = 0;
    }

    public void selection(View view)
    {
        int PlayerSelection = Integer.parseInt(view.getTag().toString());

        GamePlay(PlayerSelection);

    }

    private void GamePlay(int PlayerSelection) {
        int a = 1;
        int b = 3;

        int randomSelection = random.nextInt(b) + a;

        if (PlayerSelection == randomSelection) {
            txt1.setText("Tie");
        } else if ((PlayerSelection - randomSelection) % 3 == 1) {
            txt1.setText("Won");
            Scr2++;
        } else {
            txt1.setText("Lose");
            Scr1++;
        }

        if (PlayerSelection == 1) {
            txt4.setText("Rock");
        } else if (PlayerSelection == 2) {
            txt4.setText("Paper");
        } else if (PlayerSelection == 3) {
            txt4.setText("Scissor");
        }

        if (randomSelection == 1) {
            txt3.setText("Rock");
        } else if (randomSelection == 2) {
            txt3.setText("Paper");
        } else if (randomSelection == 3) {
            txt3.setText("Scissor");
        }
        Points(Scr2, Scr1);
    }

    public void Points(int Score1, int Score2)
    {
        txt2.setText(String.valueOf(Score1) +" : "+ String.valueOf(Score2));

    }
}