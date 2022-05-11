package com.sopt.android_hyebin.presentation.profile

import android.os.Bundle
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivityDetailBinding
import com.sopt.anroid_hyebin.util.BaseActivity

class DetailActivity :
    BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDetail()
    }

    private fun initDetail() {
        val name = intent.getStringExtra("name")
        val introduce = intent.getStringExtra("introduction")
        binding.tvName.text = name
        binding.tvIntroduction.text = introduce
    }
}