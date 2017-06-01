package com.bawei.yuekao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class vp_main_adapter extends FragmentPagerAdapter {
    private List<Fragment>list;
    private List<String>title;

    public vp_main_adapter(FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position).toUpperCase();
    }
}
