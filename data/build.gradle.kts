plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.data"
}

dependencies {
    retrofit()
    hilt()
    junit()
    firebase()
}