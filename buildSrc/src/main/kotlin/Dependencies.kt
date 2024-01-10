import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeUIJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val composeUIManifest = "androidx.compose.ui:ui-test-manifest"

    const val coreKTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    const val runtimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKTX}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val junit = "junit:junit:${Versions.junit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"

    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"

    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    const val firebaseCrashlyticsGradle =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
}

fun DependencyHandler.junit() {
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testJunit)
    androidTestImplementation(Dependencies.testEspresso)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeUIManifest)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(platform(Dependencies.composeBom))
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeUiTooling)
    androidTestImplementation(Dependencies.composeUIJunit4)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.data() {
    implementation(project(":data"))
}

fun DependencyHandler.domain() {
    implementation(project(":domain"))
}

fun DependencyHandler.analytics() {
    implementation(project(":analytics"))
}