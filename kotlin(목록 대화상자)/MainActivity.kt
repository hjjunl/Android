package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var tvName : TextView
    lateinit var tvEmail : TextView
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dilaogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"
        tvName = findViewById<TextView>(R.id.tvName)
        tvEmail = findViewById<TextView>(R.id.tvEmail)
        button1 = findViewById<Button>(R.id.button1);
        button1.setOnClickListener{
            dilaogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_launcher_foreground)
            dlg.setView(dilaogView)
            dlg.setPositiveButton("확인"){ dialog, which ->
                dlgEdtName = dilaogView.findViewById<EditText>(R.id.dlgEdt1)
                dlgEdtEmail= dilaogView.findViewById<EditText>(R.id.dlgEdt2)

                tvName.text = dlgEdtName.text.toString()
                tvEmail.text = dlgEdtEmail.text.toString()
            }
            dlg.setNegativeButton("취소"){ dialog, which ->
                var toast = Toast(this@MainActivity)
                toastView =View.inflate(this@MainActivity, R.layout.toast1, null)
                toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toastText.text = "취소했습니다"
                toast.view =toastView
                toast.show()
            }
            dlg.show()
        }

    }
}