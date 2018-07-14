/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.images

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.org.zm.shutterstockdemo.model.base.BaseRepository
import com.org.zm.shutterstockdemo.model.base.DataCallbackListener
import com.org.zm.shutterstockdemo.model.base.ErrorManager
import com.org.zm.shutterstockdemo.model.base.network.ApiConnection
import com.org.zm.shutterstockdemo.model.images.dto.ImageInfUiModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function

class SearchImagesRepository : BaseRepository() {

    fun searchImages(searchKeyword: String, pageNo: Int, dataCallbackListener: DataCallbackListener<LiveData<Array<ImageInfUiModel?>>>) {
        // get data from cloud
        execute(ApiConnection.retrofit(ApiConnection.BASE_URL)
                .create(ImagesApiServices::class.java).searchImages(searchKeyword, pageNo),
                null,
                Function { searchImagesResponse ->
                    var imagesInfo = arrayOfNulls<ImageInfUiModel>(searchImagesResponse.data?.size!!)
                    searchImagesResponse.data.forEachIndexed { index, dataItem ->
                        var imageInfo = ImageInfUiModel(dataItem.id, dataItem.description, dataItem.assets.preview.url)
                        imagesInfo[index] = imageInfo
                    }
                    imagesInfo
                },
                null,
                Consumer<Array<ImageInfUiModel?>> { imagesItems ->
                    Log.d(TAG, "onNext : ${imagesItems?.size}")
                    var responseMutableLiveData: MutableLiveData<Array<ImageInfUiModel?>> = MutableLiveData()
                    dataCallbackListener.onSuccess(responseMutableLiveData)
                    // publish data to ui
                    responseMutableLiveData.value = imagesItems
                }, dataCallbackListener)
    }


}