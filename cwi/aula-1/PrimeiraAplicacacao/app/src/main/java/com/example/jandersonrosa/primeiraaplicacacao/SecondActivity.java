package com.example.jandersonrosa.primeiraaplicacacao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    String tag ="testeLifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "SecondActivity.onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "SecondActivity.onStop");
    }

    public void onClickBotao(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "SecondActivity.onDestroy");

    }
}
