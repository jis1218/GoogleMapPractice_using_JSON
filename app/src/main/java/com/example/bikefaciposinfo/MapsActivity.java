package com.example.bikefaciposinfo;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.bikefaciposinfo.model.BikeFacilPosition;
import com.example.bikefaciposinfo.model.Row;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        load();

        // 맵이 사용할 준비가 되었으면 -> onMapReady 를 호출
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

    private void load(){
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                return Remote.getData("http://openapi.seoul.go.kr:8088/686a766b466a697334385a717a6e51/json/GeoInfoBikeConvenientFacilitiesWGS/1/50");
            }

            @Override
            protected void onPostExecute(String s) {
                Gson gson = new Gson();
                BikeFacilPosition pos = gson.fromJson(s, BikeFacilPosition.class);
                rows = pos.getGeoInfoBikeConvenientFacilitiesWGS().getRow();

                // 맵이 사용할 준비가 되어 있는지를 비동기로 확인하는 작업
                mapFragment.getMapAsync(MapsActivity.this);
            }


        }.execute();
    }
    //좌표 데이터를 저장하기 위한 저장소
    List<Row> rows;
    // 데이터를 사용해서 마크를 각 좌표에 출력력
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng lng = null;

        // Add a marker in Sydney and move the camera
        for(Row row : rows){
            lng = new LatLng(Double.parseDouble(row.getLAT()), Double.parseDouble(row.getLNG()));
            mMap.addMarker(new MarkerOptions().position(lng).title(row.getCLASS()));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, 14));
    }
}
