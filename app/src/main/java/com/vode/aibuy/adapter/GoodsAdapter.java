package com.vode.aibuy.adapter;

import android.content.Context;

import com.vode.aibuy.R;
import com.vode.aibuy.bean.Goods;

import java.util.List;

/**
 * Created by cj on 2018/3/12.
 */

public class GoodsAdapter  extends CommonAdapter<Goods> {
    public GoodsAdapter(Context context, List<Goods> datas) {
        super(context, datas);
    }

    @Override
    public void convert(ViewHolder<Goods> holder, Goods item, int positon) {

    }

    @Override
    public int getDatasItemType(int position, Goods item) {
        return R.layout.goods_head;
    }

}
