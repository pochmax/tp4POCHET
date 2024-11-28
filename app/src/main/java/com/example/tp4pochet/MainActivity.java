package com.example.tp4pochet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button callButton, smsButton, mmsButton, webButton, geoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        callButton = findViewById(R.id.call);
        smsButton = findViewById(R.id.sms);
        mmsButton = findViewById(R.id.mms);
        webButton = findViewById(R.id.web);
        geoButton = findViewById(R.id.geo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        callButton.setOnClickListener(v -> onButtonClick(callButton));
        smsButton.setOnClickListener(v -> onButtonClick(smsButton));
        mmsButton.setOnClickListener(v -> onButtonClick(mmsButton));
        webButton.setOnClickListener(v -> onButtonClick(webButton));
        geoButton.setOnClickListener(v -> onButtonClick(geoButton));
    }

    private void onButtonClick(Button button) {;

        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "APPELER":
                Intent intentionCall = new Intent(this, CallActivity.class);
                startActivity(intentionCall);
                break;

            case "SMS":
                Intent intentionSms = new Intent(this, SmsMmsActivity.class);
                startActivity(intentionSms);
                break;

            case "MMS":
                Intent intentionMms = new Intent(this, SmsMmsActivity.class);
                startActivity(intentionMms);
                break;

            case "WEB":
                Intent intentionWeb = new Intent(this, UrlActivity.class);
                startActivity(intentionWeb);
                break;

            case "GEO":
                Intent intentionGeo = new Intent(this, GeoActivity.class);
                startActivity(intentionGeo);
                break;

        }

        Toast.makeText(this, buttonText, Toast.LENGTH_SHORT).show();
    }

}