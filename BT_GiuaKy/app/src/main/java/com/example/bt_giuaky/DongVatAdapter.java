package com.example.bt_giuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DongVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Dong_vat> dongVatList;

    public DongVatAdapter(Context context, int layout, List<Dong_vat> dongVatList) {
        this.context = context;
        this.layout = layout;
        this.dongVatList = dongVatList;
    }

    @Override
    public int getCount() {
        return dongVatList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Dong_vat dongVat = dongVatList.get(i);
        holder.txtTen.setText(dongVat.getTen());
        holder.txtMoTa.setText(dongVat.getMoTa());
        holder.imgHinh.setImageResource(dongVat.getHinh());

        return view;
    }
}
