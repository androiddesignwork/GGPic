package com.example.ggpic;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExplorePic#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExplorePic extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private List<Explorer> ListExplorer = new ArrayList<>();
    private Context context = null;//使用adapter
    private View rootView;//可使用findbyid
    private String[] text = null;//图片类型
    private TypedArray images;//图片封面
    ArrayList<Explorer> mdata=new ArrayList<Explorer>();

    // TODO: Rename and change types of parameters
    private RecyclerView mlist;
    private ExplorerAdapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploerPic.
     */
    // TODO: Rename and change types and number of parameters
    public static ExplorePic newInstance(String param1, String param2) {
        ExplorePic fragment = new ExplorePic();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();

        rootView = inflater.inflate(R.layout.fragment_explorer_pic,
                container, false);


        initData();

        initView();

        setonclicklistener();

        return rootView;
    }
    private void initData(){
        text = getResources().getStringArray(R.array.text);

        images = getResources().obtainTypedArray(R.array.images);

        for (int i = 0; i < text.length; i++) {
            Explorer pic = new Explorer();
            pic.setText(text[i]);
            pic.setPicUrl(images.getResourceId(i, 0));
            mdata.add(pic);
        }

        mlist = rootView.findViewById(R.id.explorer);
        mlist.setPadding(8,8,8,8);
    }

    private void initView(){
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,1);//实现瀑布流效果

        mlist.setLayoutManager(layoutManager);

        adapter =new ExplorerAdapter(mdata);

        setonclicklistener();

        mlist.setAdapter(adapter);
    }

    private void setonclicklistener(){
        adapter.setOnItemClickListener(new ExplorerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context,
                        PicView.class);


                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show();
            }
        });
    }
}