package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.FragmentHomeBinding
import com.sopt.android_hyebin.presentation.profile.FollowerFragment
import com.sopt.android_hyebin.presentation.profile.adapter.FollowerAdapter
import com.sopt.anroid_hyebin.util.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var followerTabViewPagerAdapter: FollowTabViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initTab()
    }

    private fun initAdapter() {
        val fragmentList = listOf(FollowingFragment(), FollowFragment())
        followerTabViewPagerAdapter = FollowTabViewPagerAdapter(this)
        followerTabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = followerTabViewPagerAdapter

    }

    private fun initTab(){
        val tabLabel = listOf("팔로잉", "팔로워")
        TabLayoutMediator(binding.tabHome, binding.vpHome) {tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}