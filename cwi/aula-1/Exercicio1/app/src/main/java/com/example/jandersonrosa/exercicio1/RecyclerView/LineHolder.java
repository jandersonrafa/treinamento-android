package com.example.jandersonrosa.exercicio1.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by janderson.rosa on 18/11/2017.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public LineHolder(View itemView){
        super(itemView);
        textView.setText("tessss");
        textView = itemView.findViewById(R.id.nam)
    }
}
