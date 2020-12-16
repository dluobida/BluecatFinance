/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.adapter.QuickIncomeListAdapter;
import com.dluobida.bluecat.finance.modules.income.bean.IncomeListData;
import com.dluobida.bluecat.finance.modules.income.ui.fragment.IncomeFragment;
import com.dluobida.bluecat.finance.modules.income.contract.IncomeContract;
import com.dluobida.bluecat.finance.modules.income.presenter.IncomePresenter;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class IncomeFragment extends BaseFragment<IncomePresenter> implements  IncomeContract.View{
    private static final String TAG = IncomeFragment.class.getSimpleName();

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_income_list)
    RecyclerView rvIncomeList;

    private QuickIncomeListAdapter mAdapter;



    public static IncomeFragment getInstance(){
        IncomeFragment instance = new IncomeFragment();
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
        List<IncomeData> incomeDataList = new ArrayList<>();
        mAdapter = new QuickIncomeListAdapter(R.layout.item_income_list,incomeDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvIncomeList.setLayoutManager(layoutManager);
        rvIncomeList.setHasFixedSize(true);
        //add head banner
//        LinearLayout mHeaderGroup = (LinearLayout) getLayoutInflater().inflate(R.layout.query_menu,null);
//        mAdapter.setHeaderView(mHeaderGroup);
        rvIncomeList.setAdapter(mAdapter);

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
        return R.layout.fragment_income;
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();


    }

    @Override
    public void showIncomeListData(IncomeListData incomeListData, boolean isRefresh) {
        if (mAdapter == null) {
            return;
        }
        if (isRefresh) {
            mAdapter.replaceData(incomeListData.getDatas());
        } else {
            mAdapter.addData(incomeListData.getDatas());
        }
    }

    public void jumpToTheTop() {
        if (rvIncomeList != null) {
            rvIncomeList.smoothScrollToPosition(0);
        }
    }
}
