/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.org.zm.shutterstockdemo.model.base.AppErrorModel
import com.org.zm.shutterstockdemo.viewmodel.base.BaseViewModel

/**
 * Base Fragment for common handling
 *  @author Zeinab Abdelmawla
 */

abstract class BaseFragment < T : LoadDataView, VM : BaseViewModel<T>> : Fragment(),LoadDataView {

    protected lateinit var mViewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(getViewModelClass())
        mViewModel.attachView( this as T)
    }

    abstract fun getViewModelClass(): Class<VM>

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showRetry(message: String) {

    }

    override fun hideRetry() {

    }

    /**
     * handle general error handling
     * override if need custom error handling
     */

    override fun showError(message: AppErrorModel) {

    }

    override fun context(): Context {
        return activity as Context
    }
}