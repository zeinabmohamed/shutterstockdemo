/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object ErrorManager {
    private const val BUSINESS_ERROR: Int = -1000

    private const val TIME_OUT: Int = -1001
    private const val SYSTEM_ERROR: Int = -1002
    private const val UNKOWN_ERROR: Int = -1003

    fun getErrorModel(e: Throwable): AppErrorModel {
        return when (e) {
            is HttpException -> {
                val responseBody = e.response().errorBody()

                AppErrorModel(ErrorManager.BUSINESS_ERROR, getErrorMessage(responseBody))
            }
            is SocketTimeoutException -> AppErrorModel(ErrorManager.TIME_OUT, e.message!!)
            is IOException -> AppErrorModel(ErrorManager.SYSTEM_ERROR, e.message!!)
            else -> AppErrorModel(ErrorManager.UNKOWN_ERROR, e.message!!)
        }
    }


    /**
     * get response error bode in case of business error
     */
    private fun getErrorMessage(responseBody: ResponseBody?): String {
        return try {
            val jsonObject = JSONObject(responseBody?.string())
            jsonObject.getString("message")
        } catch (e: Exception) {
            e.message!!
        }
    }
}