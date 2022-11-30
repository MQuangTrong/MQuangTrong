package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailMainActivity extends AppCompatActivity {
    TextView txtTacGia;
    ListView lvTacPham;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_main);

        txtTacGia = (TextView) findViewById(R.id.txtTacGia);
        lvTacPham = (ListView) findViewById(R.id.lvTacPham);
        Intent intent = getIntent();
        txtTacGia.setText(intent.getStringExtra("tg"));

        arrayList = new ArrayList<>();
        arrayList.add("Việt Bắc");
        arrayList.add("Bầm ơi");
        arrayList.add("Mưa rơi");
        arrayList.add("Một tiếng đờn");
        arrayList.add("Ta đi tới");

        ArrayAdapter adapter = new ArrayAdapter(DetailMainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lvTacPham.setAdapter(adapter);

        lvTacPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(DetailMainActivity.this, ChitetMainActivity.class);
                intent1.putExtra("tp", arrayList.get(i));
                startActivity(intent1);
            }
        });

    }
}