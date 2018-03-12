package com.vode.aibuy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.vode.aibuy.R;
import com.vode.aibuy.adapter.GoodsAdapter;
import com.vode.aibuy.bean.Goods;
import com.vode.aibuy.present.GoodsLcePresent;
import com.vode.aibuy.view.GoodsLceView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsFragment extends MvpLceFragment<SwipeRefreshLayout,List<Goods>,GoodsLceView,GoodsLcePresent> implements GoodsLceView,SwipeRefreshLayout.OnRefreshListener {


    public RecyclerView rec;
    public ArrayList<Goods> datas;
    public GoodsAdapter adapter;

    public GoodsFragment() {
        // Required empty public constructor
    }

    @Override
    public GoodsLcePresent createPresenter() {
        return new GoodsLcePresent();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        contentView.setOnRefreshListener(this);
        rec = view.findViewById(R.id.rec_goods);
        datas = new ArrayList<>();
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GoodsAdapter(getActivity(), datas);
        rec.setAdapter(adapter);
    }

    @Override
    public void setData(List<Goods> data) {
        datas.clear();
        if (data != null) {
            datas.addAll(data);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }


    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);

        adapter.showEmptyView();
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }
}
