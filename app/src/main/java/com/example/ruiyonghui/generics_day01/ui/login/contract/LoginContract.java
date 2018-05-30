package com.example.ruiyonghui.generics_day01.ui.login.contract;

import com.example.ruiyonghui.generics_day01.bean.UserBean;
import com.example.ruiyonghui.generics_day01.ui.base.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void login(String mobile,String password);
    }

}
