package com.example.myapplication.ui.login

import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.md0055_udaykumar.taxidriver.model.Login.LoginRequest
import com.example.md0055_udaykumar.taxidriver.model.Login.LoginResponce
import com.example.myapplication.R
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.models.Login.UserResult
import com.example.myapplication.network.PostApi
import com.example.myapplication.utils.Validat
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel : BaseViewModel() {

    @Inject
    lateinit var loginApi: PostApi

    private lateinit var subscription: Disposable
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val goSignIn: MutableLiveData<Int> = MutableLiveData()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val loginResponce: MutableLiveData<LoginResponce> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadLogin() }

    val emailTxt: MutableLiveData<String> = MutableLiveData()
    val passwordTxt: MutableLiveData<String> = MutableLiveData()

    init {
//        loadLogin()
        emailTxt.value = "uday@test5.com"
        passwordTxt.value = "1234"
    }

    fun signInButtonClicked() {
//        text.set("Button clicked!")
//        Log.d("signInClick","signInClick");
        loadLogin()
    }

    fun signUpButtonClicked() {
        goSignIn.value = 1
    }

    private fun loadLogin() {

        if (emailTxt.value == null || emailTxt.value.toString().length == 0) {
            errorMessage.value = R.string.valid_email
            return
        }
        if (!Validat.isValidEmail(emailTxt.value.toString())) {
            errorMessage.value = R.string.valid_email
            return
        }

        if (passwordTxt.value.toString().length == 0) {
            errorMessage.value = R.string.valid_password
            return
        }

        Log.d("signInClick", "signInClick:- " + emailTxt.value.toString() + "  " + passwordTxt.value.toString());
        val request = LoginRequest(emailTxt.value.toString(), passwordTxt.value.toString(), "1")
        Log.d("request", "request:- " + request.toString());
//        val request = LoginRequest("uday@test5.com", "1234", "1")
        subscription = loginApi.getLoginPost("uday", "Admin@123", "23.0753108", "72.5261044", "false", "Driver", "355944094971660","d6DLe0IlmBo%3AAPA91bEGmKPqHeBkgx3f81DXq1B1kTcp0sQbNhohRyGRKx4JED6YKSmoSTAJ4qk9O5kcNMq0zbgjwST2pdroZN9lmwyemGyn-M7WcmlUopjsvuFpjhFFLM8Jm9D_diTAA2wNK1yE0Dqn")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { objectResult ->
                    onRetrievePostListSuccess(objectResult)
//                    Log.d("Result", Gson().toJson(objectResult))
                }, {
                    onRetrievePostListError()
                    Log.e("error", it.message)
                }

            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
        errorMessage.value = null
    }

    private fun onRetrievePostListSuccess(mLoginResponce: UserResult) {
        Log.d("UserResult", "UserResult:- " + mLoginResponce.toString() + "  ");
      /*  val success: String = mLoginResponce.success
        if (success.equals("true")) {
            loginResponce.value = mLoginResponce
        }*/
    }

    private fun onRetrievePostListError() {
        Log.d("onRetrievePostListError", "onRetrievePostListError:- " );
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}