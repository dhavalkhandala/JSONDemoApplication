package com.example.jsondemoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.adapterViewHolder> {
    Context context;
    List<DataModel> list;

    public DataAdapter(Context context, List<DataModel> list){
        this.context = context;
        this.list=list;
    }


    @NonNull
    @Override
    public adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new adapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterViewHolder holder, int position) {
        holder.Mtitle.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.Myear.setText(list.get(position).getReleaseYear());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class adapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Mtitle,Mrating,Myear,Mgenre;
        public adapterViewHolder(@NonNull View itemView) {
            super(itemView);
        imageView = itemView.findViewById(R.id.image);
        Mtitle = itemView.findViewById(R.id.titlename);
        Mgenre = itemView.findViewById(R.id.gener);
        Myear = itemView.findViewById(R.id.ryear);
        Mrating = itemView.findViewById(R.id.rating);
        }
    }

}
