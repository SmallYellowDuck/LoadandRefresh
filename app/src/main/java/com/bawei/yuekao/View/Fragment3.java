package com.bawei.yuekao.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.yuekao.Bean.MainBean;
import com.bawei.yuekao.R;
import com.bawei.yuekao.utils.GsonUtils;
import com.bawei.yuekao.utils.HttpUtils;
import com.bumptech.glide.Glide;
import com.lvr.library.adapter.CommonAdapter;
import com.lvr.library.anims.adapters.ScaleInAnimationAdapter;
import com.lvr.library.anims.animators.LandingAnimator;
import com.lvr.library.holder.BaseViewHolder;
import com.lvr.library.recyclerview.HRecyclerView;
import com.lvr.library.recyclerview.OnLoadMoreListener;
import com.lvr.library.recyclerview.OnRefreshListener;

import java.util.List;


public class Fragment3 extends Fragment implements OnLoadMoreListener,OnRefreshListener{
    private HRecyclerView mHRecyclerView;
    private List<MainBean.StoriesBean> mStories;
    private LinearLayoutManager mLinearLayoutManager;
    private LoadMoreFooterView mLoadMoreFooterView;
        private Handler handler=new Handler(){
                @Override
                public void handleMessage(final Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what){
                        case 0:
                            Toast.makeText(getActivity(),"刷新",Toast.LENGTH_SHORT).show();
                            mHRecyclerView.setRefreshing(false);
                            break;
                        case 2:
                            String json2 = (String) msg.obj;
                            MainBean bean2 = (MainBean) new GsonUtils(json2, MainBean.class).jsonToGson();
                            mStories = bean2.getStories();

                            CommonAdapter<MainBean.StoriesBean> mAdapter = new CommonAdapter<MainBean.StoriesBean>(getActivity(), R.layout.recycler_item,mStories) {
                                @Override
                                public void convert(BaseViewHolder holder, int position) {
                                            holder.setText(R.id.tv_item,mStories.get(position).getTitle());
                                    ImageView iv = holder.getView(R.id.iv_item);
                                    Glide.with(getActivity()).load(mStories.get(position).getImages().get(0)).into(iv);
                                }
                            };
                            mLinearLayoutManager = new LinearLayoutManager(getActivity());
                            mHRecyclerView.setLayoutManager(mLinearLayoutManager);
                            mHRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                            mHRecyclerView.setItemAnimator(new LandingAnimator());
                            ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(mAdapter);
                            scaleAdapter.setFirstOnly(false);
                            scaleAdapter.setDuration(500);
                            mHRecyclerView.setAdapter(scaleAdapter);
                            break;
                        case 1:
                            mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
                            Toast.makeText(getActivity(),"加载",Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHRecyclerView= (HRecyclerView) getView().findViewById(R.id.mrecycler);
        HttpUtils.Getjson("http://news-at.zhihu.com/api/4/news/before/20131119",handler,2);
        mHRecyclerView.setOnRefreshListener(this);
        mHRecyclerView.setOnLoadMoreListener(this);
        mLoadMoreFooterView = (LoadMoreFooterView) mHRecyclerView.getLoadMoreFooterView();
        mHRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mHRecyclerView.setRefreshing(true);
            }
        });
    }

    @Override
    public void onLoadMore() {
        if(mLoadMoreFooterView.canLoadMore()){
            mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //假装加载耗时数据
                    SystemClock.sleep(1000);
                    Message message = Message.obtain();
                    message.what =1;
                   handler.sendMessage(message);
                }
            }).start();
        }
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //假装加载耗时数据
                SystemClock.sleep(1000);
                Message msg = Message.obtain();
                msg.what=0;
                handler.sendMessage(msg);
            }
        }).start();
    }
}
