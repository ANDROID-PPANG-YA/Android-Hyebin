package com.sopt.android_hyebin.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.FragmentProfileBinding
import com.sopt.android_hyebin.presentation.home.FollowerFragment
import com.sopt.android_hyebin.presentation.home.RepositoryFragment
import com.sopt.anroid_hyebin.presentation.home.HomeViewModel
import com.sopt.anroid_hyebin.util.BaseFragment


class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initTransactionEvent()

    }

    private fun initViewModel() {
        binding.data = viewModel
    }

    private fun initTransactionEvent(){
        binding.tvFollower.isSelected = true

        childFragmentChange(R.id.fragment_container, FollowerFragment())
        binding.tvFollower.setOnClickListener {
            childFragmentChange(R.id.fragment_container, FollowerFragment())
            binding.tvFollower.isSelected = true
            binding.tvRepository.isSelected = false
        }

        binding.tvRepository.setOnClickListener {
            childFragmentChange(R.id.fragment_container,RepositoryFragment())
            binding.tvRepository.isSelected = true
            binding.tvFollower.isSelected = false

        }


    }


    private fun childFragmentChange(layoutRes:Int, fragment:Fragment){
        childFragmentManager.beginTransaction()
            .replace(layoutRes, fragment)
            .commit()
    }
}