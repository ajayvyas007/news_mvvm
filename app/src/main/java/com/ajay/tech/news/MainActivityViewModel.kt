package com.ajay.tech.news

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ajay.tech.news.data.remote.repos.PostRepo
import com.ajay.tech.news.data.remote.response.Post
import com.ajay.tech.news.framework.BaseViewModel
import com.ajay.tech.news.log.Logger
import com.ajay.tech.news.utils.NetworkHelper
import com.ajay.tech.news.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
class MainActivityViewModel(schedulerProvider: SchedulerProvider, networkHelper: NetworkHelper, private val postRepo: PostRepo): BaseViewModel(networkHelper) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    public val data :MutableLiveData<List<Post>> = MutableLiveData()

    companion object{
        const val TAG = "MainActivityViewModel"
    }

    init {
        if (networkHelper.isNetworkConnected()){
            val api = postRepo.fetchPostListSet1()

            compositeDisposable.add(api.subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        data.postValue(it)
                    },{
                        handleNetworkError(it)
                        data.postValue(null)
                    }
                ))
        }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    override fun onCreate() {

    }

    fun getDataFromServer(){

    }
}