package com.example.tp4pochet;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

import android.os.Bundle;

import android.net.Uri;

public class SmsMmsActivity extends AppCompatActivity {

    Button okButton, cancelButton;
    EditText phoneNumberEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_mms);

        okButton = findViewById(R.id.ok);
        cancelButton = findViewById(R.id.cancel);
        phoneNumberEditText = findViewById(R.id.phone_number);
        messageEditText = findViewById(R.id.message);

        okButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            String message = messageEditText.getText().toString();
            if (phoneNumber.length() == 0) {
                Toast.makeText(this, "Veuillez saisir un numéro", Toast.LENGTH_SHORT).show();
            } else if (message.length() == 0) {
                Toast.makeText(this, "Veuillez saisir un message", Toast.LENGTH_SHORT).show();
            }else if(phoneNumber.matches("^[0-9]*$")){
                Intent intentionSms = new Intent(Intent.ACTION_SENDTO);
                intentionSms.setAction(Intent.ACTION_SENDTO);
                Uri uriSms = Uri.parse("sms:" + phoneNumber);
                intentionSms.putExtra("sms_body", message);
                intentionSms.setData(uriSms);
            } else{
                Toast.makeText(this, "Le numéro saisi n'est pas valide", Toast.LENGTH_SHORT).show();
            }
        });
        cancelButton.setOnClickListener(v -> finish());
    }
}
