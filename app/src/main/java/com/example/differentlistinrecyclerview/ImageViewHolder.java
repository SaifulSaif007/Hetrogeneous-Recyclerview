package com.example.differentlistinrecyclerview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView image;
    ComplexRecyclerAdapter.itemClickListner clickListner;

    public ImageViewHolder(@NonNull View v, ComplexRecyclerAdapter.itemClickListner listner) {
        super(v);

        image = v.findViewById(R.id.imageView);
        this.clickListner = listner;
        v.setOnClickListener(this);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    @Override
    public void onClick(View v) {
        clickListner.onItemClick(getAdapterPosition());
    }
}
