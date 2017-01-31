package com.nguyenlinh.android.appdagooglemap.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.nguyenlinh.android.appdagooglemap.app.R;
import com.nguyenlinh.android.appdagooglemap.model.NhaHang;

/**
 * Created by nguye on 1/28/2017.
 */

public class CustomAdapter implements GoogleMap.InfoWindowAdapter {
    Activity context;
    NhaHang nhaHang;

    public CustomAdapter(Activity context, NhaHang nhaHang){
        this.context = context;
        this.nhaHang = nhaHang;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.item_nhahang,null);
        ImageView imgHinh = (ImageView) row.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);

        imgHinh.setImageBitmap(nhaHang.getHinh());
        txtTen.setText(nhaHang.getTen());

        return row;
    }
}
