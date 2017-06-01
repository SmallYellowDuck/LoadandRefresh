package com.bawei.yuekao.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yuekao.Bean.MainBean;
import com.bawei.yuekao.R;
import com.bawei.yuekao.utils.GlideImagge;
import com.bawei.yuekao.utils.GsonUtils;
import com.bawei.yuekao.utils.HttpUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class fragment2 extends Fragment {
    private Banner banner;
    private List<String>list=new ArrayList<String>();
    private List<MainBean.TopStoriesBean> mTop_stories;
        private Handler handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what){
                        case 1:
                            String json = (String) msg.obj;
                            MainBean bean = (MainBean) new GsonUtils(json, MainBean.class).jsonToGson();
                            mTop_stories = bean.getTop_stories();
                            list.clear();
                            for (int i = 0; i <mTop_stories.size() ; i++) {
                                String image = mTop_stories.get(i).getImage();
                                list.add(image);
                            }
                            banner.setImages(list);
                            banner.start();
                            break;
                    }
                }
            };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner= (Banner) getView().findViewById(R.id.banner);
        banner.setImageLoader(new GlideImagge());
        HttpUtils.Getjson("http://news-at.zhihu.com/api/4/news/latest",handler,1);
    }
}
