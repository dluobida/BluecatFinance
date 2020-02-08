/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.modules.assets.adapter.AssetsAdapter;
import com.dluobida.bluecat.finance.modules.assets.contract.AssetsContract;
import com.dluobida.bluecat.finance.modules.assets.presenter.AssetsPresenter;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

public class AssetsFragment extends BaseFragment<AssetsPresenter> implements  AssetsContract.View{
    private static final String TAG = AssetsFragment.class.getSimpleName();

    @BindView(R.id.rv_assets_list)
    RecyclerView rvAssetsList;

    public static AssetsFragment getInstance(){
        AssetsFragment instance = new AssetsFragment();
        return instance;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        rvAssetsList.setLayoutManager(layoutManager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_assets;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        List<AccountData> datas = mPresenter.queryAllAccountData();
        LogUtils.i("assetsFragmentAccountData=" + datas.toString());
        AssetsAdapter adapter = new AssetsAdapter(datas);
        rvAssetsList.setAdapter(adapter);

    }
}
