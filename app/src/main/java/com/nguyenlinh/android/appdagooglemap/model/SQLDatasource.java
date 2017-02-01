package com.nguyenlinh.android.appdagooglemap.model;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.nguyenlinh.android.appdagooglemap.app.MainActivity;

import java.util.ArrayList;



/**
 * Created by nguye on 1/29/2017.
 */

public class SQLDatasource {
    private DatabaseCoppy db;

    public SQLDatasource(){

    }

    public SQLDatasource(Context context){
        db = new DatabaseCoppy(context);
        db.xuLySaoChepCSDL();
    }

    public ArrayList<NhaHang> showAllNhaHang(){
        ArrayList<NhaHang> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase(db.LayDuongDanLuuTru(),null,null);
        Cursor cursor = db.database.rawQuery("select * from NhaHang",null);
        while (cursor.moveToNext()){
            NhaHang nhaHang = new NhaHang();
            nhaHang.setMa(cursor.getInt(0));
            nhaHang.setTen(cursor.getString(1));
            byte[] byteHhinh = cursor.getBlob(2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteHhinh,0,byteHhinh.length);
            nhaHang.setHinh(bitmap);
            nhaHang.setVido(cursor.getDouble(3));
            nhaHang.setKinhdo(cursor.getDouble(4));
            list.add(nhaHang);
        }

        //cursor.close();
        return list;
    }

    public ArrayList<NhaHang> locNhaHangTheoMa(int ma){
        ArrayList<NhaHang> list = new ArrayList<>();
        db.database = SQLiteDatabase.openOrCreateDatabase("/data/data/com.nguyenlinh.android.appdagooglemap.app/databases/NhaHangDB.sqlite",null,null);
        Cursor cursor = db.database.rawQuery("SELECT * FROM NhaHang where ma = " + ma,null);
        while (cursor.moveToNext()){
            NhaHang nhaHang = new NhaHang();
            nhaHang.setMa(cursor.getInt(0));
            nhaHang.setTen(cursor.getString(1));
            byte[] byteHhinh = cursor.getBlob(2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteHhinh,0,byteHhinh.length);
            nhaHang.setHinh(bitmap);
            nhaHang.setVido(cursor.getDouble(3));
            nhaHang.setKinhdo(cursor.getDouble(4));
            list.add(nhaHang);
        }
        return list;
    }

}
