package com.vode.aibuy.utils;

import com.vode.aibuy.bean.Repo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cj on 2018/3/9.
 */

public interface RetrofitInteface {

    @GET("api/data/Android/10/1")
    Call<Repo> getAndroidInfo();

}
