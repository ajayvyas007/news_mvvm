package com.ajay.tech.news.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajay.tech.news.R
import com.ajay.tech.news.data.db.DatabaseService
import com.ajay.tech.news.utils.NetworkHelper
import com.bumptech.glide.load.engine.Resource
import io.reactivex.disposables.CompositeDisposable
import java.net.HttpURLConnection
import javax.inject.Inject


/**
 * Created by Ajay Vyas on 20/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
abstract class BaseViewModel( val networkHelper: NetworkHelper): ViewModel() {


    val messageStringId: MutableLiveData<com.ajay.tech.news.utils.common.Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<com.ajay.tech.news.utils.common.Resource<String>> = MutableLiveData()

    override fun onCleared() {
       // compositeDisposable?.dispose()
        super.onCleared()
    }

    protected fun checkInternetConnectionWithMessage() : Boolean {
        if (networkHelper?.isNetworkConnected()!!) {
            return true
        } else {
            messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.network_connection_error))
            return false
        }
    }

    protected fun checkNetworkConnection():Boolean {
        networkHelper?.let {
            return networkHelper?.isNetworkConnected()!!
        }
        return false
    }

    protected fun handleNetworkError(throwable: Throwable?){
        /*throwable?.let {
            networkHelper?.let {
                networkHelper?.castToNetworkError(throwable).run {
                when(0*//*status*//*)
                {
                    -1 -> messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.network_default_error))

                    0 -> messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.server_connection_error))

                    HttpURLConnection.HTTP_UNAUTHORIZED -> messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.permission_denied))

                    HttpURLConnection.HTTP_INTERNAL_ERROR -> messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.network_internal_error))

                    HttpURLConnection.HTTP_UNAVAILABLE -> messageStringId.postValue(com.ajay.tech.news.utils.common.Resource.error(R.string.network_server_not_available))

                    else -> messageString.postValue(com.ajay.tech.news.utils.common.Resource.error(message))
                }
            }
            }
        }*/
    }

    abstract fun onCreate()

}