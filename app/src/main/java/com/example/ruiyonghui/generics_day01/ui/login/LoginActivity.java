package com.example.ruiyonghui.generics_day01.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.generics_day01.R;
import com.example.ruiyonghui.generics_day01.bean.UserBean;
import com.example.ruiyonghui.generics_day01.component.DaggerHttpComponent;
import com.example.ruiyonghui.generics_day01.module.HttpModule;
import com.example.ruiyonghui.generics_day01.ui.base.BaseActivity;
import com.example.ruiyonghui.generics_day01.ui.login.contract.LoginContract;
import com.example.ruiyonghui.generics_day01.ui.login.presenter.LoginPresenter;


public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener, LoginContract.View {

    private RelativeLayout mLoginTitleRelative;
    private EditText mMobile;
    private EditText mPassword;
    private Button mBtLogin;
    private TextView mTextRegist;
    private ImageView cha;
    private ImageView mLoginByWechat;
    private ImageView mLoginByQq;


    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mLoginTitleRelative = (RelativeLayout) findViewById(R.id.login_title_relative);
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);
        mTextRegist = (TextView) findViewById(R.id.text_regist);
        mTextRegist.setOnClickListener(this);
        cha=(ImageView)findViewById(R.id.cha);
        cha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cha:
                finish();
            case R.id.text_regist:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.btLogin:
                //需要调用P层，去完成接口调用
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.login(mobile, password);
                break;
        }
    }


    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(LoginActivity.this, userBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
