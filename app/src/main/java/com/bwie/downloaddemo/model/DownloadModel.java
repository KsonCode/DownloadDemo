package com.bwie.downloaddemo.model;

import android.content.Context;

import com.bwie.downloaddemo.contract.DownloadContract;
import com.bwie.downloaddemo.download.DownLoadFile;
import com.bwie.downloaddemo.download.DownloadCallback;

public class DownloadModel implements DownloadContract.IDownloadModel {
    private DownLoadFile downLoadFile;
    @Override
    public void download(final Context context, String loadUrl, String filePath, final DownloadCallback downloadCallback) {

        downLoadFile = new DownLoadFile(context, loadUrl, filePath, 3);
        downLoadFile.downLoad();
        downLoadFile.setOnDownLoadListener(new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                if (downloadCallback != null) {
                    downloadCallback.progress(progress);
                }
            }

            @Override
            public void onComplete() {
                if (downloadCallback != null) {
                    downloadCallback.finish();
                }
            }

            @Override
            public void onFailure() {
                if (downloadCallback != null) {
                    downloadCallback.error();
                }
            }
        });
    }

    @Override
    public void pause() {

        downLoadFile.onPause();
    }

    @Override
    public void cancel() {

        downLoadFile.cancel();

    }

    @Override
    public void start() {

        downLoadFile.onStart();
    }
}
