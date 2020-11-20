package com.example.assignment4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ImageView imageview = (ImageView) findViewById(R.id.imageview);
        TextView textview = (TextView) findViewById(R.id.textview);

        Bundle extras = getIntent().getExtras();
        String pizza = extras.getString("pizza");
        int pizzanum= extras.getInt("pizzanum");
        String toast = extras.getString("toast");
        int toastnum= extras.getInt("toastnum");
        String sum = extras.getString("sum");
        int price= extras.getInt("price");


        String str = pizza + pizzanum+" " + toast + toastnum + "\n"+ sum+price;
        textview.setText(str);

    }

}