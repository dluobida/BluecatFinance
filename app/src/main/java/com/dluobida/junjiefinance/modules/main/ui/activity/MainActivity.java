/*
 * project ：JunjieFinance
 * author : dluobida
 * class : MainActivity.java
 * package : com.dluobida.junjiefinance.modules.main.ui.activity.MainActivity
 * currentModifyTime : 2019-10-30 22:42:47
 * lastModifyTime : 2019-10-29 21:10:55
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.main.ui.activity;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.activity.BaseActivity;
import com.dluobida.junjiefinance.core.constant.Constants;
import com.dluobida.junjiefinance.modules.expand.ui.fragment.ExpandFragment;
import com.dluobida.junjiefinance.modules.main.contract.MainContract;
import com.dluobida.junjiefinance.modules.main.presenter.MainPresenter;

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
        }

    }

    private void initBottomNavigationView(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.tab_expand:
                    showFragment(Constants.TYPE_EXPAND);
                    break;
            }
            return true;
        });
    }
}
