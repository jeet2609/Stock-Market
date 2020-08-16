package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CompanyActivity extends AppCompatActivity
{
    TextView main, offerPrice, towadysLow, towadysHigh, previousClose, fiftyTwoWkLow, fiftyTwoWkHigh, openPrice, LUPriceBandLow, LUPriceBandHigh;
    SeekBar towadysSeekBar, fiftyTwoWkSeekBar, LUPriceBandSeekBar;
    Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        main = findViewById(R.id.main);

        offerPrice = findViewById(R.id.offerPrice);
        towadysLow = findViewById(R.id.towadysLow);
        towadysHigh = findViewById(R.id.towadysHigh);
        previousClose = findViewById(R.id.previousClose);
        fiftyTwoWkLow = findViewById(R.id.fiftyTwoWkLow);
        fiftyTwoWkHigh = findViewById(R.id.fiftyTwoWkHigh);
        openPrice = findViewById(R.id.openPrice);
        LUPriceBandLow = findViewById(R.id.LUPriceBandLow);
        LUPriceBandHigh = findViewById(R.id.LUPriceBandHigh);

        towadysSeekBar = (SeekBar) findViewById(R.id.towadysSeekBar);
        fiftyTwoWkSeekBar = (SeekBar) findViewById(R.id.fiftyTwoWkSeekBar);
        LUPriceBandSeekBar = (SeekBar) findViewById(R.id.LUPriceBandSeekBar);

        spinner = (Spinner) findViewById(R.id.spinner);
        arrayList = new ArrayList<String>();
        arrayList.add("Reliance");
        arrayList.add("Ashok Leyland");
        arrayList.add("Cipla");
        arrayList.add("Tata Steel");
        arrayList.add("Eicher Motors");

        arrayAdapter = new ArrayAdapter<String>(CompanyActivity.this,
                R.layout.spinner_customise,
                arrayList);

        arrayAdapter.setDropDownViewResource(R.layout.spinner_customise);
        spinner.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        int index = arrayList.indexOf(intent.getStringExtra("name"));
        spinner.setSelection(index);

        main.setEnabled(false);
        offerPrice.setEnabled(false);
        towadysLow.setEnabled(false);
        towadysHigh.setEnabled(false);
        previousClose.setEnabled(false);
        fiftyTwoWkLow.setEnabled(false);
        fiftyTwoWkHigh.setEnabled(false);
        openPrice.setEnabled(false);
        LUPriceBandLow.setEnabled(false);
        LUPriceBandHigh.setEnabled(false);
    }


    //Menu Code
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}