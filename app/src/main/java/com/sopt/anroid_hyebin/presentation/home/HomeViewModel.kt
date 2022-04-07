package com.sopt.anroid_hyebin.presentation.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val name = "이혜빈"
    val age = "23"
    val mbti = "ESFJ"
    val introduction= "안녕하세요 안드로이드파트 이혜빈입니다\n".repeat(100)

}