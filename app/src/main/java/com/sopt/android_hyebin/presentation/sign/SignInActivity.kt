package com.sopt.android_hyebin.presentation.sign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.request.RequestSignInData
import com.sopt.android_hyebin.databinding.ActivitySignInBinding
import com.sopt.android_hyebin.presentation.main.MainActivity
import com.sopt.android_hyebin.presentation.sign.viewmodel.SignViewModel
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.toast

class SignInActivity :
    BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private val signViewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLoginBtn()
        initSignUpBtn()
        setSignUpValue()


    }

    //로그인 버튼 이벤트
    private fun initLoginBtn() {
        binding.apply {
            tvLogin.setOnClickListener {
                if (etId.text.isNotEmpty() && etPw.text.isNotEmpty()) {
                    signIn()
                    signViewModel.signIn.observe(this@SignInActivity) {
                        if (it.success) {
                            toast(getString(R.string.sign_success))
                            val intent = Intent(this@SignInActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            toast(getString(R.string.sign_fail))
                        }
                    }
                } else {
                    toast(getString(R.string.sign_up_fail))
                }
            }
        }
    }

    //회원가입 버튼 이벤트
    private fun initSignUpBtn() {
        binding.apply {
            tvSignup.setOnClickListener {
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }

    //signup -> signin 일 시 data 받아오기
    private fun setSignUpValue() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val id = result.data?.getStringExtra("id")
                    val pw = result.data?.getStringExtra("pw")
                    binding.etId.setText(id)
                    binding.etPw.setText(pw)
                }
            }
    }

    private fun signIn() {
        signViewModel.requestSignIn.email = binding.etId.toString()
        signViewModel.requestSignIn.password = binding.etPw.toString()

        signViewModel.postSignIn(
            RequestSignInData(
                signViewModel.requestSignIn.email,
                signViewModel.requestSignIn.password
            )
        )
    }
}