package br.ulbra.cursoandroidcanoas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Inet4Address;

public class MainActivity extends GenericActivity {
    private Button btEntrar;
    private TextView tvOlaMundo;
    private EditText etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvOlaMundo = (TextView) findViewById(R.id.tvOla);
        btEntrar = (Button) findViewById(R.id.btCadastrar);
        etNome = (EditText) findViewById(R.id.etNome);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOlaMundo.setText("Ola, Maycon");
                Intent intent = new Intent(MainActivity.this, IntencaoActivity.class);
                startActivity(intent);
            }
        });

        btEntrar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvOlaMundo.setText("Ola, Maycon Long");
                return true;
            }
        });

    }
}
