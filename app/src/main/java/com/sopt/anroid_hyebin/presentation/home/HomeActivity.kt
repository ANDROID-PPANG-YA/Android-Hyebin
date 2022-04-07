package com.sopt.anroid_hyebin.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.anroid_hyebin.R
import com.sopt.anroid_hyebin.databinding.ActivityHomeBinding
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
        binding.lifecycleOwner = this
    }

}
