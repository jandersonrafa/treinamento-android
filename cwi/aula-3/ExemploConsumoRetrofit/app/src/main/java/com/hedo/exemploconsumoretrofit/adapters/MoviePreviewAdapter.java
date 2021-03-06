package com.hedo.exemploconsumoretrofit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.hedo.exemploconsumoretrofit.R;
import com.hedo.exemploconsumoretrofit.model.MoviePreview;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Criado por hedo.junior em 22/11/2017.
 */

public class MoviePreviewAdapter extends RecyclerView.Adapter<MoviePreviewAdapter.ViewHolder> implements View.OnClickListener {
    private OnItemClickListener onItemClickListener;

    private ArrayList<MoviePreview> mItemList;

    public MoviePreviewAdapter(ArrayList<MoviePreview> mItemList, OnItemClickListener onItemClickListener) {
        this.mItemList = mItemList;
        this.onItemClickListener = onItemClickListener;
    }

    public void setmItemList(ArrayList<MoviePreview> mItemList) {
        this.mItemList = mItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_movie_preview, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MoviePreview moviePreview = mItemList.get(position);

        holder.itemView.setOnClickListener(this);
        Picasso
                .with(holder.itemView.getContext())
                .load(moviePreview.getPoster())
                .into(holder.imvMoviePoster, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.pbLoadingImage.setVisibility(View.GONE);
                        holder.imvMoviePoster.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        holder.itemView.setTag(moviePreview);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick((MoviePreview) v.getTag());
    }

    public interface OnItemClickListener {
        public void onItemClick(MoviePreview moviePreview);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imvMoviePoster;
        ProgressBar pbLoadingImage;

        public ViewHolder(View itemView) {
            super(itemView);

            imvMoviePoster = itemView.findViewById(R.id.movie_preview_poster_imv);
            pbLoadingImage = itemView.findViewById(R.id.loading_image_pb);
        }
    }
}
