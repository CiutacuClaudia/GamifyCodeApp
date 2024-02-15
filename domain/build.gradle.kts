plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()


android {
    namespace = "com.example.domain"
}

dependencies {

    implementation(Dependencies.coreKTX)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    firebase()
    junit()
    data()
    hilt()
}