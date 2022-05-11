package com.sopt.android_hyebin.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.FollowerData
import com.sopt.android_hyebin.databinding.FragmentFollowerBinding
import com.sopt.android_hyebin.presentation.profile.adapter.FollowerAdapter
import com.sopt.android_hyebin.util.ItemDecoration
import com.sopt.anroid_hyebin.util.BaseFragment

class FollowerFragment : BaseFragment<FragmentFollowerBinding>(R.layout.fragment_follower) {
    private lateinit var followerAdapter: FollowerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        recyclerViewDecoration()
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData(R.drawable.ic_launcher_background, "이혜빈1", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈2", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈3", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈4", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈5", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈6", "안녕하세요"),
                FollowerData(R.drawable.ic_launcher_background,"이혜빈7", "안녕하세요")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }


    private fun recyclerViewDecoration() {
        val spaceDecoration = ItemDecoration(16)
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.rvFollower.context,
                LinearLayoutManager(requireContext()).orientation
            )
        binding.rvFollower.addItemDecoration(dividerItemDecoration)
        binding.rvFollower.addItemDecoration(spaceDecoration)
    }
}