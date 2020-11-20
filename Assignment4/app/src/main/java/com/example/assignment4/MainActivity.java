package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tv = null;
    Button btn = null;
    int count = 0;
    int count1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView pizza_view=(TextView)findViewById(R.id.pizza_num);
        final TextView toast_view=(TextView)findViewById(R.id.toast_num);
        imageView = (ImageView) findViewById(R.id.imageview);

        Button button = (Button) findViewById(R.id.button);
        Button plus_pizza_Button = (Button) findViewById(R.id.plus_pizza_Button);
        Button minus_pizza_Button = (Button)findViewById(R.id.minus_pizza_Button);

        Button plus_toast_Button=(Button)findViewById(R.id.plus_toast_Button);
        Button minus_toast_Button= (Button)findViewById(R.id.minus_toast_Button);

        plus_toast_Button.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    count1++;
                toast_view.setText(""+count1);
            }
        }));

        minus_toast_Button.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(count1>0)
                    count1--;
                toast_view.setText(""+count1);
            }
        }));

        minus_pizza_Button.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(count>0)
                count--;
                pizza_view.setText(""+count);
            }
        }));

        plus_pizza_Button.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                count++;
                pizza_view.setText(""+count);
            }
        }));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("pizza", "피자: ");
                intent.putExtra("pizzanum", count);
                intent.putExtra("toast", "샌드위치: ");
                intent.putExtra("toastnum", count1);
                intent.putExtra("sum", "총 가격: ");
                intent.putExtra("price", count*100+count1*250);
                startActivity(intent);
            }
        });


    }
    }
