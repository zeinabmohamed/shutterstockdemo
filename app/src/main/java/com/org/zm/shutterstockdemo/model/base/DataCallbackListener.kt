/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base

interface DataCallbackListener < T > {
     fun onSuccess(data: T)
     fun onError(errorModel: AppErrorModel)
}