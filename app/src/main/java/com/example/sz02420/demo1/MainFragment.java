package com.example.sz02420.demo1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SZ02420 on 2020/2/25 0028.
 */
public class MainFragment extends Fragment {
    private String content;
    private GridView gridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    // 图片封装为一个数组
    private int[] icon = {R.mipmap.all, R.mipmap.code,R.mipmap.code,R.mipmap.code,R.mipmap.code,
            R.mipmap.code,R.mipmap.code,R.mipmap.code, R.mipmap.code,R.mipmap.code,R.mipmap.code,R.mipmap.code,
            R.mipmap.code,R.mipmap.code,R.mipmap.code, R.mipmap.code,R.mipmap.code,R.mipmap.code,R.mipmap.code,
            R.mipmap.code,R.mipmap.code};
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声","通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声","通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声" };

    public MainFragment(){
    }

    public MainFragment(String content){
        this.content=content;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        gridView = (GridView)view.findViewById(R.id.fg_gridview);

        if (content=="1"){
            gridView.setVisibility(View.VISIBLE);
            //新建List
            data_list = new ArrayList<Map<String, Object>>();
            //获取数据
            getData();
            //新建适配器
            String [] from ={"image","text"};
            int [] to = {R.id.image,R.id.text};
            sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.list_item, from, to);
            //配置适配器
            gridView.setAdapter(sim_adapter);
        }else {
            TextView textView = (TextView) view.findViewById(R.id.content_one);
            textView.setText(content);
            textView.setVisibility(View.VISIBLE);
        }
        return view;
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
