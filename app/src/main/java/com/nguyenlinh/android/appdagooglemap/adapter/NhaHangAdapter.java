package com.nguyenlinh.android.appdagooglemap.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenlinh.android.appdagooglemap.app.R;
import com.nguyenlinh.android.appdagooglemap.model.NhaHang;

import java.util.List;

/**
 * Created by nguye on 1/28/2017.
 */

public class NhaHangAdapter extends ArrayAdapter<NhaHang> {
    Activity context;
    int resource;
    List<NhaHang> objects;
    public NhaHangAdapter(Activity context, int resource, List<NhaHang> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        ImageView imgHinh = (ImageView) row.findViewById(R.id.btnAnh);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTenNH);

        NhaHang nhaHang = this.objects.get(position);

        imgHinh.setImageBitmap(nhaHang.getHinh());
        txtTen.setText(nhaHang.getTen());
        return row;
    }

    
}
