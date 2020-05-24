package com.ajay.tech.news.framework

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import com.ajay.tech.news.MainActivityModule
import com.ajay.tech.news.NewsApplication
import com.ajay.tech.news.di.module.ActivityComponent
import com.ajay.tech.news.di.module.DaggerActivityComponent
import com.ajay.tech.news.utils.Toaster
import javax.inject.Inject


/**
 * Created by Ajay Vyas on 20/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setUpObservers()
        setUpView(savedInstanceState)
    }

    protected open fun setUpObservers(){

    }

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    protected abstract fun provideLayoutId(): Int

    protected abstract fun setUpView(savedInstanceState: Bundle?)
}