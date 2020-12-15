/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandFragment.java
 * package : com.dluobida.junjiefinance.modules.expand.ui.fragment.ExpandFragment
 * currentModifyTime : 2019-11-16 23:10:04
 * lastModifyTime : 2019-11-16 23:10:03
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.adapter.QuickExpandListAdapter;
import com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData;
import com.dluobida.bluecat.finance.modules.expand.contract.ExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.ExpandPresenter;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
public class ExpandFragment extends BaseFragment<ExpandPresenter> implements ExpandContract.View{

    private static final String TAG = ExpandFragment.class.getSimpleName();

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_expand_list)
    RecyclerView rvExpandList;

    private QuickExpandListAdapter mAdapter;



    public static ExpandFragment getInstance(){
        ExpandFragment instance = new ExpandFragment();
        return instance;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.refreshLayout(false);

    }

    @Override
    protected void initView() {
        initRecyclerView();

    }

    private void initRecyclerView(){
        List<ExpandData> expandDataList = new ArrayList<>();
        mAdapter = new QuickExpandListAdapter(R.layout.item_expand_list,expandDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvExpandList.setLayoutManager(layoutManager);
        rvExpandList.setHasFixedSize(true);
        //add head banner
//        LinearLayout mHeaderGroup = (LinearLayout) getLayoutInflater().inflate(R.layout.query_menu,null);
//        mAdapter.setHeaderView(mHeaderGroup);
        rvExpandList.setAdapter(mAdapter);

    }


    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            LogUtils.i("onRefresh called");
            mPresenter.refreshLayout(false);
            refreshLayout.finishRefresh();
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            LogUtils.i("onLoadMore called");
            mPresenter.loadMore();
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expand;
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();


    }

    @Override
    public void showExpandListData(ExpandListData expandListData, boolean isRefresh) {
        if (mAdapter == null) {
            return;
        }
        if (isRefresh) {
            mAdapter.replaceData(expandListData.getDatas());
        } else {
            mAdapter.addData(expandListData.getDatas());
        }
    }

    public void jumpToTheTop() {
        if (rvExpandList != null) {
            rvExpandList.smoothScrollToPosition(0);
        }
    }



}
