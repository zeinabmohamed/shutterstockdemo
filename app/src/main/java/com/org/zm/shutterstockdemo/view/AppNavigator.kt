/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view

import android.support.v4.app.FragmentActivity
import com.org.zm.shutterstockdemo.view.base.BaseFragment
import com.org.zm.shutterstockdemo.view.base.LoadDataView
import com.org.zm.shutterstockdemo.viewmodel.base.BaseViewModel


/**
 *  Handle all app Navigation
 * @author Zeinab Abdelmawla
 */

object AppNavigator {

    fun <T : LoadDataView, VM : BaseViewModel<T>> loadFragment(activity: FragmentActivity,
                                                               baseFragment: BaseFragment<T, VM>, containerId: Int, isStacked: Boolean) {

        if (!isStacked) {
            activity.supportFragmentManager
                    .beginTransaction().replace(containerId,
                            baseFragment).commit()
        } else {
            activity.supportFragmentManager.beginTransaction().replace(containerId,
                    baseFragment,baseFragment::class.java.name).addToBackStack(baseFragment::class.java.name).commit()
        }
    }
}
