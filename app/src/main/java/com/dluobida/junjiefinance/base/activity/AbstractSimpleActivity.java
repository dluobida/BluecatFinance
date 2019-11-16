/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AbstractSimpleActivity.java
 * package : com.dluobida.junjiefinance.base.activity.AbstractSimpleActivity
 * currentModifyTime : 2019-10-30 23:33:31
 * lastModifyTime : 2019-10-30 23:33:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        onViewCreated();
        initToolbar();
        initView();

    }

    /**
     * 获取当前activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void onViewCreated();

    protected abstract void initToolbar();
}
