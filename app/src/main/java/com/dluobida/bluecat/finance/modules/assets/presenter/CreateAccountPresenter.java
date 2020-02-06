/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateAccountPresenter.java
 * package : com.dluobida.bluecat.finance.modules.assets.presenter.CreateAccountPresenter
 * currentModifyTime : 2020-02-06 15:07:07
 * lastModifyTime : 2020-02-06 15:07:07
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.modules.assets.contract.CreateAccountContract;

import javax.inject.Inject;

public class CreateAccountPresenter extends BasePresenter<CreateAccountContract.View> implements CreateAccountContract.Presenter {
    @Inject
    public CreateAccountPresenter(){

    }
}
