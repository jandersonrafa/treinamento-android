package br.ulbra.cursoandroidcanoas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * @author MAYCON CARDOSO
 */
public class IntencaoActivity extends GenericActivity {
    private Button btVoltar;
    // =================================================================================================
    // CICLO DE VIDA
    // =================================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intencao);

        btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(IntencaoActivity.this, MainActivity.class);
//                startActivity(intent);

                finish();
            }
        });
    }
    // =================================================================================================
}
