package com.example.uicomponents;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
