package com.nguyenlinh.android.appdagooglemap.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nguyenlinh.android.appdagooglemap.adapter.CustomAdapter;
import com.nguyenlinh.android.appdagooglemap.model.NhaHang;
import com.nguyenlinh.android.appdagooglemap.model.SQLDatasource;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SQLDatasource db = new SQLDatasource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent intent = getIntent();
        //Double vido = intent.getDoubleExtra("VIDO",0.0);
        //Double kinhdo = intent.getDoubleExtra("KINHDO",0.0);
        //Bundle bundle = intent.getBundleExtra("BUNDLE");
        //NhaHang nhaHang = (NhaHang) bundle.getSerializable("NHAHANG");
        //NhaHang nhaHang = (NhaHang) intent.getSerializableExtra("NHAHANG");
        //NhaHang nhaHang = new NhaHang();

        //Bundle ex = getIntent().getExtras();
        //Bitmap hinh = ex.getParcelable("IMG");
        int ma = intent.getIntExtra("MA",0);
        //String ten = intent.getStringExtra("TEN");
        //String encodeArrImage = intent.getStringExtra("IMG");
        //byte[] encodeByte = Base64.decode(encodeArrImage,Base64.DEFAULT);
        //Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte,0,encodeByte.length);
        NhaHang nhaHang = db.locNhaHangTheoMa(ma).get(0);
        //Toast.makeText(this,encodeArrImage,Toast.LENGTH_LONG).show();

        // Add a marker in Sydney and move the camera
        //LatLng lc = new LatLng(nhaHang.getVido(), nhaHang.getKinhdo());
        LatLng lc = new LatLng(nhaHang.getVido(), nhaHang.getKinhdo());
        Marker marker = mMap.addMarker(new MarkerOptions().position(lc).title(nhaHang.getTen()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lc,16));
        mMap.setInfoWindowAdapter(new CustomAdapter(MapsActivity.this,nhaHang));
        marker.showInfoWindow();
    }
}
