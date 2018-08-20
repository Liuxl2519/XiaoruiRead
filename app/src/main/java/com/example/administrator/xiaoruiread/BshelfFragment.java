package com.example.administrator.xiaoruiread;

import android.annotation.SuppressLint;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressLint("ValidFragment")
public class BshelfFragment extends Fragment {
    private String content;
    public BshelfFragment() {
        this.content = content;
    }

    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.bookshelf_fragment,container,false);
        listView = (ListView)mView.findViewById(R.id.listview03);
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new ListViewAdapterThree(getActivity(), list));
        return mView;
    }

    /*
    * listview
    * */
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", R.drawable.ic_launcher_background);
            map.put("title", "这是一个标题");
            list.add(map);
        }
        return list;
    }

}
