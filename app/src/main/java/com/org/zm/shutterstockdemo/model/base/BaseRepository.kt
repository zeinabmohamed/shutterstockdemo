/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers


/**
 * Handle all data calls network or db
 *  @author Zeinab Abdelmawla
 */

abstract class BaseRepository {

    protected val TAG: String = BaseRepository::class.java.name


    /**
     * @property singleObservable
     * @property fillerPredictor
     * @property consumer
     * @property observer
     * @param R the observable items
     */

    protected open fun <R : BaseResponse, O> execute(singleObservable: Observable<R>,
                                                     fillerPredictor: Predicate<R>?,
                                                     mapper: Function<R, O>?,
                                                     doOnNextConsumer: Consumer<O>?,
                                                     onNextConsumer: Consumer<O>,
                                                     dataCallbackListener: DataCallbackListener<*>) {

        var updatedObservable = singleObservable.subscribeOn(Schedulers.io())
        updatedObservable = updatedObservable.observeOn(AndroidSchedulers.mainThread())

        fillerPredictor?.let {
            updatedObservable = updatedObservable.filter(it)
        }

        var mappedUpdatedObservable = updatedObservable.map(mapper)
        doOnNextConsumer?.let { mappedUpdatedObservable.doOnNext(doOnNextConsumer) }
        mappedUpdatedObservable.subscribe(onNextConsumer, Consumer { e ->

            Log.d(TAG, "onError : ${e.message}")

            dataCallbackListener.onError(ErrorManager.getErrorModel(e))
        }, Action {
            Log.d(TAG, "onComplete")
        }, Consumer { disposal ->
            Log.d(TAG, "onSubscribe")

        })
    }

}

