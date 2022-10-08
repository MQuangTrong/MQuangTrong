package com.example.bt_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chitiet extends AppCompatActivity {
    LinearLayout nenct;
    ImageView btnback, iv_anhct;
    TextView tenct, tinhtrang, mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        nenct = (LinearLayout) findViewById(R.id.nen_ct);
        btnback = (ImageView) findViewById(R.id.back_btn);
        iv_anhct = (ImageView) findViewById(R.id.iv_anh_ct);
        tenct = (TextView) findViewById(R.id.ten_ct);
        tinhtrang = (TextView) findViewById(R.id.tinhtrang);
        mota = (TextView) findViewById(R.id.thongtin_ct);
        btnback = (ImageView)findViewById(R.id.back_btn);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(chitiet.this, MainActivity2.class));
            }
        });
        Intent intent1 = getIntent();
        tenct.setText(intent1.getStringExtra("ten"));
        mota.setText(intent1.getStringExtra("mota"));
        tinhtrang.setText(intent1.getStringExtra("tinhtrang"));
        switch (tinhtrang.getText().toString()){
            case "Nguy cấp":
                tinhtrang.setBackgroundColor(getResources().getColor(R.color.nguyhiem));
                break;

            case "Sắp nguy cấp":
                tinhtrang.setBackgroundColor(getResources().getColor(R.color.sapnguyhiem));
                break;

            case "Ít quan tâm":
                tinhtrang.setBackgroundColor(getResources().getColor(R.color.it));
                break;

            case "Cực kỳ nguy cấp":
                tinhtrang.setBackgroundColor(getResources().getColor(R.color.cucnguyhiem));
                break;

            case "Sắp bị đe dọa":
                tinhtrang.setBackgroundColor(getResources().getColor(R.color.sapdedoa));
                break;
        }
        nenct.setBackgroundResource(intent1.getIntExtra("anh",0));
        iv_anhct.setImageResource(intent1.getIntExtra("anh",0));
    }
}