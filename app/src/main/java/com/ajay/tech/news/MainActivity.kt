package com.ajay.tech.news

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajay.tech.news.di.module.ActivityComponent
import com.ajay.tech.news.di.module.DaggerActivityComponent
import com.ajay.tech.news.framework.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel>() {

    companion object {
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setUpView(savedInstanceState: Bundle?) {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    var recyclerView: RecyclerView? = null
    var adapter: PostAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)

        mainActivityViewModel.onCreate()
    }

    override fun setUpObservers() {
        super.setUpObservers()

        mainActivityViewModel.data.observe(this, Observer {
            it?.let {
                adapter = PostAdapter(it)
                recyclerView?.adapter = adapter
            }
        })
    }

    fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as NewsApplication).applicationComponent)
            .mainActivityModule(MainActivityModule(this))
            .build()

    fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
