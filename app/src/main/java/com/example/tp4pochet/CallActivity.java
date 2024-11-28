package com.example.tp4pochet;

import android.content.ActivityNotFoundException;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

import android.net.Uri;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CallActivity extends AppCompatActivity {

    Button okButton, cancelButton;
    EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        okButton = findViewById(R.id.ok);
        cancelButton = findViewById(R.id.cancel);
        phoneNumberEditText = findViewById(R.id.phone_number);

        okButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            if (phoneNumber.length() == 0) {
                Toast.makeText(this, "Veuillez saisir un numéro", Toast.LENGTH_SHORT).show();
            }else if(phoneNumber.matches("^[0-9]*$")){
                Intent intentionCall = new Intent(Intent.ACTION_DIAL);
                intentionCall.setAction(Intent.ACTION_DIAL);
                Toast.makeText(this, phoneNumber, Toast.LENGTH_SHORT).show();
                Uri uriCall = Uri.parse("tel:" + phoneNumber);
                intentionCall.setData(uriCall);
                try {
                    startActivity(intentionCall);

                }catch(ActivityNotFoundException e){
                    System.out.println(e.getMessage());
                }


            } else{
                Toast.makeText(this, "Le numéro saisi n'est pas valide", Toast.LENGTH_SHORT).show();
            };
        });
        cancelButton.setOnClickListener(v -> finish());
    }


}
