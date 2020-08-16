package com.example.stockmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity
{
    SQLiteDatabase sqLiteDatabase;
    EditText name, email, contactNumber, password;


    public void registerDone(View view)
    {
        sqLiteDatabase = this.openOrCreateDatabase("StockMarket", MODE_PRIVATE, null);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        contactNumber = (EditText) findViewById(R.id.contactNumber);
        password = (EditText) findViewById(R.id.password);

        if(name.getText().toString().length() >0  &&  email.getText().toString().length() >0  &&  contactNumber.getText().toString().length() >0  &&  password.getText().toString().length() >0)
        {
            String sql = "INSERT INTO stock (name, email, contact, password) VALUES (? , ? , ? , ?)";
            SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
            statement.bindString(1, name.getText().toString());
            statement.bindString(2, email.getText().toString());
            statement.bindString(3, contactNumber.getText().toString());
            statement.bindString(4, password.getText().toString());
            statement.execute();

            Toast.makeText(this, "Successfully Register", Toast.LENGTH_SHORT).show();

            finish();
        }
        else
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

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

        setContentView(R.layout.activity_register);
    }
}