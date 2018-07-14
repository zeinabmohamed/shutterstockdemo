/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base.network


import android.util.Base64
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient


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
                    .client(client)
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

        return retrofit
    }

    private val callsUpdateHeaderInterceptor: Interceptor = Interceptor { chain ->
        val credentials = "39ce2-d3d77-e0e4a-dc150-3455c-1c6f7" + ":" + "97ac9-fb808-eb65f-b05a4-e8a8e-27b65"
        // create Base64 encodet string
        val basic = "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)

        val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "$basic")
                .build()
         chain.proceed(newRequest)
    }
    var client = OkHttpClient.Builder().addInterceptor(callsUpdateHeaderInterceptor).build()

}
