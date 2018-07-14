/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view

import android.os.Bundle
import com.org.zm.shutterstockdemo.R
import com.org.zm.shutterstockdemo.view.base.BaseActivity
import com.org.zm.shutterstockdemo.view.images.SearchImagesFragment

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppNavigator.loadFragment(this, SearchImagesFragment.newInstance(), homeContentContainer.id, false)

    }
}
