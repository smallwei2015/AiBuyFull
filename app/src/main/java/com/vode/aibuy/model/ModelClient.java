package com.vode.aibuy.model;

import com.vode.aibuy.bean.Repo;
import com.vode.aibuy.bean.User;
import com.vode.aibuy.utils.RetrofitApi;
import com.vode.aibuy.utils.RetrofitInteface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cj on 2018/3/9.
 */

public class ModelClient {

    static RetrofitInteface retrofit = RetrofitApi.build().create(RetrofitInteface.class);


    public static void loadUser(final LoadDataInteface<User> user) {
        retrofit.getAndroidInfo().enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                List<Repo.ResultsBean> results = response.body().getResults();


            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {

            }
        });
    }
}
