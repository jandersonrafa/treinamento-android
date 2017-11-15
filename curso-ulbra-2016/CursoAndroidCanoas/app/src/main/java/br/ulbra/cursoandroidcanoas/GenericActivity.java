package br.ulbra.cursoandroidcanoas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author MAYCON CARDOSO
 */
public class GenericActivity extends AppCompatActivity{
    // =================================================================================================
    // CICLO DE VIDA
    // =================================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo","onCreate: " + getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo", "onStart: " + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo", "onResume: " + getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo", "onPause: " + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo", "onStop: " + getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo", "onRestart: " + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo", "onDestroy: " + getClass().getSimpleName());
    }
}
