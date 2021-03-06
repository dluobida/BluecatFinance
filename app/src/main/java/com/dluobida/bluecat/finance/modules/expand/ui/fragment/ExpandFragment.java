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

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.adapter.QuickExpandListAdapter;
import com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData;
import com.dluobida.bluecat.finance.modules.expand.contract.ExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.ExpandPresenter;
import com.dluobida.bluecat.finance.modules.expand.ui.activity.CreateExpandActivity;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.google.gson.Gson;
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
    private TextView tvTotalMoney;



    public static ExpandFragment getInstance(){
        ExpandFragment instance = new ExpandFragment();
        return instance;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.refreshLayout(false);
        mPresenter.getCurrentExpandMoney();

    }

    @Override
    protected void initView() {
        initRecyclerView();

    }

    private void initRecyclerView(){
        List<ExpandData> expandDataList = new ArrayList<>();
        mAdapter = new QuickExpandListAdapter(R.layout.item_expand_list,expandDataList);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                jumpToEdit(expandDataList.get(position));
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvExpandList.setLayoutManager(layoutManager);
        rvExpandList.setHasFixedSize(true);
        //add head banner
        LinearLayout mHeaderGroup = (LinearLayout) getLayoutInflater().inflate(R.layout.item_header_expand,null);
        tvTotalMoney = mHeaderGroup.findViewById(R.id.tv_total_expand);
        mAdapter.setHeaderView(mHeaderGroup);
        rvExpandList.setAdapter(mAdapter);
    }

    private void jumpToEdit(ExpandData expandData){
        //TODO 实体类转json
        Intent intent = new Intent(getActivity(), CreateExpandActivity.class);
        intent.putExtra("type","edit");
        intent.putExtra("data",new Gson().toJson(expandData));
        startActivity(intent);

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

    @Override
    public void showCurrentExpandMoney(String money) {
        tvTotalMoney.setText("当日总支出:    ￥" + money);
    }

    public void jumpToTheTop() {
        if (rvExpandList != null) {
            rvExpandList.smoothScrollToPosition(0);
        }
    }



}
