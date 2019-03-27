# Android UI组件

## 一. 实验内容

1.利用SimpleAdapter实现如下界面效果

（1）注意列表项的布局

（2）图片使用QQ群附件资源

（3）使用Toast显示选中的列表项信息

2.创建自定义布局的AlertDialog

创建如图所示的自定义对话框

请创建一个如图所示的布局，
调用 AlertDialog.Builder 对象上的 setView() 将布局添加到
AlertDialog。

3.使用XML定义菜单

![Image text](https://raw.githubusercontent.com/1045896802/Layout/master/img/1y.png)

4.创建上下文操作模式(ActionMode)的上下文菜单

![Image text](https://raw.githubusercontent.com/1045896802/Layout/master/img/2y.png)

## 二. 关键代码

1.线性布局

  线性布局中由于需要给TextView组件加上边框，故在drawable目录下新建textview_border.xml文件，代码如下：

    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle">

        <stroke
            android:width="1dip"
            android:color="#ffffff" />
    </shape>
    
  在布局文件中使用一个垂直的LinearLayout嵌套一个水平的LinearLayout，代码如下：
  
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      android:id="@+id/LinearLayout"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:background="#000000"
      android:orientation="vertical">

      <LinearLayout
          android:id="@+id/LinearLayout1"
          android:layout_width="match_parent"
          android:layout_height="wrap_content">

          <TextView
              android:id="@+id/textView1"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="One,One"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView2"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="One,Two"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView3"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="One,Three"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView4"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="One,Four"
              android:textColor="#CCCCCC"></TextView>

      </LinearLayout>

      <LinearLayout
          android:id="@+id/LinearLayout2"
          android:layout_width="match_parent"
          android:layout_height="wrap_content">

          <TextView
              android:id="@+id/textView5"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Two,One"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView6"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Two,Two"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView7"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Two,Three"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView8"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Two,Four"
              android:textColor="#CCCCCC"></TextView>


      </LinearLayout>

      <LinearLayout
          android:id="@+id/LinearLayout3"
          android:layout_width="match_parent"
          android:layout_height="wrap_content">

          <TextView
              android:id="@+id/textView9"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Three,One"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView10"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Three,Two"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView11"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Three,Three"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView12"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Three,Four"
              android:textColor="#CCCCCC"></TextView>


      </LinearLayout>

      <LinearLayout
          android:id="@+id/LinearLayout4"
          android:layout_width="match_parent"
          android:layout_height="wrap_content">

          <TextView
              android:id="@+id/textView13"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Four,One"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView14"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Four,Two"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView15"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Four,Three"
              android:textColor="#CCCCCC"></TextView>

          <TextView
              android:id="@+id/textView16"
              android:layout_width="wrap_content"
              android:layout_height="40dp"
              android:layout_margin="5dp"
              android:layout_weight="1"
              android:background="@drawable/textview_border"
              android:gravity="center"
              android:paddingLeft="5dp"
              android:paddingRight="5dp"
              android:text="Four,Four"
              android:textColor="#CCCCCC"></TextView>
        </LinearLayout>
    </LinearLayout>
    
    
  2.约束布局
  
  布局文件，代码如下
  
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#000000">


        <TextView
            android:id="@+id/textView25"
            android:layout_width="410dp"
            android:layout_height="80dp"
            android:layout_marginTop="272dp"
            android:background="#FF4040"
            android:gravity="center"
            android:text="VIOLET"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView24"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginLeft="172dp"
            android:layout_marginTop="148dp"
            android:background="#0000CD"
            android:gravity="center"
            android:text="INDIGO"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.547"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView26"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginLeft="172dp"
            android:layout_marginTop="148dp"
            android:background="#4876FF"
            android:gravity="center"
            android:text="BLUE"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView18"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:background="#FF4040"
            android:gravity="center"
            android:text="RED"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView19"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:background="#FF7F50"
            android:gravity="center"
            android:text="ORANGE"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:layout_editor_absoluteX="172dp" />

        <TextView
            android:id="@+id/TextView1"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:background="#FF4040"
            android:gravity="center"
            android:text="RED"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginLeft="80dp"
            android:layout_marginTop="148dp"
            android:background="#00FF00"
            android:gravity="center"
            android:text="GREEN"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView17"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_marginLeft="332dp"
            android:background="#FFFF00"
            android:gravity="center"
            android:text="YELLOW"
            android:textAppearance="@style/TextAppearance.AppCompat.Button"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

    </android.support.constraint.ConstraintLayout>
    
  3.表格布局
  
  布局文件，代码如下
  
    <?xml version="1.0" encoding="utf-8"?>
    <TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/TableLayout01"
        android:layout_width="match_parent"

        android:layout_height="match_parent"
        android:background="#000000"
        android:shrinkColumns="1"
        android:stretchColumns="2">

        <Button
            android:id="@+id/Button1"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Open...                                                                                               Ctrl-O"
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />

        <Button
            android:id="@+id/Button2"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Save...                                                                                                Ctrl-S"
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />

        <Button
            android:id="@+id/Button3"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Save As...                                                                              Ctrl+Shift+S"
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />

        <View
            android:layout_width="match_parent"
            android:layout_height="1px"
            android:background="#FFFFFF"></View>

        <Button
            android:id="@+id/Button4"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Import..."
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />

        <Button
            android:id="@+id/Button5"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Export...                                                                                           Ctrl+E"
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />

        <View
            android:layout_width="match_parent"
            android:layout_height="1px"
            android:background="#FFFFFF"></View>

        <Button
            android:id="@+id/Button6"
            android:layout_width="wrap_content"
            android:layout_height="25dp"
            android:background="#000000"
            android:gravity="left"
            android:text=" Quit"
            android:textAllCaps="false"
            android:textColor="#FFFFFF" />


    </TableLayout>

  ## 三. 实验结果及截图
  
  1.线性布局
  
  ![Image text](https://raw.githubusercontent.com/1045896802/Layout/master/img/1r.png)
  
  2.约束布局
  
  ![Image text](https://raw.githubusercontent.com/1045896802/Layout/master/img/2r.png)
  
  3.表格布局
  
  ![Image text](https://raw.githubusercontent.com/1045896802/Layout/master/img/3r.png)


