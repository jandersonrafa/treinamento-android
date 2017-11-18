package com.example.jandersonrosa.trooper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jandersonrosa.trooper.model.Trooper;
import com.example.jandersonrosa.trooper.util.Constants;
import com.example.jandersonrosa.trooper.util.ResourceUtil;
import com.squareup.picasso.Picasso;

public class TrooperDetail extends AppCompatActivity {

    private TextView tvTrooperDescription;

    private ImageView imvTrooperImage;

    private ImageView imvTrooperAfiliation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_detail);
        this.initializeComponents();
        this.populateTrooper();
    }

    private void populateTrooper() {
        Trooper trooper = (Trooper) getIntent().getSerializableExtra(Constants.TROOPER_EXTRA);

        tvTrooperDescription.setText(trooper.getDescription());
        int resourceBaseAndAffiliation = ResourceUtil.getResourceBaseAndAffiliation(trooper.getAffiliation());
        imvTrooperAfiliation.setImageResource(resourceBaseAndAffiliation);
        setTitle(trooper.getName());

        Picasso.with(this).load(trooper.getImageUrl()).into(imvTrooperImage);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initializeComponents() {
        tvTrooperDescription = findViewById(R.id.trooper_descripition_tv);
        imvTrooperAfiliation = findViewById(R.id.trooper_affiliation_imv);
        imvTrooperImage = findViewById(R.id.trooper_image_imv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trooper_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.star_item:
                Toast.makeText(this, "Favoritar Trooper", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
