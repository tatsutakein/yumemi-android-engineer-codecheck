plugins {
    id("jp.co.yumemi.android.codecheck.android.library")
}

android {
    namespace = "jp.co.yumemi.android.codecheck.core.model"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
}