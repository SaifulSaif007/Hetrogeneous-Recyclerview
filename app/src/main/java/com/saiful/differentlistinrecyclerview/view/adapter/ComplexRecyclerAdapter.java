package com.saiful.differentlistinrecyclerview.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saiful.differentlistinrecyclerview.R;
import com.saiful.differentlistinrecyclerview.model.NormalPost;
import com.saiful.differentlistinrecyclerview.model.PostWithImage;

import java.util.List;

public class ComplexRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> items;

    private final int NORMAL_POST = 1, IMAGE_POST = 2;
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
        if(items.get(position) instanceof NormalPost){
            return NORMAL_POST;
        }
        else if(items.get(position) instanceof PostWithImage){
            return IMAGE_POST;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case NORMAL_POST:
                View v1 = inflater.inflate(R.layout.recycler_user, parent, false);
                viewHolder = new UserViewHolder(v1, clickListner);
                break;
            case IMAGE_POST:
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
            case NORMAL_POST:
                UserViewHolder vh1 = (UserViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case IMAGE_POST:
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

        PostWithImage postWithImage = (PostWithImage) items.get(position);
        vh2.name.setText(postWithImage.getName());
        vh2.time.setText(postWithImage.getTime());
        vh2.image.setImageResource(postWithImage.getImage());
    }


    private void configureViewHolder1(UserViewHolder vh1, int position) {
        NormalPost normalPost = (NormalPost) items.get(position);
        if(normalPost != null){
            vh1.name.setText(normalPost.getName() );
            vh1.post.setText(normalPost.getPost());
            vh1.time.setText(normalPost.getTime());
        }
    }

    public interface itemClickListner{
        void onItemClick(int position);
    }
}
