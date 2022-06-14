object Dependencies {
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val core = "androidx.core:core-ktx:${Version.androidX}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
        const val splash = "androidx.core:core-splashscreen:${Version.splash}"
    }

    object Coroutine {
        const val coroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
    }

    object Compose {
        const val animation = "androidx.compose.animation:animation:${Version.compose}"
        const val ui = "androidx.compose.ui:ui:${Version.compose}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
        const val preview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Version.compose}"
        const val material = "androidx.compose.material:material:${Version.compose}"
        const val iconCore = "androidx.compose.material:material-icons-core:${Version.compose}"
        const val iconExt = "androidx.compose.material:material-icons-extended:${Version.compose}"
        const val activity = "androidx.activity:activity-compose:${Version.composeAct}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.composeViewModel}"
        const val livedata = "androidx.compose.runtime:runtime-livedata:${Version.compose}"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
        const val themeAdapter = "com.google.android.material:compose-theme-adapter:1.1.11"
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:${Version.coil}"
    }

    object Google {
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object OkHttp {
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    }

    const val Material = "com.google.android.material:material:${Version.material}"

    object Junit {
        const val junit = "junit:junit:${Version.junit}"
        const val ext = "androidx.test.ext:junit:${Version.junitExt}"
    }

    object Koin {
        const val android = "io.insert-koin:koin-android:${Version.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Version.koin}"
    }

    object Lifecycle {
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }
}
