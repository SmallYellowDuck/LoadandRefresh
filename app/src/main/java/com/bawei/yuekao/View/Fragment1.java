package com.bawei.yuekao.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.yuekao.Bean.MainBean;
import com.bawei.yuekao.R;
import com.bawei.yuekao.adapter.RecyclerViewAdapter;
import com.bawei.yuekao.utils.GsonUtils;
import com.bawei.yuekao.utils.HttpUtils;

import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class Fragment1 extends Fragment {
    private SwipeRefreshLayout srl;
    private RecyclerView rl;
    private List<MainBean.TopStoriesBean> mTop_stories;
    private List<MainBean.StoriesBean> mStories;
    private RecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    int lastVisibleItem;
    private TextView tv;
      private Handler handler=new Handler(){
              @Override
              public void handleMessage(Message msg) {
                  super.handleMessage(msg);
                  switch (msg.what){
                      case 1:
                          String json = (String) msg.obj;
                          MainBean bean = (MainBean) new GsonUtils(json, MainBean.class).jsonToGson();
                          mTop_stories = bean.getTop_stories();
                          mStories = bean.getStories();
                          tv.setVisibility(View.GONE);
                          break;
                      case 2:
                          String json2 = (String) msg.obj;
                          MainBean bean2 = (MainBean) new GsonUtils(json2, MainBean.class).jsonToGson();
                          mStories = bean2.getStories();
                          srl.setRefreshing(false);
                          break;

                  }
                  mAdapter = new RecyclerViewAdapter(mStories, getActivity(), mTop_stories);
                  rl.setAdapter(mAdapter);
                  rl.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                  mLinearLayoutManager = new LinearLayoutManager(getActivity());
                  rl.setLayoutManager(mLinearLayoutManager);

              }
          };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        HttpUtils.Getjson("http://news-at.zhihu.com/api/4/news/latest",handler,1);
        refreshData();

        rl.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == mAdapter.getItemCount()){
                    tv.setVisibility(View.VISIBLE);
                    SystemClock.sleep(2000);
                    HttpUtils.Getjson("http://news-at.zhihu.com/api/4/news/latest",handler,1);
                }
            }
        });

    }


    private void initview() {
        srl= (SwipeRefreshLayout) getView().findViewById(R.id.srl);
        rl= (RecyclerView) getView().findViewById(R.id.rl);
        srl.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_red_light,android.R.color.holo_orange_light,android.R.color.holo_green_light);
        srl.setProgressViewOffset(true, 0, 100);
        tv= (TextView) getView().findViewById(R.id.tv_loadmore);
    }
    private void refreshData() {
        //下拉刷新
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                HttpUtils.Getjson("http://news-at.zhihu.com/api/4/news/before/20131119",handler,2);
            }
        });
    }
}