package com.sopt.android_hyebin.presentation.camera

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.databinding.FragmentCameraBinding
import com.sopt.anroid_hyebin.util.BaseFragment
import android.Manifest

class CameraFragment : BaseFragment<FragmentCameraBinding>(R.layout.fragment_camera) {


    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                selectImage()
            }
        }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            Glide.with(requireContext()).load(uri).into(binding.ivCamera)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aboutPermission()

    }


    private fun aboutPermission() {
        binding.tvAdd.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                selectImage()
            } else if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }


    private fun selectImage() {
        getContent.launch("image/*")
    }
}
