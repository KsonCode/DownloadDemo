package com.bwie.downloaddemo.download;

public interface DownloadCallback {

    void finish();//完成
    void error();//下载失败
    void progress(int progress);//下载进度
}
