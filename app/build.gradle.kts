plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = Config.targetSdk

    defaultConfig {
        namespace = "com.mecheka.rickmorty"
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":common:resource"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":features:main"))
    implementation(project(":features:splash"))

    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Material)
    implementation(Dependencies.AndroidX.constraintLayout)
    testImplementation(Dependencies.Junit.junit)
    androidTestImplementation(Dependencies.Junit.ext)
    androidTestImplementation(Dependencies.AndroidX.espresso)
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableExperimentalClasspathAggregation = true
}