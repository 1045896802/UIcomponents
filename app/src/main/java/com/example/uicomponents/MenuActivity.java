package com.example.uicomponents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /**
     * 利用菜单资源文件创建选项菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 利用菜单填充器将菜单资源文件映射成菜单
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 菜单项单击事件处理方法
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView txt = (TextView)findViewById(R.id.tv_text);;
        switch (item.getItemId()) {

            case R.id.font_size_big_menu_item:
                txt.setTextSize(20);
                break;
            case R.id.font_size_middle_menu_item:
                txt.setTextSize(16);
                break;
            case R.id.font_size_small_menu_item:
                txt.setTextSize(10);
                break;

            case R.id.common_menu_menu_item:
                Toast.makeText(this, "你单击了【普通菜单项】", Toast.LENGTH_SHORT).show();
                break;

            case R.id.font_color_red_menu_item:
                txt.setTextColor(android.graphics.Color.RED);
                break;
            case R.id.font_color_black_menu_item:
                txt.setTextColor(android.graphics.Color.BLACK);
                break;
            case R.id.exit_menu_item:
                finish();
                break;
        }
        return true;
    }
}
