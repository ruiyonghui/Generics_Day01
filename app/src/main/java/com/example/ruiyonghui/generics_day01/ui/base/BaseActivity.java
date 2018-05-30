package com.example.ruiyonghui.generics_day01.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ruiyonghui.generics_day01.inter.IBase;

import javax.inject.Inject;

public abstract class BaseActivity <T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView{

    @Inject
    protected  T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();
        //绑定
        mPresenter.attchView(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        //绑定
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
