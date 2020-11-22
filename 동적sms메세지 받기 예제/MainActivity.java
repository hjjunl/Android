package com.example.hw6;
//manifest파일에 이 두개의 permission 추가해줘야함
//    <uses-permission android:name="android.permission.READ_SMS"/>
//    <uses-permission android:name="android.permission.RECEIVE_SMS"/>

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver mFileDownloadedReceiver=null;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");


            if(checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS,
                    Manifest.permission.READ_SMS},1);
        }


        mFileDownloadedReceiver=new BroadcastReceiver(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceive(Context context, Intent intent) {

                Bundle bundle = intent.getExtras();
                String str = ""; // 출력할 문자열 저장
                Object [] pdus = (Object[])bundle.get("pdus");
                SmsMessage [] msgs
                        = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    // PDU 포맷으로 되어 있는 메시지를 복원합니다.
                    msgs[i] = SmsMessage
                            .createFromPdu((byte[]) pdus[i]);
                    str += msgs[i].getMessageBody().toString();
                }
                Toast.makeText(context,"SNS가 도착하였습니다 \n"+ str, Toast.LENGTH_LONG).show();


            }
        };
        registerReceiver(mFileDownloadedReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mFileDownloadedReceiver);
        super.onDestroy();

    }

}
