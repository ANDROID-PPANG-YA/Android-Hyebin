package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivityHomeBinding
import com.sopt.anroid_hyebin.presentation.home.HomeViewModel
import com.sopt.anroid_hyebin.util.BaseActivity

class HomeActivity :
    BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        binding.data = viewModel
    }

}
