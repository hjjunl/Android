package com.example.assignment5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivityb);

        Bundle bundle=getIntent().getBundleExtra("go");
        TextView textView= (TextView)findViewById(R.id.countText);
        textView.setText("입력받은시간은"+bundle.getInt("SUMM")+"입니다.");
    }
}
//public class BActivity extends BroadcastReceiver {
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String actionName= intent.getAction();
//        String F= intent.getStringExtra("FILE_NAME");
//        Toast.makeText(context, "입력받은 시간은"+F, Toast.LENGTH_LONG).show();;
//    }
//}
