package com.sopt.android_hyebin.presentation.sign

import android.content.Intent
import android.os.Bundle
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivitySignUpBinding
import com.sopt.android_hyebin.presentation.sign.SignInActivity
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.toast

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFinishBtn()

    }

    //회원가입 완료 버튼 이벤트
    private fun initFinishBtn() {
        binding.apply {
            tvFinish.setOnClickListener {
                if (etName.text.isNotEmpty() && etId.text.isNotEmpty() && etPw.text.isNotEmpty()) {
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
}