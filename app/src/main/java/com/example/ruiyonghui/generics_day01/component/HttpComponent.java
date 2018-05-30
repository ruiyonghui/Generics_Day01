package com.example.ruiyonghui.generics_day01.component;

import com.example.ruiyonghui.generics_day01.module.HttpModule;
import com.example.ruiyonghui.generics_day01.ui.login.LoginActivity;
import com.example.ruiyonghui.generics_day01.ui.login.RegistActivity;

import dagger.Component;
@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(LoginActivity loginActivity);
    void inject(RegistActivity registActivity);

}
