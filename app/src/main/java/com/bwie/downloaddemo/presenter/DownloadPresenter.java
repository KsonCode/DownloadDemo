package com.bwie.downloaddemo.presenter;

import android.content.Context;

import com.bwie.downloaddemo.contract.DownloadContract;
import com.bwie.downloaddemo.download.DownloadCallback;

public class DownloadPresenter extends DownloadContract.DownloadPresenter {
    @Override
    public void download(Context mContext, String loadurl, String filepath) {

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

    @Override
    public void pause() {

        model.pause();
    }

    @Override
    public void cancel() {

        model.cancel();
    }

    @Override
    public void start() {

        model.start();
    }
}
