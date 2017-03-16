package com.example.crazyhands.quizapp;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_score);

        //importing A and B and C and D from quetion four
        final int A = getIntent().getIntExtra("A", 0);
        final int B = getIntent().getIntExtra("B", 0);
        final int C = getIntent().getIntExtra("C", 0);
        final int D = getIntent().getIntExtra("D", 0);
        final int E = getIntent().getIntExtra("E", 0);
        finalScore(A, B,C,D,E);
    }

    private void finalScore (int A, int B, int C, int D, int E) {
        int score = A + B + C + D + E;
        final TextView i = (TextView) findViewById(R.id.message);
        final TextView y = (TextView) findViewById(R.id.finalscores);
        String congradulationsMessage = "Congratulations your score is: ";
        String sore= String.valueOf(score);
        i.setTextSize(40);
        i.setPadding(5,5,5,5);
        y.setText(sore);
        i.setText(congradulationsMessage);
    }
}
