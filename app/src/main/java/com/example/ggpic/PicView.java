package com.example.ggpic;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PicView extends AppCompatActivity {

    private View rootView;
    private String[] author;
    private String[] title;
    private TypedArray images;
    ArrayList<Pics> mdata = new ArrayList<Pics>();
    private RecyclerView mlist;
    private PicsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_picview);

        initData();

        initView();

/*        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    private void initData() {
        author = getResources().getStringArray(R.array.author);
        title = getResources().getStringArray(R.array.title);
        images = getResources().obtainTypedArray(R.array.images);

        for (int i = 0; i < title.length; i++) {
            Pics pic = new Pics();
            pic.setAuthor(author[i]);
            pic.setTitle(title[i]);
            pic.setPicUrl(images.getResourceId(i, 0));
            mdata.add(pic);
        }
        mlist = findViewById(R.id.pic);
    }

    private void initView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, 1);//实现瀑布流效果

        mlist.setLayoutManager(layoutManager);

        adapter = new PicsAdapter(mdata);

        setonclicklistener();

        mlist.setAdapter(adapter);
    }

    private void setonclicklistener() {
        adapter.setOnItemClickListener(
            new PicsAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(PicView.this,
                            PicDetail.class);

                    Pics pic=adapter.getitem(position);
                    intent.putExtra("url",
                            pic.getPicUrl());

                    startActivity(intent);
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }
            }
        );
    }
}
