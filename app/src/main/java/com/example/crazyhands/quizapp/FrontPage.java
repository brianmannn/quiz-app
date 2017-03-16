package com.example.crazyhands.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class FrontPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);



        //find the view that shows the numbers catagory
        TextView numbers = (TextView) findViewById(R.id.start);
        //set a click listener on that view and then tell it what to do when clicked
        numbers.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent quetionOneIntent = new Intent(FrontPage.this, quetion_one.class);
                startActivity(quetionOneIntent);
            }
        });

    }





    }




