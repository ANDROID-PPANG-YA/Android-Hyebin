package com.sopt.android_hyebin.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivityDetailBinding
import com.sopt.android_hyebin.databinding.ActivitySignInBinding
import com.sopt.anroid_hyebin.util.BaseActivity

class DetailActivity :
    BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDetail()
    }

    private fun initDetail() {
        val name = intent.getStringExtra("userName")
        val introduce = intent.getStringExtra("userIntroduce")
        binding.tvName.text = name
        binding.tvIntroduction.text = introduce
    }
}
