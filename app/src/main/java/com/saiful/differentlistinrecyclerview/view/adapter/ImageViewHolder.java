package com.saiful.differentlistinrecyclerview.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saiful.differentlistinrecyclerview.R;

public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView image;
    TextView name, time;
    ComplexRecyclerAdapter.itemClickListner clickListner;

    public ImageViewHolder(@NonNull View v, ComplexRecyclerAdapter.itemClickListner listner) {
        super(v);

        name = v.findViewById(R.id.name);
        time = v.findViewById(R.id.textView3);
        image = v.findViewById(R.id.imageView);
        this.clickListner = listner;
        v.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        clickListner.onItemClick(getAdapterPosition());
    }
}
