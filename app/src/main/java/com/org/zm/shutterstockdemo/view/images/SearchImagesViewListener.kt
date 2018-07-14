/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.view.images

import com.org.zm.shutterstockdemo.model.images.dto.ImageInfUiModel
import com.org.zm.shutterstockdemo.view.base.LoadDataView

interface  SearchImagesViewListener : LoadDataView {
    fun showSearchImagesResult(data: Array<ImageInfUiModel?>?)
}