package com.example.co.taodetail;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.co.taodetail.MyGoodsDetailAdapter;
import com.example.co.taodetail.R;
import com.example.co.taodetail.TestBean;

import java.util.ArrayList;

//@Route(path = RouteUtils.HOME_ACTIVITY_HOMEDETAILMAIN)
public class HomeDetailMainActivity extends AppCompatActivity {

    RelativeLayout mFLayout;

    private TabLayout tabLayout;
    private Toolbar mToolbarTb;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private AppBarLayout mAppBarLayout;
    private TextView tvTitle;
    private ImageView ivBack;
    private ImageView ivShare;
    private String TAG = "HomeDetailMainActivityTest";
    private LinearLayout statusBarLayout;
    private LinearLayoutManager layoutManager;
    private boolean mYDy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_detail_main_activity);
        initView();
        initToolbar();
        initTablayout();
        initAppBarlayout();
        inRecyclview();
    }

    private void initView() {
        mToolbarTb = (Toolbar) findViewById(R.id.home_detail_toolbar);
        mFLayout = findViewById(R.id.home_detail_relayout);
        imageView = (ImageView) findViewById(R.id.home_detail_iv_tt);
        tabLayout = (TabLayout) findViewById(R.id.home_detail_tab);
        recyclerView = (RecyclerView) findViewById(R.id.home_detail_recyclerview);
        mAppBarLayout = findViewById(R.id.home_detail_appbar);
        statusBarLayout = (LinearLayout) findViewById(R.id.home_status_bar_bottom);
        statusBarLayout.setBackgroundColor(Color.argb(255, 255, 255, 255));
        tvTitle = (TextView) findViewById(R.id.home_detail_tv_title);
        ivBack = (ImageView) findViewById(R.id.home_detail_iv_back);
       // ivBack.setOnClickListener(this);
        ivShare = (ImageView) findViewById(R.id.home_detail_iv_share);
        //ivShare.setOnClickListener(this);
    }

    private void initAppBarlayout() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float percent = Float.valueOf(Math.abs(verticalOffset)) / Float.valueOf(appBarLayout.getTotalScrollRange());
                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();
                int dy = Math.abs(verticalOffset);
                if (dy <= toolbarHeight) {
                    float scale = (float) dy / toolbarHeight;
                    float alpha = scale * 255;
                    mToolbarTb.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    tvTitle.setTextColor(Color.argb((int) alpha, 0, 0, 0));
                    tabLayout.setTabTextColors(Color.argb((int) alpha, 0, 0, 0), Color.argb((int) alpha, 233, 150, 122));

                    //  Log.d(TAG, "onOffsetChanged:alpha" + alpha);
                }
//                ivBack.setAlpha(percent);
//                ivShare.setAlpha(percent);
                // Log.d(TAG, "onOffsetChanged:percent" + percent);/
                // extends AppCompatActivity {
//
//                @Override
//                protected void onCreate(Bundle savedInstanceState) {
//                    super.onCreate(savedInstanceState);
//                    setContentView(R.layout.activity_main);
//                }


            }
        });
    }

    private void initTablayout() {

        tabLayout.addTab(tabLayout.newTab().setText("商品"));
        tabLayout.addTab(tabLayout.newTab().setText("评价"));
        tabLayout.addTab(tabLayout.newTab().setText("详情"));
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("商品"));
        tabLayout.addTab(tabLayout.newTab().setText("评价"));
//        tabLayout.addTab(tabLayout.newTab().setText("详情"));
//        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();
                //mYDy 判断是上滑还是下滑true是手指上滑
                if (layoutManager != null && mYDy) {
                    layoutManager.scrollToPositionWithOffset(tabPosition, 0);
                    layoutManager.setStackFromEnd(true);
                    Log.d(TAG, "onTabSelected:tabPosition " + tabPosition);
                } else if (layoutManager != null && !mYDy) {
                    //这里是下滑的时候，滑动到tabPosition这个条目的底部
                    layoutManager.scrollToPositionWithOffset(tabPosition + 1, 5);
                    layoutManager.setStackFromEnd(false);
                }
                mYDy = true;
                mAppBarLayout.setExpanded(false);
//                layoutManager.scrollToPositionWithOffset(tabPosition, 0);
//                layoutManager.setStackFromEnd(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initToolbar() {
        mToolbarTb.setTitle("商品");
        mToolbarTb.getBackground().setAlpha(0);  //先设置透明
        setSupportActionBar(mToolbarTb);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);  //是否隐藏标题
            actionBar.setDisplayHomeAsUpEnabled(false);     //是否显示返回按钮
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
        }

    }


    private void inRecyclview() {
        ArrayList<TestBean> list = new ArrayList();
        TestBean testBeanzero = new TestBean();
        testBeanzero.setPrice(0);
        TestBean testBeanone = new TestBean();
        testBeanone.setPrice(1);
        TestBean testBeantwo = new TestBean();
        testBeantwo.setPrice(2);
        TestBean testBeanthree = new TestBean();
        testBeanthree.setPrice(3);
        TestBean testBeanfour = new TestBean();
        testBeanfour.setPrice(4);
        TestBean testBeanfive = new TestBean();
        testBeanfive.setPrice(5);
//        TestBean testBeansix = new TestBean();
//        testBeansix.setPrice(6);
//        TestBean testBeanseven = new TestBean();
//        testBeanseven.setPrice(7);
        list.add(testBeanzero);
        list.add(testBeanone);
        list.add(testBeantwo);
        list.add(testBeanthree);
        list.add(testBeanfour);
        list.add(testBeanfive);
//        list.add(testBeansix);
//        list.add(testBeanseven);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyGoodsDetailAdapter myGoodsDetailAdapter = new MyGoodsDetailAdapter(R.layout.home_detail_item, list);
        recyclerView.setAdapter(myGoodsDetailAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                int lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                Log.i(TAG, "onScrolled:firstVisibleItemPosition " + firstVisibleItemPosition);
                Log.i(TAG, "onScrolled:firstCompletelyVisibleItemPosition " + firstCompletelyVisibleItemPosition);
                Log.i(TAG, "onScrolled:lastCompletelyVisibleItemPosition " + lastCompletelyVisibleItemPosition);
                Log.i(TAG, "onScrolled:lastVisibleItemPosition " + lastVisibleItemPosition);

                if (firstVisibleItemPosition < 8 && dy > 0) {

                    mYDy = true;
                    //Log.i(TAG, "onScrolled:firstVisibleItemPosition " + firstVisibleItemPosition);
                } else if (dy < 0) {
                    mYDy = false;
                }
                tabLayout.getTabAt(firstVisibleItemPosition).select();

//                Log.i(TAG, "onScrolled:lastCompletelyVisibleItemPosition "+lastCompletelyVisibleItemPosition);
//                Log.i(TAG, "onScrolled:lastVisibleItemPosition "+lastVisibleItemPosition);
                //
            }
        });
//        recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
//            @Override
//            public boolean onFling(int velocityX, int velocityY) {
//                return false;
//            }
//        });


    }

}
