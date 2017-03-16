package com.example.crazyhands.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuetionThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the view to be quetion three
        setContentView(R.layout.activity_quetion_three);
        //importing A and B from quetion two
        final int A = getIntent().getIntExtra("A", 0);
        final int B = getIntent().getIntExtra("B", 0);
        //find the view that shows the has the next button
        final TextView i = (TextView) findViewById(R.id.checkAnswerThree);
        //set a click listener on that view and then tell it what to do when clicked
        i.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the View is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuetionThreeActivity.this, QuetionFourActivity.class);
                checkAnswer(view, intent, A, B);
            }
        });
    }
    int C = 0;

/*
* method to check if the andswer is right and act on it
* need to know what these view inputs are all about
* */

    public void checkAnswer (View view, Intent intent, int A, int B) {


        CheckBox CheckBoxOne = (CheckBox) findViewById(R.id.answer_one_quetion_three);
        boolean tickOne = CheckBoxOne.isChecked();

        CheckBox CheckBoxTwo = (CheckBox) findViewById(R.id.answer_two_quetion_three);
        boolean ticktwo = CheckBoxTwo.isChecked();

        CheckBox CheckBoxThree = (CheckBox) findViewById(R.id.answer_three_quetion_three);
        boolean tickThree = CheckBoxThree.isChecked();

        CheckBox CheckBoxFour = (CheckBox) findViewById(R.id.andswer_four_quetion_three);
        boolean tickFour = CheckBoxFour.isChecked();


        // testing the different possibilities
        // || is for or statments
        // && is for and statments


        //test if tick one is ticked
        if (!tickFour && tickOne && !tickThree && !ticktwo){
            C = 0;
            nextPage(A, B,intent);
        }

        //test if tick two is ticked
        else if (!tickFour && !tickOne && !tickThree && ticktwo){
            C = 0;
            nextPage(A, B,intent);
        }

        //test if tick three is ticked
        else if (!tickFour && !tickOne && tickThree && !ticktwo){
            C = 1;
            nextPage(A, B,intent);
        }

        //check if only tick four is ticked
        else if (tickFour && !tickOne && !tickThree && !ticktwo) {
            C = 0;
            nextPage(A, B,intent);
        }

        // if more than one is ticked!
        else {
            Toast.makeText(this, "one answer and only tick one answer!", Toast.LENGTH_SHORT).show();
        }
    }
    private void nextPage (int A, int B, Intent intent) {
        intent.putExtra("A", A);
        intent.putExtra("B", B);
        intent.putExtra("C", C);
        startActivity(intent);
    }

}
