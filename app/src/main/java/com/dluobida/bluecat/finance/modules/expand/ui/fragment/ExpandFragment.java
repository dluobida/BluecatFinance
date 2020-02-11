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
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.adapter.QuickExpandListAdapter;
import com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData;
import com.dluobida.bluecat.finance.modules.expand.contract.ExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.ExpandPresenter;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zxl.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
public class ExpandFragment extends BaseFragment<ExpandPresenter> implements ExpandContract.View{

    private static final String TAG = ExpandFragment.class.getSimpleName();

    private String headers[] = {"时间", "分类", "账户"};
    private int[] types = new int[]{DropDownMenu.TYPE_LIST_SIMPLE, DropDownMenu.TYPE_LIST_SIMPLE, DropDownMenu.TYPE_LIST_SIMPLE};
    private String time[] = {"不限(时间)", "年", "季", "月", "周", "天", "时"};
    private String classify[] = {"不限(分类)", "一级分类", "二级分类"};
    private String accounts[] = {"不限(账户)", "招商信用卡"};

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_expand_list)
    RecyclerView rvExpandList;

    private QuickExpandListAdapter mAdapter;

    DropDownMenu mDropDownMenu;


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
        LinearLayout mHeaderGroup = (LinearLayout) getLayoutInflater().inflate(R.layout.header_expand, null);
        mDropDownMenu = mHeaderGroup.findViewById(R.id.drop_down_menu);

        mHeaderGroup.removeView(mDropDownMenu);
        mAdapter.setHeaderView(mDropDownMenu);
        rvExpandList.setAdapter(mAdapter);
        initHeaderView();

    }

    private void initHeaderView() {
//        View contentView = getLayoutInflater().inflate(R.layout.contentview, null);
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), initViewData(),new View(getContext()));
        //该监听回调只监听默认类型，如果是自定义view请自行设置，参照demo
        mDropDownMenu.addMenuSelectListener(new DropDownMenu.OnDefultMenuSelectListener() {
            @Override
            public void onSelectDefaultMenu(int index, int pos, String clickstr) {
                //index:点击的tab索引，pos：单项菜单中点击的位置索引，clickstr：点击位置的字符串
                ToastUtils.showToast(_mActivity,clickstr);
            }
        });
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


    /**
     * 设置类型和数据源：
     * DropDownMenu.KEY对应类型（DropDownMenu中的常量，参考上述核心源码）
     * DropDownMenu.VALUE对应数据源：key不是TYPE_CUSTOM则传递string[],key是TYPE_CUSTOM类型则传递对应view
     */
    private List<HashMap<String, Object>> initViewData() {
        List<HashMap<String, Object>> viewDatas = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < headers.length; i++) {
            map = new HashMap<String, Object>();
            map.put(DropDownMenu.KEY, types[i]);
            switch (i) {
                case 0:
                    map.put(DropDownMenu.VALUE, time);
                    break;
                case 1:
                    map.put(DropDownMenu.VALUE, classify);
                    break;
                case 2:
                    map.put(DropDownMenu.VALUE, accounts);
                    break;
                default:
                    break;
            }
            viewDatas.add(map);
        }
        return viewDatas;
    }

}
