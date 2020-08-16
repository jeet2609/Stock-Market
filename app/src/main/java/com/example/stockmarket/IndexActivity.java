package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class IndexActivity extends AppCompatActivity
{
    TextView main, openPrice, previousClose, towadysLow, towadysHigh, fiftyTwoWkLow, fiftyTwoWkHigh, thirtyDays, fiftyDays, oneFiftyDays, twoHundredDays;
    SeekBar towadysSeekBar, fiftyTwoWkSeekBar;
    Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        main = findViewById(R.id.main);

        openPrice = findViewById(R.id.openPrice);
        previousClose = findViewById(R.id.previousClose);
        towadysLow = findViewById(R.id.towadysLow);
        towadysHigh = findViewById(R.id.towadysHigh);
        fiftyTwoWkLow = findViewById(R.id.fiftyTwoWkLow);
        fiftyTwoWkHigh = findViewById(R.id.fiftyTwoWkHigh);
        thirtyDays = findViewById(R.id.thirtyDays);
        fiftyDays = findViewById(R.id.fiftyDays);
        oneFiftyDays = findViewById(R.id.oneFiftyDays);
        twoHundredDays = findViewById(R.id.twoHundredDays);

        towadysSeekBar = (SeekBar) findViewById(R.id.towadysSeekBar);
        fiftyTwoWkSeekBar = (SeekBar) findViewById(R.id.fiftyTwoWkSeekBar);

        spinner = (Spinner) findViewById(R.id.spinner);
        arrayList = new ArrayList<String>();
        arrayList.add("SENSEX");
        arrayList.add("NIFTY");

        arrayAdapter = new ArrayAdapter<String>(IndexActivity.this,
                R.layout.spinner_customise,
                arrayList);

        arrayAdapter.setDropDownViewResource(R.layout.spinner_customise);
        spinner.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        int index = arrayList.indexOf(intent.getStringExtra("name"));
        spinner.setSelection(index);

        main.setEnabled(false);
        openPrice.setEnabled(false);
        previousClose.setEnabled(false);
        towadysLow.setEnabled(false);
        towadysHigh.setEnabled(false);
        fiftyTwoWkLow.setEnabled(false);
        fiftyTwoWkHigh.setEnabled(false);

        thirtyDays.setEnabled(false);
        fiftyDays.setEnabled(false);
        oneFiftyDays.setEnabled(false);
        twoHundredDays.setEnabled(false);
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