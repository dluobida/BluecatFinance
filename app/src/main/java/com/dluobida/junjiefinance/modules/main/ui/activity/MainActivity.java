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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.activity.BaseActivity;
import com.dluobida.junjiefinance.modules.main.ui.contract.MainContract;
import com.dluobida.junjiefinance.modules.main.ui.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onViewCreated() {

    }
}
