import org.gradle.api.JavaVersion

object ProjectConfig {

    const val appId = "com.example.mobilelearningapp"
    const val minSdk = 24
    const val compileSdk = 34
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    val javaVersion = JavaVersion.VERSION_18
    const val jvmTarget = "18"
}