package com.saiful.differentlistinrecyclerview.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.saiful.differentlistinrecyclerview.view.adapter.ComplexRecyclerAdapter;
import com.saiful.differentlistinrecyclerview.view.adapter.DividerItemDecorator;
import com.saiful.differentlistinrecyclerview.R;
import com.saiful.differentlistinrecyclerview.data.DataSource;
import com.saiful.differentlistinrecyclerview.model.NormalPost;
import com.saiful.differentlistinrecyclerview.model.PostWithImage;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements ComplexRecyclerAdapter.itemClickListner {

    ArrayList<Object> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ComplexRecyclerAdapter adapter = new ComplexRecyclerAdapter(getSampleArrayList(), this);

        int numColumns = 1;
        GridLayoutManager gridLayoutManager;

         gridLayoutManager = new GridLayoutManager(getApplicationContext(), numColumns);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecorator(1));

        recyclerView.setAdapter(adapter);

    }


    private ArrayList<Object> getSampleArrayList() {
        items = (new DataSource()).getDataList();
        Collections.shuffle(items);
        return items;
    }


    @Override
    public void onItemClick(int position) {

        /*
        you can use the clicked object for further actions
        just toasting the object type here
         */

        if(items.get(position) instanceof NormalPost){
            NormalPost normalPost = (NormalPost) items.get(position);
            Toast.makeText(getApplicationContext(), "Normal post", Toast.LENGTH_SHORT).show();
        }
        else {

            PostWithImage postWithImage = (PostWithImage) items.get(position);
            Toast.makeText(getApplicationContext(), "Image post", Toast.LENGTH_SHORT).show();
        }
    }
}
