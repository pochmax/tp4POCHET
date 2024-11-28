package com.example.tp4pochet;

import android.content.ActivityNotFoundException;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class GeoActivity extends AppCompatActivity {
    Button okButton, cancelButton;
    EditText latEditText, lngEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        okButton = findViewById(R.id.ok);
        cancelButton = findViewById(R.id.cancel);
        latEditText = findViewById(R.id.lat);
        lngEditText = findViewById(R.id.lng);

        // on click listener for the ok button create intent for geo and start activity
        okButton.setOnClickListener(v -> {
            String lat = latEditText.getText().toString();
            String lng = lngEditText.getText().toString();
            // regex for double type checking
            if (lat.length() == 0) {
                Toast.makeText(this, "Veuillez saisir une latitude", Toast.LENGTH_SHORT).show();
            } else if (lng.length() == 0) {
                Toast.makeText(this, "Veuillez saisir une longitude", Toast.LENGTH_SHORT).show();
            }else if(lat.matches("^([+-]?\\d*\\.?\\d*)$") && lng.matches("^([+-]?\\d*\\.?\\d*)$")){
                Intent intentionGeo = new Intent(Intent.ACTION_VIEW);
                intentionGeo.setAction(Intent.ACTION_VIEW);
                Uri uriGeo = Uri.parse("geo:" + lat + "," + lng);
                intentionGeo.setData(uriGeo);
                try {
                    startActivity(intentionGeo);
                }catch (ActivityNotFoundException e){
                    System.out.println(e.getMessage());
                }
            } else{
                Toast.makeText(this, "Les coordonnées saisies ne sont pas valides", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(v -> finish());

    }
}
