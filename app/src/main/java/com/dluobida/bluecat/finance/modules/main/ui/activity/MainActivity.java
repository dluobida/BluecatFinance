/*
 * project ：JunjieFinance
 * author : dluobida
 * class : MainActivity.java
 * package : com.dluobida.junjiefinance.modules.main.ui.activity.MainActivity
 * currentModifyTime : 2019-10-30 22:42:47
 * lastModifyTime : 2019-10-29 21:10:55
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.main.ui.activity;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.activity.BaseActivity;
import com.dluobida.bluecat.finance.core.constant.Constants;
import com.dluobida.bluecat.finance.modules.assets.ui.fragment.AssetsFragment;
import com.dluobida.bluecat.finance.modules.chart.ui.fragment.ChartFragment;
import com.dluobida.bluecat.finance.modules.expand.ui.fragment.ExpandFragment;
import com.dluobida.bluecat.finance.modules.income.ui.fragment.IncomeFragment;
import com.dluobida.bluecat.finance.modules.main.contract.MainContract;
import com.dluobida.bluecat.finance.modules.main.presenter.MainPresenter;
import com.dluobida.bluecat.finance.modules.transfer.ui.fragment.TransferFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameGroup;

    //fragments
    private ExpandFragment mExpandFragment;
    private IncomeFragment mIncomeFragment;
    private TransferFragment mTransferFragment;
    private AssetsFragment mAssetsFragment;
    private ChartFragment mChartFragment;

    private int mCurrentFgIndex = 0;
    private int mLastFgIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        showFragment(mCurrentFgIndex);
        initBottomNavigationView();

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("支出");
        }

    }

    private void showFragment(int index) {
        mCurrentFgIndex = index;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        mLastFgIndex = index;
        switch (index){
            case Constants.TYPE_EXPAND:
                mTitle.setText("支出");
                if(mExpandFragment == null){
                    mExpandFragment = ExpandFragment.getInstance();
                    transaction.add(R.id.fragment_group,mExpandFragment);
                }
                transaction.show(mExpandFragment);
                break;
            case Constants.TYPE_INCOME:
                mTitle.setText("收入");
                if(mIncomeFragment == null){
                    mIncomeFragment = IncomeFragment.getInstance();
                    transaction.add(R.id.fragment_group,mIncomeFragment);
                }
                transaction.show(mIncomeFragment);
                break;
            case Constants.TYPE_TRANSFER:
                mTitle.setText("转账");
                if(mTransferFragment == null){
                    mTransferFragment = TransferFragment.getInstance();
                    transaction.add(R.id.fragment_group,mTransferFragment);
                }
                transaction.show(mTransferFragment);
                break;
            case Constants.TYPE_ASSETS:
                mTitle.setText("资产");
                if(mAssetsFragment == null){
                    mAssetsFragment = AssetsFragment.getInstance();
                    transaction.add(R.id.fragment_group,mAssetsFragment);
                }
                transaction.show(mAssetsFragment);
                break;
            case Constants.TYPE_CHART:
                mTitle.setText("图表");
                if(mChartFragment == null){
                    mChartFragment = ChartFragment.getInstance();
                    transaction.add(R.id.fragment_group,mChartFragment);
                }
                transaction.show(mChartFragment);
                break;
        }
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        switch (mLastFgIndex) {
            case Constants.TYPE_EXPAND:
                if (mExpandFragment != null) {
                    transaction.hide(mExpandFragment);
                }
                break;
            case Constants.TYPE_INCOME:
                if (mIncomeFragment != null) {
                    transaction.hide(mIncomeFragment);
                }
                break;
            case Constants.TYPE_TRANSFER:
                if (mTransferFragment != null) {
                    transaction.hide(mTransferFragment);
                }
                break;
            case Constants.TYPE_ASSETS:
                if (mAssetsFragment != null) {
                    transaction.hide(mAssetsFragment);
                }
                break;
            case Constants.TYPE_CHART:
                if (mChartFragment != null) {
                    transaction.hide(mChartFragment);
                }
                break;
        }

    }

    private void initBottomNavigationView(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.tab_expand:
                    showFragment(Constants.TYPE_EXPAND);
                    break;
                case R.id.tab_income:
                    showFragment(Constants.TYPE_INCOME);
                    break;
                case R.id.tab_transfer:
                    showFragment(Constants.TYPE_TRANSFER);
                    break;
                case R.id.tab_assets:
                    showFragment(Constants.TYPE_ASSETS);
                    break;
                case R.id.tab_chart:
                    showFragment(Constants.TYPE_CHART);
                    break;
            }
            return true;
        });
    }
}