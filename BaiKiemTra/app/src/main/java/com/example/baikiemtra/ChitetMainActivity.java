package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChitetMainActivity extends AppCompatActivity {
    TextView txtTacPham, txtChiTiet;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitet_main);
        txtTacPham = (TextView) findViewById(R.id.txtTacPham);
        txtChiTiet = (TextView) findViewById(R.id.txtChiTiet);
        back = (ImageView) findViewById(R.id.back);

        Intent intent = getIntent();
        txtTacPham.setText(intent.getStringExtra("tp"));

        if (txtTacPham.getText().toString().equals("Việt Bắc")){
            txtChiTiet.setText(ChiTietbaiTho.vietbac);
        } else if(txtTacPham.getText().toString().equals("Bầm ơi")){
            txtChiTiet.setText(ChiTietbaiTho.bamoi);
        }else if(txtTacPham.getText().toString().equals("Mưa rơi")){
            txtChiTiet.setText(ChiTietbaiTho.muaroi);
        }else if(txtTacPham.getText().toString().equals("Một tiếng đờn")){
            txtChiTiet.setText(ChiTietbaiTho.mottiengdon);
        }else if(txtTacPham.getText().toString().equals("Ta đi tới")){
            txtChiTiet.setText(ChiTietbaiTho.taditoi);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChitetMainActivity.this, ListTacGiaActivity.class));
            }
        });

    }
}