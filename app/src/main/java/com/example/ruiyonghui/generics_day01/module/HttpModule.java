package com.example.ruiyonghui.generics_day01.module;



import com.example.ruiyonghui.generics_day01.net.Api;
import com.example.ruiyonghui.generics_day01.net.LoginApi;
import com.example.ruiyonghui.generics_day01.net.LoginApiService;
import com.example.ruiyonghui.generics_day01.net.RegisterApi;
import com.example.ruiyonghui.generics_day01.net.RegisterApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {


    @Provides
    LoginApi provideLoginApi() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    RegisterApi provideRegisterApi(OkHttpClient.Builder builder){
        RegisterApiService registerApiService = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build()
                .create(RegisterApiService.class);

        return RegisterApi.getRegisterApi(registerApiService);

    }

}
