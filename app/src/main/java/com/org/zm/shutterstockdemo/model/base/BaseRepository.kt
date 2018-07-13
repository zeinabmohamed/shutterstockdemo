/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

/**
 * Handle all data calls network or db
 *  @author Zeinab Abdelmawla
 */

abstract class BaseRepository {

    /**
     * @property singleObservable
     * @property fillerPredictor
     * @property consumer
     * @property observer
     * @param R the observable items
     */
    protected fun <R : BaseResponse> execute(singleObservable: Observable<R>,
                                             fillerPredictor: Predicate<R>?,
                                             consumer: Consumer<R>?,
                                             observer: Observer<R>) {

        var updatedObservable = singleObservable.subscribeOn(Schedulers.io())
        updatedObservable = updatedObservable.observeOn(AndroidSchedulers.mainThread())

        fillerPredictor?.let {
            updatedObservable = updatedObservable.filter(it)
        }
        consumer?.let {
            updatedObservable = updatedObservable.doOnNext(consumer)
        }
        updatedObservable.subscribe(observer)

    }

    protected fun <R :  BaseResponse, O> execute(singleObservable: Observable<R>,
                                                fillerPredictor: Predicate<R>?,
                                                mapper: Function<R, O>?,
                                                consumer: Consumer<R>?,
                                                observer: Observer<O>) {

        var updatedObservable = singleObservable.subscribeOn(Schedulers.io())
        updatedObservable = updatedObservable.observeOn(AndroidSchedulers.mainThread())

        fillerPredictor?.let {
            updatedObservable = updatedObservable.filter(it)
        }
        mapper.let {
            var mappedUpdatedObservable=  updatedObservable.map(it)
            consumer?.let { updatedObservable.doOnNext(consumer) }
             mappedUpdatedObservable.subscribe(observer)
        }

    }
}