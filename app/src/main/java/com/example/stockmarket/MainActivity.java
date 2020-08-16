package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText email, password;
    SQLiteDatabase sqLiteDatabase;



    public void login(View view)
    {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        if(email.getText().length() == 0  ||  password.getText().length() == 0)
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

        else
        {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM stock where email = '"+email.getText().toString() + "' and password ='"+password.getText().toString() + "'", null);
            if (cursor.moveToFirst())
            {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SelectionActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Enter valid details", Toast.LENGTH_SHORT).show();
        }
    }



    public void register(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Register.class);
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

        setContentView(R.layout.activity_main);

        sqLiteDatabase = this.openOrCreateDatabase("StockMarket", MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stock(name VARCHAR, email VARCHAR, contact INTEGER(11), password VARCHAR)");
    }
}