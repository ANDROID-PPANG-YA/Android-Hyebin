package com.sopt.android_hyebin.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.api.ServiceCreator
import com.sopt.android_hyebin.data.request.RequestSignUpData
import com.sopt.android_hyebin.data.response.ResponseSignUpData
import com.sopt.android_hyebin.databinding.ActivitySignUpBinding
import com.sopt.android_hyebin.presentation.sign.SignInActivity
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val signViewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFinishBtn()

    }

    //회원가입 완료 버튼 이벤트
    private fun initFinishBtn() {
        binding.apply {
            tvFinish.setOnClickListener {
                if (etName.text.isNotEmpty() && etId.text.isNotEmpty() && etPw.text.isNotEmpty()) {

                    signUp()

                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    intent
                        .putExtra("id", etId.text.toString())
                        .putExtra("pw", etPw.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    toast(getString(R.string.sign_up_fail))
                }
            }
        }
    }

    private fun signUp() {
        signViewModel.requestSignUp.email = binding.etId.text.toString()
        signViewModel.requestSignUp.name = binding.etName.text.toString()
        signViewModel.requestSignUp.password = binding.etPw.text.toString()

        Log.d("test1", signViewModel.requestSignUp.email)
        Log.d("test2", signViewModel.requestSignUp.name)
        Log.d("test3", signViewModel.requestSignUp.password)

        signViewModel.postSignUp(
            RequestSignUpData(
                signViewModel.requestSignUp.email,
                signViewModel.requestSignUp.name,
                signViewModel.requestSignUp.password
            )
        )


//        CoroutineScope(Dispatchers.IO).launch {
//            runCatching { ServiceCreator.signService.postSignUp(requestS) }
//                .onSuccess {
//                    Log.d("서버통신", "성공")
//                    withContext(Dispatchers.Main){
//                        Toast.makeText(this@SignUpActivity, "회원가입 성공!", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                }
//                .onFailure {
//                    Log.d("서버통신", "실패")
//                }


    }

}
