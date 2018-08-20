package com.example.administrator.xiaoruiread;

import android.annotation.SuppressLint;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint("ValidFragment")
public class PersonalFragment extends Fragment {
    private String content;
    public PersonalFragment() {
        this.content = content;
    }


    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.personal_fragment,container,false);
        listView = (ListView)mView.findViewById(R.id.listview02);
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new ListViewAdapterTwo(getActivity(), list));

        return mView;
    }
    /*
     * listview
     * */
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i <3; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", R.mipmap.setting);
            map.put("title", "设置");
            map.put("info", "这是一个详细信息");
            list.add(map);
        }
        return list;
    }


}
