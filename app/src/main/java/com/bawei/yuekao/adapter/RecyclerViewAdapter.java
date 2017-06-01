package com.bawei.yuekao.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.yuekao.Bean.MainBean;
import com.bawei.yuekao.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MainBean.StoriesBean> mStories;
    private Context mContext;
    private List<MainBean.TopStoriesBean> mTop_stories;
    private List<View>dot=new ArrayList<View>();
    private int old=0;

    public RecyclerViewAdapter(List<MainBean.StoriesBean> stories, Context context, List<MainBean.TopStoriesBean> top_stories) {
        mStories = stories;
        mContext = context;
        mTop_stories = top_stories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view1 = View.inflate(mContext, R.layout.viewpager_item, null);
                ViewHolderTop viewHolder = new ViewHolderTop(view1);
                return viewHolder;
            case 2:
                View view2 = View.inflate(mContext, R.layout.recycler_item, null);
                ViewHolder viewHolder2 = new ViewHolder(view2);
                return viewHolder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).getdata(mStories.get(position));
        }
        if (holder instanceof ViewHolderTop){
            ((ViewHolderTop) holder).getdata();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }
        return 2;
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv_item);
            iv= (ImageView) itemView.findViewById(R.id.iv_item);
        }
        private void getdata(MainBean.StoriesBean bean){
            tv.setText(bean.getTitle());
            Glide.with(mContext).load(bean.getImages().get(0)).into(iv);
        }
    }

    public class ViewHolderTop extends RecyclerView.ViewHolder {
        ViewPager vp;
        LinearLayout lldot;

        public ViewHolderTop(View itemView) {
            super(itemView);
            vp = (ViewPager) itemView.findViewById(R.id.vp);
            lldot = (LinearLayout) itemView.findViewById(R.id.lldot);
        }

        private void getdata() {
            vp.setAdapter(new vp_adapter(mContext, mTop_stories));
            lldot.removeAllViews();
            for (int i = 0; i < mTop_stories.size(); i++) {
                View view = new View(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
                params.rightMargin = 5;
                params.leftMargin = 5;
                view.setLayoutParams(params);
                view.setBackgroundResource(R.mipmap.presence_invisible);
                lldot.addView(view);
                dot.add(view);
                vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        dot.get(position % dot.size()).setBackgroundResource(R.mipmap.presence_online);
                        dot.get(old % dot.size()).setBackgroundResource(R.mipmap.presence_invisible);
                        old = position;
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
            }
        }


    }}
