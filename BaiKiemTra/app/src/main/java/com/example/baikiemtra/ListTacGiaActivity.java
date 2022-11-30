package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListTacGiaActivity extends AppCompatActivity {
    ListView lvTacGia;
    ArrayList<TacGia> tacGiaArrayList;
    AdapterTacGia adapterTacGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tac_gia);
        lvTacGia =(ListView) findViewById(R.id.listView);
        tacGiaArrayList = new ArrayList<>();
        tacGiaArrayList.add(new TacGia(R.drawable.huycan,"Huy Cận","Nhà văn","Việt Nam","5 Sao"));
        tacGiaArrayList.add(new TacGia(R.drawable.macngon,"Mạc Ngôn","Nhà Văn","Trung Quốc","4.5 Sao"));
        tacGiaArrayList.add(new TacGia(R.drawable.hemingway,"Hemingway","Nhà văn","Anh","4.5 Sao"));
        tacGiaArrayList.add(new TacGia(R.drawable.snakespeare,"Snakespeare","Nhà văn","Pháp","4.5 Sao"));
        tacGiaArrayList.add(new TacGia(R.drawable.tohuu,"Tố Hữu","Nhà văn","Việt Nam","5 Sao"));

        adapterTacGia = new AdapterTacGia(ListTacGiaActivity.this,R.layout.custom_line_tacgia, tacGiaArrayList);
        lvTacGia.setAdapter(adapterTacGia);

        lvTacGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListTacGiaActivity.this, DetailMainActivity.class);
                intent.putExtra("tg",tacGiaArrayList.get(i).getTen());
                startActivity(intent);
            }
        });
    }
}