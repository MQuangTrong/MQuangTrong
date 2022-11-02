package com.example.bt_cuoiky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class DongVat extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    FloatingActionButton floatingActionButton;
    DongVatAdapter dongVatAdapter;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_vat);

        recyclerView = (RecyclerView) findViewById(R.id.rcv_covu);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        searchView = (SearchView) findViewById(R.id.search_view);
        back = (LinearLayout) findViewById(R.id.back);
        searchView.clearFocus();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<DongVatModel> options =
                new FirebaseRecyclerOptions.Builder<DongVatModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("dongvat"), DongVatModel.class)
                        .build();
        dongVatAdapter = new DongVatAdapter(options, this);
        recyclerView.setAdapter(dongVatAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DongVat.this, GiaoDienChinh.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });

    }

    protected void onStart() {
        super.onStart();
        dongVatAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dongVatAdapter.stopListening();
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<DongVatModel> options =
                new FirebaseRecyclerOptions.Builder<DongVatModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("dongvat").orderByChild("ten").startAt(str).endAt(str+"~"), DongVatModel.class)
                        .build();
        dongVatAdapter = new DongVatAdapter(options, this);
        dongVatAdapter.startListening();
        recyclerView.setAdapter(dongVatAdapter);
    }

}