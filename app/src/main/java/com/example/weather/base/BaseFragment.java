package com.example.weather.base;

import androidx.fragment.app.Fragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
/*
xutils加载网络数据步骤
1.声明整体模块
2.执行网络请求
 */

public class BaseFragment extends Fragment implements Callback.CommonCallback<String> {
    public void loadData(String path){
       RequestParams params= new RequestParams(path);
        x.http().get(params,this);
    }

    //获取成功，回调接口
    @Override
    public void onSuccess(String result) {

    }

    //获取失败，回调接口
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    //取消请求时，回调接口
    @Override
    public void onCancelled(CancelledException cex) {

    }

    //请求完成后，回调接口
    @Override
    public void onFinished() {

    }
}
