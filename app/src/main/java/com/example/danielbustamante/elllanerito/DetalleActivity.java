package com.example.danielbustamante.elllanerito;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetalleActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapView mapView;
    GoogleMap mMap;
    String nombre="";
    String Copa="Dir: Cra. 58 #58-1 a 58-345, Copacabana ",
    pilarica="Dir: Calle 73 #, Cra. 72ab #47, Medellín, ",
    centro="Dir: carrera 50 # 49 06, Carrera 50 #49 06, Medellín",
    llan="Dir: cra 67b-102, Cl. 51 #67b-42, Medellín,",
    sabaneta="Dir: #45-, Cl. 77 Sur #43a107, Sabaneta";
    private TextView tInfo, tTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tInfo= findViewById(R.id.tInfo);
        tTitulo = findViewById(R.id.tTitulo);




      Bundle intent = getIntent().getExtras();
         nombre= intent.getString("Nombre");
tTitulo.setText(nombre);
        mapView = (MapView) findViewById(R.id.map);
        try {
            mapView.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);



        if (nombre.equals("Llanerito Copacabana")) {
            tInfo.setText(Copa);
        }else if (nombre.equals("Llanerito Pilarica")) {
           tInfo.setText(pilarica);
        }else if (nombre.equals("Llanerito Centro")) {
tInfo.setText(centro);

        }else if (nombre.equals("Llanerito los Colores")){
tInfo.setText(llan);

        }else if (nombre.equals("Llanerito Sabaneta")){
tInfo.setText(sabaneta);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


        if (nombre.equals("Llanerito Copacabana")) {

            LatLng llanCopa = new LatLng(6.3460067, -75.5216115);
            mMap.addMarker(new MarkerOptions().
                    position(llanCopa).
                    title("Llanerito Copacabana")
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault))
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(llanCopa,15));
        }else if (nombre.equals("Llanerito Pilarica")) {
            LatLng pilarica = new LatLng(6.2762677, -75.5833026);
            mMap.addMarker(new MarkerOptions().
                    position(pilarica).
                    title("Llanerito Pilarica").
                    icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pilarica,15));
        }else if (nombre.equals("Llanerito Centro")) {

            LatLng centro = new LatLng(6.2485118, -75.56844);
            mMap.addMarker(new MarkerOptions().
                    position(centro).
                    title("Llanerito Centro").
                    icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centro,15));
        }else if (nombre.equals("Llanerito los Colores")){

        LatLng llancol = new LatLng(6.2991149,-75.5928205);
        mMap.addMarker(new MarkerOptions().
                position(llancol).
                title("Llanerito los Colores").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(llancol,15));

        }else if (nombre.equals("Llanerito Sabaneta")){

        LatLng BAN   = new LatLng(6.1478445,-75.621189  );
        mMap.addMarker(new MarkerOptions().
                position(BAN).
                title("Llanerito Sabaneta").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BAN,15));
        }



        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);






    }

    @Override
    protected void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
