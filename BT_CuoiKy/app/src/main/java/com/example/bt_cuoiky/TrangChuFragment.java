package com.example.bt_cuoiky;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class TrangChuFragment extends Fragment {
    GridView gridView;
    ArrayList<LoaiDongVat> loaiDongVatArray;
    LoaiDongVatAdapter loaiDongVatAdapter;
    VideoView videoView;
    ImageButton imageButton;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trang_chu_fragment,container,false);
        gridView = (GridView) view.findViewById(R.id.gv_ldv);
        videoView = (VideoView) view.findViewById(R.id.videoview);
        imageButton = (ImageButton) view.findViewById(R.id.ib_play);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setVisibility(View.INVISIBLE);
                videoView.setVideoURI(Uri.parse("android.resource://com.example.bt_cuoiky/raw/"+R.raw.animal));
                videoView.start();
                MediaController mc = new MediaController(getActivity());
                mc.setMediaPlayer(videoView);
                videoView.setMediaController(mc);
            }
        });
        DanhSach();
        loaiDongVatAdapter = new LoaiDongVatAdapter(getContext(), R.layout.gridview_item, loaiDongVatArray);
        gridView.setAdapter(loaiDongVatAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), DongVat.class));
            }
        });
        return view;
    }

    private void DanhSach() {
        loaiDongVatArray = new ArrayList<>();
        loaiDongVatArray.add(new LoaiDongVat("Loài có vú", R.drawable.dvcovu));
        loaiDongVatArray.add(new LoaiDongVat("Loài cá", R.drawable.ca));
        loaiDongVatArray.add(new LoaiDongVat("Loài Chim", R.drawable.chim));
        loaiDongVatArray.add(new LoaiDongVat("Loài lưỡng cư", R.drawable.luongcu));
        loaiDongVatArray.add(new LoaiDongVat("Loài bò sát", R.drawable.bosat));
    }
}