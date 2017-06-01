package com.bawei.yuekao.utils;

import android.os.Handler;
import android.os.Message;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class HttpUtils {
    public static void Getjson(String url, final Handler handler, final int what){
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Message message = new Message();
                        message.obj=response;
                        message.what=what;
                        handler.sendMessage(message);
                    }
                });
    }
}
