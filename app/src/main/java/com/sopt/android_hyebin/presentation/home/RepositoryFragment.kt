package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.FollowerData
import com.sopt.android_hyebin.data.RepositoryData
import com.sopt.android_hyebin.databinding.FragmentRepositoryBinding
import com.sopt.android_hyebin.presentation.home.adapter.FollowerAdapter
import com.sopt.android_hyebin.presentation.home.adapter.RepositoryAdapter
import com.sopt.anroid_hyebin.util.BaseFragment

class RepositoryFragment : BaseFragment<FragmentRepositoryBinding>(R.layout.fragment_repository) {
    private lateinit var repositoryAdapter: RepositoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("11","11"),
                RepositoryData("11","11"),
                RepositoryData("11","11"),
                RepositoryData("11","11")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

}