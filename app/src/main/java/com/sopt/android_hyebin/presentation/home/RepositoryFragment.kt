package com.sopt.android_hyebin.presentation.home

import android.os.Bundle
import android.view.View
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.RepositoryData
import com.sopt.android_hyebin.databinding.FragmentRepositoryBinding
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
                RepositoryData("나도선배","릴리즈완료! 부많관"),
                RepositoryData("안드로이드30기","감성이들 조 최고!"),
                RepositoryData("플투","솝텀 프로젝트"),
                RepositoryData("inIT","졸업 프로젝트")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

}