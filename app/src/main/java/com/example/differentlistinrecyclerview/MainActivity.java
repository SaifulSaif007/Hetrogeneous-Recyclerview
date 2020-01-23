package com.example.differentlistinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ComplexRecyclerAdapter.itemClickListner {

    ArrayList<Object> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ComplexRecyclerAdapter adapter = new ComplexRecyclerAdapter(getSampleArrayList(), this);

        int numColumns = 1;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), numColumns);
        recyclerView.setLayoutManager(gridLayoutManager);

//
        recyclerView.addItemDecoration(new DividerItemDecorator(1));

        recyclerView.setAdapter(adapter);


    }



    private ArrayList<Object> getSampleArrayList() {

        items.add(new User("Dany Targaryen", "Valyria"));
        items.add(new User("Rob Stark", "Winterfell"));
        items.add(R.drawable.nature);
        items.add(new User("Jon Snow", "Castle Black"));
        items.add(R.drawable.nature);
        items.add(new User("Tyrion Lanister", "King's Landing"));
        return items;
    }


    @Override
    public void onItemClick(int position) {
       // Toast.makeText(getApplicationContext(), "" + items.get(position), Toast.LENGTH_SHORT).show();
        if(items.get(position) instanceof User){
            User user = (User) items.get(position);
            Toast.makeText(getApplicationContext(), user.Name, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Image", Toast.LENGTH_SHORT).show();
        }
    }
}
