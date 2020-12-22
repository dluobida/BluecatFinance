/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.modules.assets.ui.fragment.AssetsFragment;
import com.dluobida.bluecat.finance.modules.income.adapter.QuickIncomeListAdapter;
import com.dluobida.bluecat.finance.modules.transfer.adapter.QuickTransferListAdapter;
import com.dluobida.bluecat.finance.modules.transfer.bean.TransferListData;
import com.dluobida.bluecat.finance.modules.transfer.contract.TransferContract;
import com.dluobida.bluecat.finance.modules.transfer.presenter.TransferPresenter;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TransferFragment extends BaseFragment<TransferPresenter> implements  TransferContract.View{
    private static final String TAG = AssetsFragment.class.getSimpleName();

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_transfer_list)
    RecyclerView rvTransferList;

    private QuickTransferListAdapter mAdapter;

    public static TransferFragment getInstance(){
        TransferFragment instance = new TransferFragment();
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
        List<TransferData> transferDataList = new ArrayList<>();
        mAdapter = new QuickTransferListAdapter(R.layout.item_transfer_list,transferDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvTransferList.setLayoutManager(layoutManager);
        rvTransferList.setHasFixedSize(true);
        //add head banner
//        LinearLayout mHeaderGroup = (LinearLayout) getLayoutInflater().inflate(R.layout.query_menu,null);
//        mAdapter.setHeaderView(mHeaderGroup);
        rvTransferList.setAdapter(mAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_transfer;
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();
    }

    @Override
    public void showTransferListData(TransferListData transferListData, boolean isRefresh) {
        if (mAdapter == null) {
            return;
        }
        if (isRefresh) {
            mAdapter.replaceData(transferListData.getDatas());
        } else {
            mAdapter.addData(transferListData.getDatas());
        }

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
}
