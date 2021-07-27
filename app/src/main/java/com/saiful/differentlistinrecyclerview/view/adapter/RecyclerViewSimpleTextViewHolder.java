package com.saiful.differentlistinrecyclerview.view.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView label;


    public RecyclerViewSimpleTextViewHolder(@NonNull View itemView) {
        super(itemView);
        label = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public TextView getLabel() {
        return label;
    }

    public void setLabel(TextView label) {
        this.label = label;
    }

    @Override
    public void onClick(View v) {

    }
}
