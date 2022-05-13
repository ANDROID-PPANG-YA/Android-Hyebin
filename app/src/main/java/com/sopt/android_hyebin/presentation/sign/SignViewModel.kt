package com.sopt.android_hyebin.presentation.sign

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.android_hyebin.data.api.ServiceCreator
import com.sopt.android_hyebin.data.request.RequestSignUpData
import com.sopt.android_hyebin.data.response.ResponseSignUpData
import kotlinx.coroutines.launch

class SignViewModel() : ViewModel() {

    var requestSignUp = RequestSignUpData("","","")
    //회원가입
    private val _signUp = MutableLiveData<ResponseSignUpData>()
    val signUp : LiveData<ResponseSignUpData>
        get() = _signUp

    //회원가입
    fun postSignUp(requestSignUpData: RequestSignUpData) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postSignUp(requestSignUpData) }
                .onSuccess {
                    _signUp.value = it
                    Log.d("SignUp", "서버 통신 성공")

                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("SignUp", "서버 통신 실패")
                }
        }
    }
}