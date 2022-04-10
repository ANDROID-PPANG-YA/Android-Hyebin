package com.sopt.anroid_hyebin.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.anroid_hyebin.data.HomeData

class HomeViewModel : ViewModel() {

    val homeData = HomeData("이혜빈", "23", "ESFJ", "안녕하세요 안드로이드파트 이혜빈입니다\n".repeat(100))

}