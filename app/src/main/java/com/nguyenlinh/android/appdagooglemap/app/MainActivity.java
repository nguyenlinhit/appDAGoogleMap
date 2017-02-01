package com.nguyenlinh.android.appdagooglemap.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.nguyenlinh.android.appdagooglemap.adapter.NhaHangAdapter;
import com.nguyenlinh.android.appdagooglemap.model.NhaHang;
import com.nguyenlinh.android.appdagooglemap.model.SQLDatasource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnMap;
    ListView lvNhaHang;
    ArrayList<NhaHang> dsNhaHang = null;
    NhaHangAdapter nhaHangAdapter;

    SQLDatasource db;

    int requestCode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            addControls();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addEvents();

    }

    private void addEvents() {
        lvNhaHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Bundle bundle = new Bundle();
                //NhaHang nhaHang = dsNhaHang.get(position);
                int ma = dsNhaHang.get(position).getMa();
                requestCode = 1;
                //Double vido = dsNhaHang.get(position).getVido();
                //Double kinhdo = dsNhaHang.get(position).getKinhdo();
                //String ten = dsNhaHang.get(position).getTen();
                //Bitmap anh = dsNhaHang.get(position).getHinh();

                //ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //anh.compress(Bitmap.CompressFormat.PNG,100,baos);
                //byte[] bp = baos.toByteArray();
                //String enCodeImage = Base64.encodeToString(bp,Base64.DEFAULT);
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                //intent.putExtra("VIDO",vido);
                //intent.putExtra("KINHDO",kinhdo);
                //intent.putExtra("TEN",ten);
                //intent.putExtra("IMG",enCodeImage);
                intent.putExtra("CODE",requestCode);
                intent.putExtra("MA",ma);
                //bundle.putSerializable("NHAHANG",nhaHang);
                //intent.putExtra("BUNDLE",bundle);

                startActivity(intent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                requestCode = 0;
                intent.putExtra("CODE_VTHT",requestCode);
                startActivity(intent);
            }
        });
    }

    private void addControls() throws IOException {
        db = new SQLDatasource(MainActivity.this);
        lvNhaHang = (ListView) findViewById(R.id.lvNhaHang);
        dsNhaHang = db.showAllNhaHang();

        nhaHangAdapter = new NhaHangAdapter(MainActivity.this,
                R.layout.item,
                dsNhaHang);
        lvNhaHang.setAdapter(nhaHangAdapter);
        nhaHangAdapter.notifyDataSetInvalidated();

        btnMap = (Button) findViewById(R.id.btnMap);
    }

}
