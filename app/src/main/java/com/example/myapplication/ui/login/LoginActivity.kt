package com.example.myapplication.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.utils.ACCESS_TOKEN
import com.example.myapplication.utils.TinyDB

class LoginActivity : AppCompatActivity() {

    private var errorSnackbar: Snackbar? = null
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    lateinit var mTinyDB: TinyDB;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        getSupportActionBar()?.hide();

        mTinyDB = TinyDB(this)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        loginViewModel.goSignIn.observe(this, Observer { errorMessage ->
            if (errorMessage != null) goToSignIn(1) else goToSignIn(0)
        })

        loginViewModel.loginResponce.observe(this, Observer { loginResponce ->

            mTinyDB.putString(ACCESS_TOKEN, loginResponce!!.payload.accessToken);
//            loginResponce!!.payload.driver
           /* val intent = Intent(this@LoginActivity, HomeActivity::class.java);
            startActivity(intent);
            finish()*/
        })

        binding.viewModel = loginViewModel

    }

    private fun goToSignIn(next: Int) {
        if (next == 1) {
            /*val intent = Intent(this@LoginActivity, SignUpActivity::class.java);
            startActivity(intent);*/
        }
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
//        errorSnackbar?.setAction(R.string.retry, loginViewModel.errorClickListener)
        errorSnackbar?.setAction(R.string.ok, {
            // Hide the snack bar
            hideError()
        })
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }

}
