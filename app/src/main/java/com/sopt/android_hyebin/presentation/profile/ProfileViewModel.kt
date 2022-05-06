package com.sopt.android_hyebin.presentation.profile

import androidx.lifecycle.ViewModel
import com.sopt.android_hyebin.R
import com.sopt.android_hyebin.data.FollowerData
import com.sopt.android_hyebin.data.HomeData

class ProfileViewModel : ViewModel() {

    val User = HomeData(R.drawable.ic_launcher_background,"이혜빈", "@hea_ven_00", "토킹포테이토")

    val Follower = FollowerData(0,"","")
}