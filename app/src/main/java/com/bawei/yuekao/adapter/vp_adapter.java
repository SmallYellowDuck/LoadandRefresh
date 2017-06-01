package com.bawei.yuekao.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bawei.yuekao.Bean.MainBean;
import com.bawei.yuekao.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class vp_adapter extends PagerAdapter {
    private Context context;
    private List vplist=new ArrayList();
    private List<MainBean.TopStoriesBean> mTop_stories;

    public vp_adapter(Context context, List<MainBean.TopStoriesBean> top_stories) {
        this.context = context;
        mTop_stories = top_stories;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context).load(mTop_stories.get(position%mTop_stories.size()).getImage()).placeholder(R.mipmap.ic_launcher).into(iv);
        ViewParent parent = iv.getParent();
        if (parent!=null){
            container.removeView(iv);
        }
        container.addView(iv);
        vplist.add(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
        container.removeView((View) vplist.get(position%mTop_stories.size()));


    }
}
