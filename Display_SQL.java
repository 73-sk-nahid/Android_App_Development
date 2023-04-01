package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Display_SQL extends AppCompatActivity {
    TextView name, university;
    Button prev, next, home, delete;
    SQLiteDatabase db;
    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        name = findViewById(R.id.name);
        university = findViewById(R.id.university);
        prev = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        home = findViewById(R.id.home);
        delete = findViewById(R.id.dlt);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from student", null);
        c.moveToFirst();
        name.setText(c.getString(c.getColumnIndex("stdname")));
        university.setText(c.getString(c.getColumnIndex("uniname")));

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    c.moveToPrevious();
                    name.setText(c.getString(c.getColumnIndex("stdname")));
                    university.setText(c.getString(c.getColumnIndex("uniname")));
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "First Record", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                try {
                    c.moveToNext();
                    name.setText(c.getString(c.getColumnIndex("stdname")));
                    university.setText(c.getString(c.getColumnIndex("uniname")));
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Last Record", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_SQL.class);
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db.execSQL("DELETE FROM student");
                Toast.makeText(getApplicationContext(), "Deleted All", Toast.LENGTH_SHORT).show();
            }
        });
    }
}