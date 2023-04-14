package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LengthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public void HomeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    Button ConvertButton;
    Spinner SourceSpinner;
    Spinner DestinationSpinner;
    EditText input;

    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        input = findViewById(R.id.inputNumb);

        ConvertButton = findViewById(R.id.ConvertID);

        output = findViewById(R.id.outputText);

        SourceSpinner = findViewById(R.id.SourceSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Length, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SourceSpinner.setAdapter(adapter);
        SourceSpinner.setOnItemSelectedListener(this);


        DestinationSpinner = findViewById(R.id.DestinationSpinner);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Length, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DestinationSpinner.setAdapter(adapter2);
        DestinationSpinner.setOnItemSelectedListener(this);


        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sourceUnit = SourceSpinner.getSelectedItem().toString();
                String destinationUnit = DestinationSpinner.getSelectedItem().toString();
                String inputunit = input.getText().toString();

                double inputValue = Double.parseDouble(String.valueOf(inputunit));
                double result = convertTemperature(sourceUnit, destinationUnit, inputValue);
                String outputText = String.format("%.2f %s", result, destinationUnit);
                output.setText(outputText);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private double convertTemperature(String source, String destination, double input) {

        double result = 0;

        double inputValue = Double.parseDouble(String.valueOf(input));
        // Convert the input value to centimeters
        if ("Inch".equals(source)) {
            result = inputValue * 2.54;
        } else if ("Foot".equals(source)) {
            result = inputValue * 30.48;
        } else if ("Yard".equals(source)) {
            result = inputValue * 91.44;
        } else if ("Mile".equals(source)) {
            result = inputValue * 160934;
        }


        if ("Inch".equals(destination)) {
            result /= 2.54;
        } else if ("Foot".equals(destination)) {
            result /= 30.48;
        } else if ("Yard".equals(destination)) {
            result /= 91.44;
        } else if ("Mile".equals(destination)) {
            result /= 160934;
        }

        return result;

    }

}