package com.sopt.android_hyebin.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.ActivityMainBinding
import com.sopt.android_hyebin.databinding.FragmentProfileBinding
import com.sopt.android_hyebin.presentation.camera.CameraFragment
import com.sopt.android_hyebin.presentation.home.FollowerFragment
import com.sopt.android_hyebin.presentation.home.HomeFragment
import com.sopt.android_hyebin.presentation.home.RepositoryFragment
import com.sopt.android_hyebin.presentation.profile.ProfileFragment
import com.sopt.anroid_hyebin.presentation.home.HomeViewModel
import com.sopt.anroid_hyebin.util.BaseActivity
import com.sopt.anroid_hyebin.util.BaseFragment

class MainActivity :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        mainViewPagerAdapter = MainViewPagerAdapter(this)
        mainViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpMain.adapter = mainViewPagerAdapter
    }


    private fun initBottomNavi() {
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.bnvMain.menu.getItem(position).isChecked = true
            }
        })

        binding.bnvMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_profile -> {
                    binding.vpMain.currentItem= FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpMain.currentItem= SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpMain.currentItem= THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object{
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }


}
