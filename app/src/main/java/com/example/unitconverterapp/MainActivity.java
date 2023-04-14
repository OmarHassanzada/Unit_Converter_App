package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    public void TemperatureClick(View view)
    {
        Intent intent = new Intent(this, TempActivity.class);
        startActivity(intent);
    }

    public void LengthClick(View view)
    {
        Intent intent = new Intent(this, LengthActivity.class);
        startActivity(intent);
    }

    public void WeightClick(View view)
    {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }



    Button TempButton;
    Button LengthButton;
    Button WeightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TempButton = findViewById(R.id.TempButton);
        LengthButton = findViewById(R.id.LenButton);
        WeightButton = findViewById(R.id.WeightButton);


    }
}