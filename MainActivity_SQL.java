package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_SQL extends AppCompatActivity {
    EditText name, university;
    Button insert, display, exit;

    String nam, varsity;
    SQLiteDatabase db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        university = findViewById(R.id.university);
        insert = findViewById(R.id.insert);
        display = findViewById(R.id.display);
        exit = findViewById(R.id.exit);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(stdname VARCHAR, uniname VATCHAR);");

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam = name.getText().toString();
                varsity = university.getText().toString();

                db.execSQL("INSERT INTO student VALUES('"+nam+"', '"+varsity+"');");
                Toast.makeText(getApplicationContext(), "Value Inserted",Toast.LENGTH_SHORT).show();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Display_SQL.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}