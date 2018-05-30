package com.example.ruiyonghui.generics_day01.ui.login.contract;

import com.example.ruiyonghui.generics_day01.bean.RegisterBean;
import com.example.ruiyonghui.generics_day01.ui.base.BaseContract;

public interface RegisterContract {
    interface View extends BaseContract.BaseView{
        void registerSuccess(RegisterBean registerBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void register(String mobile,String password);
    }
}
