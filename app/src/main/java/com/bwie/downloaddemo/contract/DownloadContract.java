package com.bwie.downloaddemo.contract;


import android.content.Context;

import com.bwie.downloaddemo.base.mvp.BasePresenter;
import com.bwie.downloaddemo.base.mvp.IBaseModel;
import com.bwie.downloaddemo.base.mvp.IBaseView;
import com.bwie.downloaddemo.download.DownloadCallback;
import com.bwie.downloaddemo.model.DownloadModel;


/**
 * 商品相关契约类
 */
public interface DownloadContract {

     abstract class DownloadPresenter extends BasePresenter<IDownloadModel,IDownloadView> {
        public abstract void download(Context mContext,String loadurl, String filepath);
        public abstract void pause();//暂停
        public abstract void cancel();//取消
        public abstract void start();//继续

         @Override
         public IDownloadModel getModel() {
             return new DownloadModel();
         }
     }

    interface IDownloadModel extends IBaseModel {

         //下载
        void download(Context mContext, String loadurl, String filepath, DownloadCallback downloadCallback);
        void pause();//暂停
        void cancel();//取消
        void start();//继续

    }

    interface IDownloadView extends IBaseView {

        void finish();//完成
        void error();//下载失败
        void progress(int progress);//下载进度

    }
}
