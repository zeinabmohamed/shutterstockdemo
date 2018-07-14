/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.images

import com.org.zm.shutterstockdemo.model.images.dto.SearchImagesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface  ImagesApiServices{
    @GET("/v2/images/search?per_page=20&sort=popular&view=minimal ")
    fun searchImages(@Query("query") searchKeyword: String, @Query("page") pageNo: Int) : Observable<SearchImagesResponse>
}