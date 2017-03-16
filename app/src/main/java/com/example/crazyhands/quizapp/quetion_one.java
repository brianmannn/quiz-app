package com.example.crazyhands.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class quetion_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quetion_one);


        //find the view that shows the numbers catagory
        TextView numbers = (TextView) findViewById(R.id.checkAnswerOne);
        //set a click listener on that view and then tell it what to do when clicked
        numbers.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the View is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quetion_one.this, quetion_two.class);
                checkAnswer(view, intent);

            }
        });
    }

    int A = 0;

/*
* method to check if the andswer is right and act on it
* need to know what these view inputs are all about
* */

    public void checkAnswer (View view, Intent intent) {

        CheckBox CheckBoxOne = (CheckBox) findViewById(R.id.quetion_one);
        boolean tickOne = CheckBoxOne.isChecked();

        CheckBox CheckBoxTwo = (CheckBox) findViewById(R.id.quetion_two);
        boolean ticktwo = CheckBoxTwo.isChecked();

        CheckBox CheckBoxThree = (CheckBox) findViewById(R.id.quetion_three);
        boolean tickThree = CheckBoxThree.isChecked();

        CheckBox CheckBoxFour = (CheckBox) findViewById(R.id.quetion_four);
        boolean tickFour = CheckBoxFour.isChecked();

        // testing the different possibilities
        // || is for or statments
        // && is for and statments



        //test if tick one is ticked
        //change the answer point to 0 if it is

        if (!tickFour && tickOne && !tickThree && !ticktwo){
            A = 0;
            nextPage (A, intent);
        }

        //test if tick two is ticked
        //change the answer point to 0 if it is
        else if (!tickFour && !tickOne && !tickThree && ticktwo){
            A = 0;
            nextPage (A, intent);
        }

        //test if tick three is ticked
        //change the answer point to 0 if it is

        else if (!tickFour && !tickOne && tickThree && !ticktwo) {
            A = 0;
            nextPage (A, intent);
        }

        //check if only tick four is ticked
        //change the answer point to 1 if it is

        else if (tickFour && !tickOne && !tickThree && !ticktwo) {
            A = 1;
            nextPage (A, intent);
        }
        // if more than one is ticked!

        else
            Toast.makeText(this, "only tick one answer!", Toast.LENGTH_SHORT).show();
        }
    private void nextPage (int A, Intent intent) {
        intent.putExtra("A", A);
        startActivity(intent);
    }

}
