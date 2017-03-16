package com.example.crazyhands.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuetionFiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the view to be quetion five
        setContentView(R.layout.activity_quetion_five);
        //importing A and B and C and D from quetion four
        final int A = getIntent().getIntExtra("A", 0);
        final int B = getIntent().getIntExtra("B", 0);
        final int C = getIntent().getIntExtra("C", 0);
        final int D = getIntent().getIntExtra("D", 0);
        //find the view that shows the has the next button
        final TextView i = (TextView) findViewById(R.id.checkAnswerFive);
        //set a click listener on that view and then tell it what to do when clicked
        i.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the View is clicked on.
            @Override

            //check answer using view, intent and ABCD
            public void onClick(View view) {
                Intent intent = new Intent(QuetionFiveActivity.this, EndScoreActivity.class);
                checkAnswer(view, intent, A, B,C,D);
            }
        });
    }
    //new answer variable
    int E = 0;

/*
* method to check if the andswer is right and act on it
* need to know what these view inputs are all about
* */

    public void checkAnswer (View view, Intent intent, int A, int B, int C, int D) {


        CheckBox CheckBoxOne = (CheckBox) findViewById(R.id.answer_one_quetion_five);
        boolean tickOne = CheckBoxOne.isChecked();

        CheckBox CheckBoxTwo = (CheckBox) findViewById(R.id.answer_two_quetion_five);
        boolean ticktwo = CheckBoxTwo.isChecked();

        CheckBox CheckBoxThree = (CheckBox) findViewById(R.id.answer_three_quetion_five);
        boolean tickThree = CheckBoxThree.isChecked();

        CheckBox CheckBoxFour = (CheckBox) findViewById(R.id.answer_four_quetion_five);
        boolean tickFour = CheckBoxFour.isChecked();


        // testing the different possibilities
        // || is for or statments
        // && is for and statments


        //test if tick one is ticked
        if (!tickFour && tickOne && !tickThree && !ticktwo){
            E = 0;
            nextPage(A, B, C ,D,E,intent);
        }

        //test if tick two is ticked
        else if (!tickFour && !tickOne && !tickThree && ticktwo){
            E = 0;
            nextPage(A, B,C,D,E,intent);
        }

        //test if tick three is ticked
        else if (!tickFour && !tickOne && tickThree && !ticktwo){
            E = 1;
            nextPage(A, B,C,D,E,intent);
        }

        //check if only tick four is ticked
        else if (tickFour && !tickOne && !tickThree && !ticktwo) {
            E = 0;
            nextPage(A, B, C,D,E,intent);
        }

        // if more than one is ticked!
        else {
            Toast.makeText(this, "one answer and only tick one answer!", Toast.LENGTH_SHORT).show();
        }
    }
    private void nextPage (int A, int B,int C, int D, int E, Intent intent) {
        intent.putExtra("A", A);
        intent.putExtra("B", B);
        intent.putExtra("C", C);
        intent.putExtra("D", D);
        intent.putExtra("E", E);
        startActivity(intent);
    }

}
