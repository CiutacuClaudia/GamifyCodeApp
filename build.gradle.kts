buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
        classpath(Dependencies.googleServices)
        classpath(Dependencies.firebaseCrashlyticsGradle)
        classpath(Dependencies.kotlinGradlePlugin)
    }
}