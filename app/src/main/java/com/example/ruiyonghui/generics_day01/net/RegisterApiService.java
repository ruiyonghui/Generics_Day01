package com.example.ruiyonghui.generics_day01.net;

import com.example.ruiyonghui.generics_day01.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApiService {
    @FormUrlEncoded
    @POST("user/reg")
    Observable<RegisterBean> register(@Field("mobile") String mobile,@Field("password") String password);
}
