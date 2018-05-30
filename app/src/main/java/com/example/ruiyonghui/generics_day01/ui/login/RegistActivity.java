package com.example.ruiyonghui.generics_day01.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ruiyonghui.generics_day01.R;
import com.example.ruiyonghui.generics_day01.bean.RegisterBean;
import com.example.ruiyonghui.generics_day01.bean.UserBean;
import com.example.ruiyonghui.generics_day01.component.DaggerHttpComponent;
import com.example.ruiyonghui.generics_day01.module.HttpModule;
import com.example.ruiyonghui.generics_day01.ui.base.BaseActivity;
import com.example.ruiyonghui.generics_day01.ui.login.contract.RegisterContract;
import com.example.ruiyonghui.generics_day01.ui.login.presenter.RegisterPresenter;

public class RegistActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View, View.OnClickListener {

    private Button mBt;
    private ImageView mChaIamge;
    private RelativeLayout mLoginTitleRelative;
    private EditText mMobile;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }



    private void initView() {
        mChaIamge = (ImageView) findViewById(R.id.cha_iamge);
        mChaIamge.setOnClickListener(this);
        mLoginTitleRelative = (RelativeLayout) findViewById(R.id.login_title_relative);
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cha_iamge:
                finish();
                break;
            case R.id.bt:
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.register(mobile, password);
                break;

        }
    }

    @Override
    public void registerSuccess(RegisterBean registerBean) {
        String msg = registerBean.getCode();
        if (msg.equals("0")){
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(RegistActivity.this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(RegistActivity.this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
//        Toast.makeText(RegistActivity.this, "注册回调了", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
//        startActivity(intent);
    }
}
