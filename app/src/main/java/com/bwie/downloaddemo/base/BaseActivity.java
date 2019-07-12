package com.bwie.downloaddemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.blankj.utilcode.util.LogUtils;
import com.bwie.downloaddemo.base.mvp.BasePresenter;
import com.bwie.downloaddemo.base.mvp.IBaseModel;
import com.bwie.downloaddemo.base.mvp.IBaseView;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<M extends IBaseModel,P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    private Unbinder unbinder;
    public M model;
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        init();
    }

    private void init(){
        //沉浸式
        ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();//透明效果

        presenter = (P) initPresenter();
        if (presenter!=null){
            model = (M) presenter.getModel();
            if (model!=null){
                //绑定
                presenter.attach(model,this);

            }
        }

        initData();
    }

    protected abstract void initData();

    protected abstract void initView();


    /**
     * 绑定根布局id
     *
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 显示toast
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 无参跳转
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 有参跳转
     *
     * @param clz
     */
    public void startActivity(Bundle bundle, Class<?> clz) {
        Intent intent = new Intent(this, clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     *
     * @param status
     */
    public void isStatus(boolean status){
        if (status){
            //沉浸式代码
        }
    }
    /**
     *全屏
     * @param
     */
    public void isFullscreen(boolean fullscreenn){
        if (fullscreenn){
            //全屏代码
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();//解绑butterkinife
        }
    }
}
