/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view.images

import android.os.Bundle
import android.view.View
import com.org.zm.shutterstockdemo.model.images.dto.ImageInfUiModel

import com.org.zm.shutterstockdemo.view.base.BaseFragment
import com.org.zm.shutterstockdemo.viewmodel.SearchImagesViewModel

class SearchImagesFragment : BaseFragment<SearchImagesViewListener, SearchImagesViewModel>(),SearchImagesViewListener {


    override fun getViewModelClass(): Class<SearchImagesViewModel> {
        return SearchImagesViewModel::class.java
    }

    companion object {

        fun newInstance(): SearchImagesFragment {
            return SearchImagesFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.searchImages(4)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun showSearchImagesResult(data: Array<ImageInfUiModel?>?) {
        println(data?.size)
    }
}
