package com.frankmascia.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel= new ColorWheel();
    //1.) First Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //2.) Assign the views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton=(Button) findViewById(R.id.showFactButton);
        mRelativeLayout=(RelativeLayout) findViewById(R.id.RelativeLayout);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3.)Use the new Variables in some sort of action
                String fact = mFactBook.getFact();
                int color= mColorWheel.getColor();
                //Update the screen with our dynamic fact
                mFactTextView.setText(fact);
                //Use this new view to set background color on click
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }//End on Click
        };
        mShowFactButton.setOnClickListener(listener);

    }
}
