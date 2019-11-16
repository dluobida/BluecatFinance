/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AbstractSimpleFragment.java
 * package : com.dluobida.junjiefinance.base.fragment.AbstractSimpleFragment
 * currentModifyTime : 2019-11-05 22:57:33
 * lastModifyTime : 2019-11-05 22:57:33
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

public abstract class AbstractSimpleFragment extends SupportFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        initView();
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    /**
     * 有些初始化必须在onCreateView中，例如setAdapter
     * 否则会弹出 No adapter attached; skipping layout
     */
    protected abstract void initView();

    /**
     * 获取当前fragementd的UI布局
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}
