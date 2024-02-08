plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mecheka.rickmorty.main"
    compileSdk = Config.targetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":common:resource"))
    implementation(project(":domain"))

    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Material)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.navFragment)
    implementation(Dependencies.AndroidX.navUi)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.animation)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.livedata)
    debugImplementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.themeAdapter)
    implementation(Dependencies.Coil.compose)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.compose)
    implementation(Dependencies.AndroidX.splash)

    debugImplementation("androidx.customview:customview:1.2.0-alpha01")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0-beta02")
}
