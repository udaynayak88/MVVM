package com.example.myapplication.base

import android.arch.lifecycle.ViewModel
import com.example.myapplication.ui.login.LoginViewModel
import com.example.myapplication.injection.component.DaggerViewModelInjector
import com.example.myapplication.injection.component.ViewModelInjector
import com.example.myapplication.injection.module.NetworkModule
import com.example.myapplication.ui.post.PostListViewModel


abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {

//            Dagger
            is LoginViewModel -> injector.inject(this)
            is PostListViewModel -> injector.inject(this)
        }
    }
}