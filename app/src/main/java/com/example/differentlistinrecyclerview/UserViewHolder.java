package com.example.differentlistinrecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name, address;
    ComplexRecyclerAdapter.itemClickListner clickListner;

    public UserViewHolder(@NonNull View v, ComplexRecyclerAdapter.itemClickListner listner) {
        super(v);

        name = v.findViewById(R.id.Name);
        address = v.findViewById(R.id.Address);
        this.clickListner = listner;
        v.setOnClickListener(this);
    }


    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getAddress() {
        return address;
    }

    public void setAddress(TextView address) {
        this.address = address;
    }

    @Override
    public void onClick(View v) {
        clickListner.onItemClick(getAdapterPosition());
    }
}
