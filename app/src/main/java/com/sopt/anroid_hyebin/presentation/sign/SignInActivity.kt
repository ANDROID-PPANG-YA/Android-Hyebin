package com.sopt.anroid_hyebin.presentation.sign

import android.content.Intent
import android.os.Bundle
import com.sopt.anroid_hyebin.R
import com.sopt.anroid_hyebin.databinding.ActivitySignInBinding
import com.sopt.anroid_hyebin.presentation.home.HomeActivity
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.toast

class SignInActivity :
    BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLoginBtn()
        initSignUpBtn()

    }

    //로그인 버튼 이벤트
    private fun initLoginBtn() {
        binding.apply {
            tvLogin.setOnClickListener {
                if(etId.text.isNotEmpty() && etPw.text.isNotEmpty()){
                    toast(getString(R.string.sign_success))
                    val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    toast(getString(R.string.sign_fail))
                }
            }
        }
    }

    //회원가입 버튼 이벤트
    private fun initSignUpBtn(){
        binding.apply {
            tvSignup.setOnClickListener {
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}