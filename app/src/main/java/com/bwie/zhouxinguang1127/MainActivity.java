package com.bwie.zhouxinguang1127;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.zhouxinguang1127.adapter.MyBase;
import com.bwie.zhouxinguang1127.base.BaseActivity;
import com.bwie.zhouxinguang1127.base.BasePresenter;
import com.bwie.zhouxinguang1127.bean.StudentBean;
import com.bwie.zhouxinguang1127.presenter.Presenter;
import com.bwie.zhouxinguang1127.until.Until;
import com.bwie.zhouxinguang1127.view.MyLine;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends BaseActivity {

    private EditText edit;
    private Button button;
    private RecyclerView recy;
    private String name;
    private Button button1;
    private MyLine myLine;
    private List<StudentBean.ResultBean> result;
    private Context context;

    @Override
    protected void startCoding() {
    }

    @Override
    protected BasePresenter inisPresenter() {
        return new Presenter();
    }

    @Override
    protected void inisView() {
        edit = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        myLine = findViewById(R.id.myline);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new GridLayoutManager(this, 2));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    myLine.Addach(name);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode(name) + "&page=1&count=5";
                        menter.onstart(url);
                        break;
                }
            }
        });


    }

    @Override
    protected int inisid() {
        return R.layout.activity_main;
    }

    @Override
    public void onsuccess(String json) {
//        解析数据
        StudentBean studentBean = new Gson().fromJson(json, StudentBean.class);
        result = studentBean.getResult();
//        创建适配器
        MyBase myBase = new MyBase(MainActivity.this, result);
        recy.setAdapter(myBase);
//        点击跳转图2
        myBase.onSetname(new MyBase.SetClick() {
            @Override
            public void onSetClick(int position) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError(String error) {

    }


}
