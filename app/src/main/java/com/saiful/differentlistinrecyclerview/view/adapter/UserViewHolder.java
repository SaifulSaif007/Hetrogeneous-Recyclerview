package com.saiful.differentlistinrecyclerview.view.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saiful.differentlistinrecyclerview.R;

public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name, post, time;
    ComplexRecyclerAdapter.itemClickListner clickListner;

    public UserViewHolder(@NonNull View v, ComplexRecyclerAdapter.itemClickListner listner) {
        super(v);

        name = v.findViewById(R.id.Name);
        post = v.findViewById(R.id.post);
        time = v.findViewById(R.id.time);
        this.clickListner = listner;
        v.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        clickListner.onItemClick(getAdapterPosition());
    }
}
