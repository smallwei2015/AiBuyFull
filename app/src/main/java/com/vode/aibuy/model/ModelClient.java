package com.vode.aibuy.model;

import com.vode.aibuy.bean.Goods;
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

    public static void loadGoods(final LoadDataInteface<List<Goods>> loadDataInteface) {
        retrofit.getGoodsApi().enqueue(new Callback<List<Goods>>() {
            @Override
            public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
                loadDataInteface.onDataLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Goods>> call, Throwable t) {
                loadDataInteface.onDataLoadFailed(t);
            }
        });
    }

    public static void loadSearchGoods(final LoadDataInteface<List<Goods>> inteface ) {

        retrofit.getGoodsBySearchApi().enqueue(new Callback<List<Goods>>() {
            @Override
            public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
                inteface.onDataLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Goods>> call, Throwable t) {
                inteface.onDataLoadFailed(t);
            }
        });
    }
}
