package com.bwie.downloaddemo;import android.app.Activity;import android.os.Bundle;import android.os.Environment;import android.view.View;import android.widget.Button;import android.widget.ProgressBar;import android.widget.TextView;import android.widget.Toast;import com.blankj.utilcode.util.ToastUtils;import com.bwie.downloaddemo.base.BaseActivity;import com.bwie.downloaddemo.base.mvp.BasePresenter;import com.bwie.downloaddemo.contract.DownloadContract;import com.bwie.downloaddemo.download.DownLoadFile;import com.bwie.downloaddemo.model.DownloadModel;import com.bwie.downloaddemo.presenter.DownloadPresenter;import butterknife.BindView;import butterknife.OnClick;public class MainActivity extends BaseActivity<DownloadModel, DownloadPresenter> implements DownloadContract.IDownloadView {    private String loadUrl = "http://gdown.baidu.com/data/wisegame/d2fbbc8e64990454/wangyiyunyinle_87.apk";    private String filePath = Environment.getExternalStorageDirectory()+"/"+"网易云音乐.apk";    @BindView(R.id.progressTv)    TextView progressTv;    @BindView(R.id.progress)     ProgressBar progressBar;    /**     * 下载     * @param view     */    @OnClick(R.id.download)    public void download(View view){        presenter.download(this,loadUrl,filePath);    }    /**     * 暂停     * @param view     */    @OnClick(R.id.pause)    public void pause(View view){        presenter.pause();    }    /**     * 继续     * @param view     */    @OnClick(R.id.start)    public void start(View view){        presenter.start();    }    /**     * 初始化数据     */    @Override    protected void initData() {    }    @Override    protected void initView() {    }    @Override    protected int bindLayoutId() {        return R.layout.activity_main;    }    @Override    protected void onDestroy() {        System.out.println("ondestroy");        presenter.cancel();        super.onDestroy();    }    /**     * 下载失败     */    @Override    public void error() {        showToast("下载失败");    }    /**     * 下载进度     * @param progress     */    @Override    public void progress(int progress) {        progressTv.setText("当前下载进度："+progress+"%");        progressBar.setProgress(progress);    }    @Override    public BasePresenter initPresenter() {        return new DownloadPresenter();    }    /**     * 显示加载进度     */    @Override    public void showLoading() {    }    /**     * 隐藏个加载进度     */    @Override    public void hideLoading() {    }    /**     * 请求失败     * @param msg     */    @Override    public void failure(String msg) {    }}