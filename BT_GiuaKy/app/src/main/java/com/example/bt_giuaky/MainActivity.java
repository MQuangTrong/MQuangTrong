package com.example.bt_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usertxt, passtxt;
    Button signinbtn;
    TextView signuptv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        controlButton();
    }

    private void controlButton(){
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usertxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(usertxt.getText().toString().equals("abc") && passtxt.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                        usertxt.setText("");
                        passtxt.setText("");
                    }
                }
            }
        });

        signuptv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_DangKy.class);
                startActivity(intent);
            }
        });
    }


    private void AnhXa() {
        usertxt = (EditText) findViewById(R.id.usertxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        signinbtn = (Button) findViewById(R.id.signinbtn);
        signuptv = (TextView) findViewById(R.id.signuptv);
    }
}