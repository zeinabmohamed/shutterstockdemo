/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.org.zm.shutterstockdemo.model.base.AppErrorModel
import com.org.zm.shutterstockdemo.model.base.DataCallbackListener
import com.org.zm.shutterstockdemo.model.images.SearchImagesRepository
import com.org.zm.shutterstockdemo.model.images.dto.ImageInfUiModel
import com.org.zm.shutterstockdemo.view.images.SearchImagesViewListener

import com.org.zm.shutterstockdemo.viewmodel.base.BaseViewModel

class SearchImagesViewModel : BaseViewModel<SearchImagesViewListener>() {
    private lateinit var mSearchImagesRepository: SearchImagesRepository

    override fun initRepos() {
        mSearchImagesRepository = SearchImagesRepository()
    }

    fun searchImages(matchDay: Int) {
        view.showLoading()
        mSearchImagesRepository.searchImages("", 1, object :
                DataCallbackListener<LiveData<Array<ImageInfUiModel?>>> {
            override fun onSuccess(data: LiveData<Array<ImageInfUiModel?>>) {
                data.observe(view, Observer<Array<ImageInfUiModel?>> { data ->

                    view.showSearchImagesResult(data)
                    view.hideLoading()
                })
            }

            override fun onError(errorModel: AppErrorModel) {
                view.showError(errorModel)
            }
        })

    }


}