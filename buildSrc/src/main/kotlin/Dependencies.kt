object Dependencies {
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val core = "androidx.core:core-ktx:${Version.androidX}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val splash = "androidx.core:core-splashscreen:${Version.splash}"
    }

    const val Material = "com.google.android.material:material:${Version.material}"

    object Junit {
        const val junit = "junit:junit:${Version.junit}"
        const val ext = "androidx.test.ext:junit:${Version.junitExt}"
    }
}