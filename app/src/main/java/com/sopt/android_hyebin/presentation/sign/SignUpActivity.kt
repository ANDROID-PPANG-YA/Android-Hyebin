package com.sopt.android_hyebin.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.request.RequestSignUpData
import com.sopt.android_hyebin.databinding.ActivitySignUpBinding
import com.sopt.android_hyebin.presentation.sign.viewmodel.SignViewModel
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.toast

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
                    signViewModel.signUp.observe(this@SignUpActivity) {
                        if (it.success) {
                            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                            intent
                                .putExtra("id", etId.text.toString())
                                .putExtra("pw", etPw.text.toString())
                            setResult(RESULT_OK, intent)
                            finish()
                        } else {
                            toast("서버 통신 실패")
                        }
                    }
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

        signViewModel.postSignUp(
            RequestSignUpData(
                signViewModel.requestSignUp.email,
                signViewModel.requestSignUp.name,
                signViewModel.requestSignUp.password
            )
        )
    }
}
