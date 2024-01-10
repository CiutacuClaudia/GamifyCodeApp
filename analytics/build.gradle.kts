plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.analytics"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(Dependencies.coreKTX)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.firebaseAnalytics)
    implementation(Dependencies.firebaseCrashlytics)
    hilt()
    junit()
}