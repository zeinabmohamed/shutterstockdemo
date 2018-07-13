/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view.base

import android.arch.lifecycle.LifecycleOwner
import android.content.Context

/**
 * Interface representing a View that will use to load data.
 *  @author Zeinab Abdelmawla
 */
interface LoadDataView : LifecycleOwner {


    /**
     * Show a view with a progress bar indicating a loading process.
     */
    fun showLoading()

    /**
     * Hide a loading view.
     */
    fun hideLoading()

    /**
     * Show a retry view in case of an error when retrieving data.
     *
     * @param message
     */
    fun showRetry(message: String)

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    fun hideRetry()

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    fun showError(message: String)

    /**
     * Get a [Context].
     */
    fun context(): Context

}
