package com.example.danielbustamante.elllanerito;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment  implements OnMapReadyCallback {
    MapView mapView;
    GoogleMap mMap;
    View mView;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =inflater.inflate(R.layout.fragment_mapa, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView)mView.findViewById(R.id.map);
        if (mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mMap = googleMap;


        // Add a marker in Sydney and move the camera


        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
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

        LatLng llanCopa = new LatLng(6.3460067,-75.5216115);
        mMap.addMarker(new MarkerOptions().
                position(llanCopa).
                title("Llanerito Copacabana")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault))
        );

        LatLng pilarica = new LatLng(6.2762677,-75.5833026);
        mMap.addMarker(new MarkerOptions().
                position(pilarica).
                title("Llanerito Pilarica").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));

        LatLng centro = new LatLng(6.2485118,-75.56844);
        mMap.addMarker(new MarkerOptions().
                position(centro).
                title("Llanerito Centro").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));

        LatLng llan = new LatLng(6.2530139,-75.5833856);
        mMap.addMarker(new MarkerOptions().
                position(llan).
                title("Llanerito los Colores").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));

        LatLng BAN   = new LatLng(6.1478445,-75.621189  );
        mMap.addMarker(new MarkerOptions().
                position(BAN).
                title("Llanerito Sabaneta").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.hqdefault)));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(llan,10));


    }
}
