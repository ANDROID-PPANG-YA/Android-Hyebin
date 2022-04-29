package com.sopt.android_hyebin.presentation.profile

import androidx.lifecycle.ViewModel
import com.sopt.anroid_hyebin.data.HomeData

class ProfileViewModel : ViewModel() {

    val User = HomeData("이혜빈", "@hea_ven_00", "토킹포테이토", "안녕하세요 안드로이드파트 이혜빈입니다\n".repeat(100))

}