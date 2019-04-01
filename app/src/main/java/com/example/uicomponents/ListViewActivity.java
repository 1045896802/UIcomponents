package com.example.uicomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.Color;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.widget.AdapterView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.ListView);
        //填充数据
        putData();
        simpleAdapter = new SimpleAdapter(this, listItems, R.layout.activity_list_view_item, new String[]{"title", "image"}, new int[]{R.id.title, R.id.image});
        listView.setAdapter(simpleAdapter);
    }

    private void putData() {
        int[] imageId = new int[]{
                R.drawable.cat,
                R.drawable.dog,
                R.drawable.elephant,
                R.drawable.lion,
                R.drawable.monkey,
                R.drawable.tiger};
        final String[] title = new String[]{"Cat", "Dog", "Elephant", "Lion", "Monkey", "Tiger"};

        listItems = new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
        for (int i = 0; i < imageId.length; i++) {
            //实例化Map对象
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageId[i]);
            map.put("title", title[i]);
            //将map对象添加到List集合
            listItems.add(map);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.TRANSPARENT);
                Toast.makeText(ListViewActivity.this, title[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

}
