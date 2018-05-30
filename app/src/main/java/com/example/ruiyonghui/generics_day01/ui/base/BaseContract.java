package com.example.ruiyonghui.generics_day01.ui.base;

public interface BaseContract {
    //抽取所有Presenter共性，比如绑定，解绑
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);

        void detachView();
    }
     //抽取所有View的共性，比如显示进度条和关闭进度
     interface BaseView{
        //进度条
         void showLoading();

         //停止进度条
         void dismissLoading();
     }
}
