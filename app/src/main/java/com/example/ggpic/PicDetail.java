package com.example.ggpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;


public class PicDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

        Intent intent = getIntent();
        int uri = intent.getIntExtra(
                "url",1);

        ImageView image=findViewById(R.id.photoview);

//        Glide.with(mContext).load(news.getPicUrl())
//                .into(vh.ivImage);

        image.setImageResource(uri);
    }
}