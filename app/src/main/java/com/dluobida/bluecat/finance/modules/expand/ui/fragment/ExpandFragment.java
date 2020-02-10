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
import android.view.View;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.adapter.ExpandListAdapter;
import com.dluobida.bluecat.finance.modules.expand.contract.ExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.ExpandPresenter;
import com.dluobida.bluecat.finance.modules.expand.ui.activity.CreateExpandActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
public class ExpandFragment extends BaseFragment<ExpandPresenter> implements ExpandContract.View{

    private static final String TAG = ExpandFragment.class.getSimpleName();

    @BindView(R.id.rv_expand_list)
    RecyclerView rvExpandList;

    private List<ExpandData> expandDataList;


    public static ExpandFragment getInstance(){
        ExpandFragment instance = new ExpandFragment();
        return instance;
    }


    @Override
    public void onResume() {
        super.onResume();
        expandDataList = mPresenter.queryAllExpandData();
        ExpandListAdapter adapter = new ExpandListAdapter(expandDataList);
        rvExpandList.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvExpandList.setLayoutManager(layoutManager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expand;
    }

    @Override
    protected void initEventAndData() {

    }

}
