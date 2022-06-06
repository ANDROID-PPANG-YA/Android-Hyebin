package com.sopt.android_hyebin.data.response

data class ResponseSignInData(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val email: String,
        val name: String
    )
}