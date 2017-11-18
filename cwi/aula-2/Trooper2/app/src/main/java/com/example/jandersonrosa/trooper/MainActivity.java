package com.example.jandersonrosa.trooper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jandersonrosa.trooper.adapter.TrooperAdapter;
import com.example.jandersonrosa.trooper.model.Trooper;
import com.example.jandersonrosa.trooper.repository.TrooperRepository;
import com.example.jandersonrosa.trooper.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TrooperAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter trooperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inicializaComponentes();
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        troopers = TrooperRepository.tryGettingForSharedPreferences(sharedPreferences);

        rvTroopers.setLayoutManager(new LinearLayoutManager(this));
        trooperAdapter = new TrooperAdapter(troopers, this, this);
        rvTroopers.setAdapter(trooperAdapter);
    }

    private void inicializaComponentes() {
        rvTroopers = findViewById(R.id.troopers_rv);
    }

    @Override
    public void onItemClick(Trooper trooper) {
        Intent intent = new Intent(this, TrooperDetail.class);
        intent.putExtra(Constants.TROOPER_EXTRA, trooper);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View v) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Excluir Trooper");
        alertDialogBuilder
                .setMessage("Tem certeza que deseja excluir este trooper")
                .setCancelable(true)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int position = rvTroopers.getChildAdapterPosition(v);
                        troopers.remove(position);
                        trooperAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Trooper excluído", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NÂO", negativeButton());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return true;
    }

    private DialogInterface.OnClickListener negativeButton() {
        return new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        };
    }

    @Override
    protected void onStop() {
        super.onStop();
        TrooperRepository.saveToSharedPreferences(troopers, getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));
    }

}
