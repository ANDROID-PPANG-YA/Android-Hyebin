package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import android.view.View
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.FollowerData
import com.sopt.android_hyebin.databinding.FragmentFollowerBinding
import com.sopt.android_hyebin.presentation.home.adapter.FollowerAdapter
import com.sopt.anroid_hyebin.util.BaseFragment

class FollowerFragment : BaseFragment<FragmentFollowerBinding>(R.layout.fragment_follower) {
    private lateinit var followerAdapter: FollowerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                FollowerData("이혜빈1", "안녕하세요"),
                FollowerData("이혜빈2", "안녕하세요"),
                FollowerData("이혜빈3", "안녕하세요"),
                FollowerData("이혜빈4", "안녕하세요")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
}