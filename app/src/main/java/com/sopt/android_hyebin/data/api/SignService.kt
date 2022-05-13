package com.sopt.android_hyebin.data.api

import com.sopt.android_hyebin.data.request.RequestSignInData
import com.sopt.android_hyebin.data.request.RequestSignUpData
import com.sopt.android_hyebin.data.response.ResponseSignInData
import com.sopt.android_hyebin.data.response.ResponseSignUpData
import retrofit2.http.Body
import retrofit2.http.POST

interface SignService {
    @POST("auth/signup")
    suspend fun postSignUp(
        @Body body: RequestSignUpData
    ): ResponseSignUpData

    @POST("auth/signin")
    suspend fun postSignIn(
        @Body body: RequestSignInData
    ): ResponseSignInData
}