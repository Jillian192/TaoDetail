package com.example.co.taodetail;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by jieding on 2018/8/10 11:26
 */
public class MyGoodsDetailAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {


    public MyGoodsDetailAdapter(int layoutResId, @Nullable List<TestBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {

        helper.setText(R.id.tv_text,item.getPrice()+"");
//        List<String> tags = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            tags.add("标签" + i);
//        }
//        TagCloudView content_cloudView =(TagCloudView) helper.getView(R.id.mine_settlement_content_cloudView);
//        content_cloudView.setTags(tags);
//        helper.setImageResource(R.id.mine_order_iv_good, R.mipmap.mine_commodity_parameters_image);
    }
}
