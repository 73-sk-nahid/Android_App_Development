package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login_Page extends AppCompatActivity {

    EditText uname, upass;
    Button lin, rst;
    ImageView profileImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        uname = findViewById(R.id.username);
        upass = findViewById(R.id.password);
        lin = findViewById(R.id.login);
        rst = findViewById(R.id.reset);
        profileImageView = findViewById(R.id.profile_image);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);
            }
        });

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                Toast.makeText(Login_Page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname.setText("");
                upass.getText().clear();
                profileImageView.setImageDrawable(null);

            }
        });
    }
}
