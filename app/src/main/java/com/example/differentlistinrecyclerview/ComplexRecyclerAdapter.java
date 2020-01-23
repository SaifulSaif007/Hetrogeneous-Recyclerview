package com.example.differentlistinrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComplexRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> items;

    private final int USER = 1, IMAGE = 2;
    itemClickListner clickListner;

    public ComplexRecyclerAdapter(List<Object> items, itemClickListner listner) {
        this.items = items;
        this.clickListner = listner;
    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }


    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof User){
            return USER;
        }
        else if(items.get(position) instanceof Integer){
            return IMAGE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case USER:
                View v1 = inflater.inflate(R.layout.recycler_user, parent, false);
                viewHolder = new UserViewHolder(v1, clickListner);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.recycler_image_item, parent, false);
                viewHolder = new ImageViewHolder(v2,  clickListner);
                break;

            default:
               View v = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
               viewHolder = new RecyclerViewSimpleTextViewHolder(v);
               break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case USER:
                UserViewHolder vh1 = (UserViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case IMAGE:
                ImageViewHolder vh2 = (ImageViewHolder) holder;
                configureViewHolder2(vh2, position);
                break;
            default:
                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) holder;
                configureViewHolder(vh, position);
                break;
        }
    }

    private void configureViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
        //vh.getLabel().setText((Integer) items.get(position));
    }


    private void configureViewHolder2(ImageViewHolder vh2, int position) {

        vh2.getImage().setImageResource(R.drawable.nature);
    }


    private void configureViewHolder1(UserViewHolder vh1, int position) {
        User user = (User) items.get(position);
        if(user != null){
            vh1.getName().setText("Name " + user.Name );
            vh1.getAddress().setText("Address " + user.Address);

        }
    }

    public interface itemClickListner{
        void onItemClick(int position);
    }
}
