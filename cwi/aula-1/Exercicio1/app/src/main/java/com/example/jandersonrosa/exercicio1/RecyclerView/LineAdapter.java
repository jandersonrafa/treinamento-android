package com.example.jandersonrosa.exercicio1.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by janderson.rosa on 18/11/2017.
 */

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private ArrayList<String> nomes;

    public LineAdapter(ArrayList nomes) {

    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate());
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.textView.setText(nomes.get(position));
    }

    @Override
    public int getItemCount() {
        return nomes.size();
    }
}
