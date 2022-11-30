package com.example.baikiemtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterTacGia extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TacGia> tacGiaList;

    public AdapterTacGia(Context context, int layout, List<TacGia> tacGiaList) {
        this.context = context;
        this.layout = layout;
        this.tacGiaList = tacGiaList;
    }

    @Override
    public int getCount() {
        return tacGiaList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= layoutInflater.inflate(layout,null);
        // anh xa view
        ImageView imgView =(ImageView) view.findViewById(R.id.imgTacGia);
        TextView txtTenTacGia= (TextView) view.findViewById(R.id.txt_tenTacGia);
        TextView txtMoTa= (TextView) view.findViewById(R.id.txt_MoTa);
        TextView txtQuocGia= (TextView) view.findViewById(R.id.txt_quocGia);
        TextView txtSoSao= (TextView) view.findViewById(R.id.txt_soSao);

        TacGia caSi = tacGiaList.get(i);
        imgView.setImageResource(caSi.getHinhAnh());
        txtTenTacGia.setText(caSi.getTen());
        txtMoTa.setText(caSi.getNgheDanh());
        txtQuocGia.setText(caSi.getQuocGia());
        txtSoSao.setText(caSi.getSoSao());
        return view;
    }
}
