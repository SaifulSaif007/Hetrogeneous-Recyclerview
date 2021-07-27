package com.saiful.differentlistinrecyclerview.data;

import com.saiful.differentlistinrecyclerview.R;
import com.saiful.differentlistinrecyclerview.model.NormalPost;
import com.saiful.differentlistinrecyclerview.model.PostWithImage;

import java.util.ArrayList;

public class DataSource {

    public ArrayList<Object> getDataList () {

        ArrayList<Object> items = new ArrayList<>();

        items.add(new PostWithImage("Daenerys Targaryen", R.drawable.image4, "just now"));
        items.add(new NormalPost("Jaime Lannister", "Nice weather today", "1 hr ago"));
        items.add(new NormalPost("Jon Snow", "Winter is coming..", "30 min ago"));
        items.add(new PostWithImage("Arya Stark" , R.drawable.image1, "2 min ago"));
        items.add(new NormalPost("Bran Stark", "I'm feeling happy, throne is mine now", "45 min ago"));
        items.add(new PostWithImage("Tyrion Lannister" , R.drawable.image3, "22 min ago"));
        items.add(new NormalPost("Petyr 'Littlefinger' Baelishr", "'Knowledge is power'  - what is your saying? ", "just now"));
        return items;

    }
}
