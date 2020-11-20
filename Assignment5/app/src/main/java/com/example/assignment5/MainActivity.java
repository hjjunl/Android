package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int random= (int)(Math.random()*5);
    int mCount=0;
    int value=0;
    TextView Timer1;
    private Object Context;
    EditText editText;
    TextView randomwords1;
    @Override
    protected void onResume() {
        int random= (int)(Math.random()*5);
        super.onResume();
        mCount=0;
        editText.setText("");
        if (random==0)
            randomwords1.setText("hello");
        else if(random==1)
            randomwords1.setText("android");
        else if (random==2)
            randomwords1.setText("ILoveSabit");
        else if (random==3)
            randomwords1.setText("DoHomework");
        else if (random==4)
            randomwords1.setText("F");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send= (Button)findViewById(R.id.send);
        editText= (EditText)findViewById(R.id.write);
        randomwords1=(TextView)findViewById(R.id.randomword1);

        Timer1=(TextView)findViewById(R.id.Timer);

        if (random==0)
            randomwords1.setText("hello");
        else if(random==1)
            randomwords1.setText("android");
        else if (random==2)
            randomwords1.setText("ILoveSabit");
        else if (random==3)
            randomwords1.setText("DoHomework");
        else if (random==4)
            randomwords1.setText("F");

        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        t.start();

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(randomwords1.getText().toString()) ) {
                    Intent intent= new Intent(MainActivity.this, BActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("SUMM",mCount);
                    intent.putExtra("go",bundle);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "틀렸습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){
                Timer1.setText("Timer: "+mCount);
            }
        }
    };
    class MyThread implements Runnable{
        @Override
        public void run() {
            while(true){
                handler.sendEmptyMessage(0);
                mCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}