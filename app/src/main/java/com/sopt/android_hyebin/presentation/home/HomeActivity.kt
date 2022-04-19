package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivityHomeBinding
import com.sopt.anroid_hyebin.presentation.home.HomeViewModel
import com.sopt.anroid_hyebin.util.BaseActivity

class HomeActivity :
    BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private var postion = FIRST_POSITION
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initTransactionEvent()
    }

    private fun initViewModel() {
        binding.data = viewModel
    }

    fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositstoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, followerFragment).commit()

        binding.tvFollower.setOnClickListener {
            //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, followerFragment).commit()
            val transaction = supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, followerFragment)
                addToBackStack(null)
            }

            transaction.commit();
        }

        binding.tvRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, repositstoryFragment)
                addToBackStack(null)
            }

            transaction.commit();
            //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, repositstoryFragment).commit()
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


    companion object {
        const val FIRST_POSITION = 1
    }

}
