

/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.viewmodel.base

import android.arch.lifecycle.ViewModel
import com.org.zm.shutterstockdemo.view.base.LoadDataView

abstract class BaseViewModel< V : LoadDataView> : ViewModel() {

     lateinit var view: V
    /**
     * initialize all needed  repos to update ui
     */
    abstract fun initRepos()

    init {
        initRepos()
    }

    fun attachView(view: V) {
        this.view = view
    }


}