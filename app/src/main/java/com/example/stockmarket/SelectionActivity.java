package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectionActivity extends AppCompatActivity
{
    Intent intent;
    TextView SensexTextView, NiftyTextView;
    TextView RelianceTextView, AshokLeylandTextView, CiplaTextView, TataSteelTextView, EicherMotorsTextView;


    public void StockPage(View view)
    {
        TextView name = (TextView) view;

        if(name.getText().toString().equals("SENSEX")  ||  name.getText().toString().equals("NIFTY"))
            intent = new Intent(getApplicationContext(), IndexActivity.class);
        else
            intent = new Intent(getApplicationContext(), CompanyActivity.class);

        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_selection);
    }
}