package com.bwie.downloaddemo.presenter;

import android.content.Context;

import com.bwie.downloaddemo.contract.DownloadContract;
import com.bwie.downloaddemo.download.DownloadCallback;

public class DownloadPresenter extends DownloadContract.DownloadPresenter {
    @Override
    public void download(Context mContext, String loadurl, String filepath) {

        //下载
        model.download(mContext, loadurl, filepath, new DownloadCallback() {
            @Override
            public void finish() {
                view.finish();
            }

            @Override
            public void error() {
                view.error();
            }

            @Override
            public void progress(int progress) {
                view.progress(progress);

            }
        });
    }

    /**
     * 暂停
     */
    @Override
    public void pause() {

        model.pause();
    }

    /**
     * 取消
     */
    @Override
    public void cancel() {

        model.cancel();
    }

    /**
     * 继续
     */
    @Override
    public void start() {

        model.start();
    }
}
