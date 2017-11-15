package com.example.jandersonrosa.loginapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView buttonProsseguir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        buttonProsseguir.setOnClickListener(this);
    }

    private void inicializaComponentes() {
        buttonProsseguir = findViewById(R.id.prosseguir_bt);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
    }
}
