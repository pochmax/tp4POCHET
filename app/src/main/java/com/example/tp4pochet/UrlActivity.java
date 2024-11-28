package com.example.tp4pochet;

import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class UrlActivity extends AppCompatActivity {

    Button okButton, cancelButton;
    EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        okButton = findViewById(R.id.ok);
        cancelButton = findViewById(R.id.cancel);
        urlEditText = findViewById(R.id.url);

        okButton.setOnClickListener(v -> {
            String url = urlEditText.getText().toString();
            if(url.length() == 0){
                Toast.makeText(this, "Veuillez saisir une url", Toast.LENGTH_SHORT).show();
            }else if(url.matches("^(http|https)://.*$")){
                Intent intentionWeb = new Intent(Intent.ACTION_VIEW);
                intentionWeb.setAction(Intent.ACTION_VIEW);
                Uri uriWeb = Uri.parse(url);
                intentionWeb.setData(uriWeb);
                try {
                    startActivity(intentionWeb);
                }catch (ActivityNotFoundException e){
                    System.out.println(e.getMessage());
                }
                startActivity(intentionWeb);
            }else {
                Toast.makeText(this, "L'url saisi n'est pas valide", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(v -> finish());

    }
}
