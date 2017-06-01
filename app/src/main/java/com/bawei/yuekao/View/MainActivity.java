package com.bawei.yuekao.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.bawei.yuekao.R;
import com.bawei.yuekao.adapter.vp_main_adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TabLayout tb;
    private ViewPager vp_main;
    private List<Fragment>list=new ArrayList<Fragment>();
    private List<String>title=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        vp_main.setAdapter(new vp_main_adapter(getSupportFragmentManager(),list,title));
        tb.setupWithViewPager(vp_main);
    }

    private void initData() {
        title.add("最新日报");
        title.add("专栏");
        title.add("热门");
        title.add("主题日报");
        Fragment1 fragment1 = new Fragment1();
        fragment2 fragment2 = new fragment2();
        Fragment3 fragment3 = new Fragment3();
        fragment2 fragment4 = new fragment2();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
    }


    private void initView() {
        tb = (TabLayout) findViewById(R.id.tb);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        vp_main .setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;  //修改为true
            }
        });
    }
}
