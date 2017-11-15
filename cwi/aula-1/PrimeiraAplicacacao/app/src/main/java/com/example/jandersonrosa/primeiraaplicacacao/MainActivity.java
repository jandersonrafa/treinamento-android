package com.example.jandersonrosa.primeiraaplicacacao;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String tag = "testeLifecycle";
    TextView nameTv;
    Button redirectBt;
    EditText telefoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        nameTv.setText("MainActivity");
        Log.i(tag, "MainActivity.onCreate");


        redirectBt.setOnClickListener(this);
    }

    private void inicializaComponentes() {
        nameTv = findViewById(R.id.name_tv);
        redirectBt = findViewById(R.id.redirec_bt);
        telefoneEt = findViewById(R.id.telefone_et);
    }

    @Override
    protected void onStart() {
        Log.i(tag, "MainActivity.onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(tag, "MainActivity.onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(tag, "MainActivity.onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i(tag, "MainActivity.onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.redirec_bt:
                // ligar();
                redirecionarUrl();
                break;
            default:
                break;
        }
    }

    private void redirecionarUrl() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cwi.com.br"));
        startActivity(intent);
    }

    private void ligar() {
        //                String telefone = telefoneEt.getText().toString();
//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefone));
//                Intent intent = new Intent(this, SecondActivity.class);
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    startActivity(intent);
//                }
    }
}
