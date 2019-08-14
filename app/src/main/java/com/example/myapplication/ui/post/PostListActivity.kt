package com.example.myapplication.ui.post

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityListPostBinding
import com.example.myapplication.databinding.ActivityListPostBindingImpl
import com.example.myapplication.injection.ViewModelFactory

class PostListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityListPostBinding
    private lateinit var viewModel: PostListViewModel

    // ...
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_post)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)

        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}