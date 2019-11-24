package com.example.viewmodeleg5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private List<HeroModel> heroModelList;

    public HeroAdapter(List<HeroModel> heroModelList) {
        this.heroModelList = heroModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.herolistitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tvName.setText(heroModelList.get(position).getName());
        Picasso.get().load(heroModelList.get(position).getImageurl()).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return heroModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgPhoto=v.findViewById(R.id.imgPhoto);
            tvName=v.findViewById(R.id.tvName);
        }
    }
}
