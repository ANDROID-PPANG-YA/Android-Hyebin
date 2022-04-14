object Apps {
    const val compileSdk = 31
    const val minSdk = 24
    const val targetSdk = 31
    var versionCode = 4
    var versionName = "1.1.2"
    const val pacakageName = "com.sopt.anroid_hyebin"
}
object Versions {
    const val kotlin_version = "1.5.21"
    const val core_ktx_version = "1.3.2"
    const val appcompat_version = "1.2.0"
    const val material_design_version = "1.3.0"
    const val constraint_layout_version = "2.0.4"
    const val lifecycle_ktx_version = "2.4.0-alpha02"
    const val activity_ktx = "1.2.1"
    const val fragment_ktx = "1.3.1"
    const val security_version = "1.0.0"
    const val biometric_version = "1.1.0"
    const val ktlint_version = "10.0.0"
    const val glide_version = "4.12.0"
    const val retrofit_version = "2.9.0"
    const val junit_version = "4.13.2"
    const val espresso_version = "3.3.0"
    const val android_test_version = "1.1.2"
    const val jvm_version = "1.8"
}



object KotlinDependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
}

object AndroidXDependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    const val viewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_ktx_version}"
    const val activityKtx =
        "androidx.activity:activity-ktx:${Versions.activity_ktx}"
    const val fragmentKtx =
        "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    const val security = "androidx.security:security-crypto:${Versions.security_version}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_ktx_version}"

}

object MaterialDesignDependencies {
    const val materialDesign =
        "com.google.android.material:material:${Versions.material_design_version}"
}


object ThirdPartyDependencies {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
}


object TestDependencies {
    const val jUnit = "junit:junit:${Versions.junit_version}"
    const val androidTest = "androidx.test.ext:junit:${Versions.android_test_version}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_version}"
}