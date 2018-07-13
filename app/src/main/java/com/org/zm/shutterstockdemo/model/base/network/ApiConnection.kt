/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * cloud connection util
 *  @author Zeinab Abdelmawla
 */
object ApiConnection {


    private val TAG = ApiConnection::class.java.name
    private lateinit var retrofit: Retrofit
    const val BASE_URL: String = "https://api.shutterstock.com/v2/"

    /*
     * @return retrofit object used to create the requests
     *
     */

    fun retrofit(base_url: String): Retrofit {
            retrofit = Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        return retrofit
    }


}
