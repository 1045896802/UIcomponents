# Android UI组件

## 一. 实验内容

1.利用SimpleAdapter实现如下界面效果

![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/1y.png)

2.创建自定义布局的AlertDialog

创建如图所示的自定义对话框

请创建一个如图所示的布局，调用 AlertDialog.Builder对象上的setView() 将布局添加到AlertDialog。

![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/2y.png)

3.使用XML定义菜单

（1）字体大小（有小，中，大这3个选项；分别对应10号字，16号字和20号字），点击之后设置测试文本的字体

（2）普通菜单项，点击之后弹出Toast提示

（3）字体颜色（有红色和黑色这2个选项），点击之后设置测试文本的字体

![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/3y.png)

4.创建上下文操作模式(ActionMode)的上下文菜单

（1）使用ListView或者ListActivity创建List

（2）为List Item创建ActionMode形式的上下文菜单

（3）参考文献：https://developer.android.google.cn/guide/topics/ui/menus.html

![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/4y.png)

5.自学内容

（1）学习Android RecyclerView

指南：https://developer.android.google.cn/guide/topics/ui/layout/recyclerview.html

Sample：https://github.com/googlesamples/androidRecyclerView/

（2）Card-Based Layout

指南：https://developer.android.google.cn/guide/topics/ui/layout/cardview.html#AddDependency

## 二. 关键代码

  1.利用SimpleAdapter实现界面效果
  
   （1）activity_list_view.xml
  
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ListViewActivity">

        <ListView
            android:id="@+id/ListView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </android.support.design.widget.CoordinatorLayout>
    
   （2）activity_list_view.xml（作为listview的每个item）
    
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/title"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="3"
            android:layout_gravity="center"
            android:textSize="25dp"/>

        <ImageView
            android:id="@+id/image"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:gravity="center"
            android:textColor="@color/colorAccent"
            android:adjustViewBounds="true"/>

    </LinearLayout>
    
  （3）ListViewActivity.java

    package com.example.uicomponents;

    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.View;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import android.graphics.Color;
    import android.widget.ListView;
    import android.widget.SimpleAdapter;

    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.LinearLayout;
    import android.widget.TextView;
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
            simpleAdapter = new SimpleAdapter(this, listItems, R.layout.activity_list_view, new String[]{"title", "image"}, new int[]{R.id.title, R.id.image});
            listView.setAdapter(simpleAdapter);
        }

        private void putData() {

            int[] imageId = new int[]{R.drawable.cat,
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
                    Toast.makeText(ListViewActivity.this,title[position],Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    
  2.创建自定义布局的AlertDialog
  
  （1）activity_alert_dialog.xml

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".AlertDialogActivity">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </android.support.design.widget.AppBarLayout>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            app:srcCompat="@android:drawable/ic_dialog_email" />

    </android.support.design.widget.CoordinatorLayout>
    
   （2）activity_alert_dialog_item.xml（登录页面，作为弹出框）
    
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:adjustViewBounds="true"
            android:cropToPadding="true"
            app:srcCompat="@drawable/header_logo" />

        <EditText
            android:id="@+id/username"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Username"
            android:inputType="text" />

        <EditText
            android:id="@+id/password"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Password"
            android:inputType="textPassword" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:id="@+id/btnCancel"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_gravity="center"
                android:layout_weight="1"
                android:text="@string/text_btnCancel"
                android:textAllCaps="false"
                android:textSize="20sp" />

            <Button
                android:id="@+id/btnSignin"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_weight="1"
                android:adjustViewBounds="true"
                android:text="@string/text_btnSignin"
                android:textAllCaps="false"
                android:textSize="20sp" />
        </LinearLayout>


    </LinearLayout>
  
  （3）AlertDialogActivity.java
  
    package com.example.uicomponents;

    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AlertDialog;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    public class AlertDialogActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alert_dialog);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //获取布局
            View view = View.inflate(AlertDialogActivity.this, R.layout.activity_alert_dialog_item, null);

            builder.setView(view);

            //创建对话框
            builder.create().show();
        }

    }
    
  3.使用XML定义菜单
  
  （1）activity_menu.xml
  
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MenuActivity">


        <TextView
            android:id="@+id/tv_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:text="@string/test_text"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </android.support.constraint.ConstraintLayout>
    
  （2）activity_menu_item.xml（res/menu/activity_menu_item.xml，作为菜单）
  
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
        <item
            android:id="@+id/file_menu"
            android:title="@string/xml_menu"
            app:showAsAction="always">
            <menu>
                <item
                    android:id="@+id/font_size_menu_item"
                    android:title="@string/font_size"
                    app:showAsAction="ifRoom|withText">
                    <menu>
                        <item
                            android:id="@+id/font_size_big_menu_item"
                            android:title="@string/font_size_big"
                            app:showAsAction="ifRoom|withText"></item>
                        <item
                            android:id="@+id/font_size_middle_menu_item"
                            android:title="@string/font_size_middle"
                            app:showAsAction="ifRoom|withText"></item>
                        <item
                            android:id="@+id/font_size_small_menu_item"
                            android:title="@string/font_size_small"
                            app:showAsAction="ifRoom|withText"></item>
                    </menu>
                </item>

                <item
                    android:id="@+id/common_menu_menu_item"
                    android:title="@string/common_menu"
                    app:showAsAction="ifRoom|withText"></item>
                <item
                    android:id="@+id/font_color_menu_item"
                    android:title="@string/font_color"
                    app:showAsAction="ifRoom|withText">


                    <menu>
                        <item
                            android:id="@+id/font_color_red_menu_item"
                            android:title="@string/font_color_red"
                            app:showAsAction="ifRoom|withText"></item>
                        <item
                            android:id="@+id/font_color_black_menu_item"
                            android:title="@string/font_color_black"
                            app:showAsAction="ifRoom|withText"></item>
                    </menu>


                </item>

                <item
                    android:id="@+id/exit_menu_item"
                    android:title="@string/exit_app"
                    app:showAsAction="ifRoom|withText"></item>

            </menu>
        </item>
    </menu>
    
  （3）MenuActivity.java
  
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
            getMenuInflater().inflate(R.menu.activity_menu_item, menu);
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
  
  4.创建上下文操作模式(ActionMode)的上下文菜单
  
  （1）activity_context_menu.xml
  
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="vertical">

        <LinearLayout
            android:id="@+id/linearLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:visibility="gone">

            <Button
                android:id="@+id/bt_cancel"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="取消选择" />

            <TextView
                android:id="@+id/tv_sum"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:gravity="center"
                android:text="共计" />

            <Button
                android:id="@+id/bt_delete"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="删除" />
        </LinearLayout>

        <ListView
            android:id="@+id/listView1"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"></ListView>

    </LinearLayout>
    
（2）activity_context_menu_item.xml

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal" >


        <ImageView
            android:id="@+id/image"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:src="@drawable/androidrobot"
            android:layout_weight="1"
            android:gravity="center"
            android:textColor="@color/colorAccent"
            android:adjustViewBounds="true"/>

        <TextView
            android:id="@+id/tv_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="3"
            android:textSize="30sp" />

        <CheckBox
            android:id="@+id/cb_select"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:clickable="false"
            android:visibility="invisible" />

    </LinearLayout>

（3）ContextMenuActivity.java

    package com.example.uicomponents;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;

    import android.os.Bundle;
    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.view.View.OnLongClickListener;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.LinearLayout;
    import android.widget.ListView;
    import android.widget.TextView;

    public class ContextMenuActivity extends Activity implements OnClickListener {

        private static final int NOSELECT_STATE = -1;// 表示未选中任何CheckBox

        private ListView listView;
        private Button bt_cancel, bt_delete;
        private TextView tv_sum;
        private LinearLayout linearLayout;

        private List<String> list = new ArrayList<String>();// 数据
        private List<String> list_delete = new ArrayList<String>();// 需要删除的数据
        private boolean isMultiSelect = false;// 是否处于多选状态

        private MyAdapter adapter;// ListView的Adapter

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_context_menu);

            listView = (ListView) findViewById(R.id.listView1);
            bt_cancel = (Button) findViewById(R.id.bt_cancel);
            bt_delete = (Button) findViewById(R.id.bt_delete);
            tv_sum = (TextView) findViewById(R.id.tv_sum);
            linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
            bt_cancel.setOnClickListener(this);
            bt_delete.setOnClickListener(this);

            // 设置初始数据
            list = new ArrayList<String>();
            for (int i = 0; i < 20; i++) {
                String str = "第" + i + "项";
                list.add(str);
            }

            // 未选中任何Item，position设置为-1
            adapter = new MyAdapter(ContextMenuActivity.this, list, NOSELECT_STATE);
            listView.setAdapter(adapter);
        }

        private class MyAdapter extends BaseAdapter {

            private List<String> list;
            private LayoutInflater inflater;

            private HashMap<Integer, Integer> isCheckBoxVisible;// 用来记录是否显示checkBox
            private HashMap<Integer, Boolean> isChecked;// 用来记录是否被选中

            @SuppressLint("UseSparseArrays")
            public MyAdapter(Context context, List<String> list, int position) {
                inflater = LayoutInflater.from(context);
                this.list = list;
                isCheckBoxVisible = new HashMap<Integer, Integer>();
                isChecked = new HashMap<Integer, Boolean>();
                // 如果处于多选状态，则显示CheckBox，否则不显示
                if (isMultiSelect) {
                    for (int i = 0; i < list.size(); i++) {
                        isCheckBoxVisible.put(i, CheckBox.VISIBLE);
                        isChecked.put(i, false);
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        isCheckBoxVisible.put(i, CheckBox.INVISIBLE);
                        isChecked.put(i, false);
                    }
                }

                // 如果长按Item，则设置长按的Item中的CheckBox为选中状态
                if (isMultiSelect && position >= 0) {
                    isChecked.put(position, true);
                }
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                // TODO Auto-generated method stub
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final ViewHolder viewHolder;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.activity_context_menu_item, null);
                    viewHolder.tv_Name = (TextView) convertView.findViewById(R.id.tv_name);
                    viewHolder.cb = (CheckBox) convertView.findViewById(R.id.cb_select);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                final String str = list.get(position);
                viewHolder.tv_Name.setText(str);
                // 根据position设置CheckBox是否可见，是否选中
                viewHolder.cb.setChecked(isChecked.get(position));
                viewHolder.cb.setVisibility(isCheckBoxVisible.get(position));
                // ListView每一个Item的长按事件
                convertView.setOnLongClickListener(new onMyLongClick(position, list));
                /*
                 * 在ListView中点击每一项的处理
                 * 如果CheckBox未选中，则点击后选中CheckBox，并将数据添加到list_delete中
                 * 如果CheckBox选中，则点击后取消选中CheckBox，并将数据从list_delete中移除
                 */
                convertView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // 处于多选模式
                        if (isMultiSelect) {
                            if (viewHolder.cb.isChecked()) {
                                viewHolder.cb.setChecked(false);
                                list_delete.remove(str);
                            } else {
                                viewHolder.cb.setChecked(true);
                                list_delete.add(str);
                            }
                            tv_sum.setText("共选择了" + list_delete.size() + "项");
                        }
                    }
                });
                return convertView;
            }

            class ViewHolder {
                public TextView tv_Name;
                public CheckBox cb;
            }

            // 自定义长按事件
            class onMyLongClick implements OnLongClickListener {

                private int position;
                private List<String> list;

                // 获取数据，与长按Item的position
                public onMyLongClick(int position, List<String> list) {
                    this.position = position;
                    this.list = list;
                }

                // 在长按监听时候，切记将监听事件返回ture
                @Override
                public boolean onLongClick(View v) {
                    isMultiSelect = true;
                    list_delete.clear();
                    // 添加长按Item到删除数据list中
                    list_delete.add(list.get(position));
                    linearLayout.setVisibility(View.VISIBLE);
                    tv_sum.setText("共选择了" + list_delete.size() + "项");
                    for (int i = 0; i < list.size(); i++) {
                        adapter.isCheckBoxVisible.put(i, CheckBox.VISIBLE);
                    }
                    // 根据position，设置ListView中对应的CheckBox为选中状态
                    adapter = new MyAdapter(ContextMenuActivity.this, list, position);
                    listView.setAdapter(adapter);
                    return true;
                }
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // 取消选择
                case R.id.bt_cancel:
                    isMultiSelect = false;// 退出多选模式
                    list_delete.clear();// 清楚选中的数据
                    // 重新加载Adapter
                    adapter = new MyAdapter(ContextMenuActivity.this, list, NOSELECT_STATE);
                    listView.setAdapter(adapter);
                    linearLayout.setVisibility(View.GONE);
                    break;
                // 删除
                case R.id.bt_delete:
                    isMultiSelect = false;
                    // 将数据从list中移除
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = 0; j < list_delete.size(); j++) {
                            if (list.get(i).equals(list_delete.get(j))) {
                                list.remove(i);
                            }
                        }
                    }
                    list_delete.clear();
                    // 重新加载Adapter
                    adapter = new MyAdapter(ContextMenuActivity.this, list, NOSELECT_STATE);
                    listView.setAdapter(adapter);
                    linearLayout.setVisibility(View.GONE);
                    break;

                default:
                    break;
            }
        }

    }

  ## 三. 实验结果及截图
  
  1.利用SimpleAdapter实现界面效果
  
  ![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/1r.png)
  
  2.创建自定义布局的AlertDialog
  
  ![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/2r.png)
  
  3.使用XML定义菜单
  
  ![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/3r.png)
  
  4.创建上下文操作模式(ActionMode)的上下文菜单
  
  ![Image text](https://github.com/1045896802/UIcomponents/blob/master/img/4r.png)


