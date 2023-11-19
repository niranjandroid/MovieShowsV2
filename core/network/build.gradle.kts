plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.niranjan.network"
    compileSdk = ProjectConfig.targetSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

}

secrets {
    defaultPropertiesFileName = "secrets.properties"
}

dependencies {

    implementation(Retrofit.retrofit)
    implementation(Retrofit.moshiConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Coroutines.androidCoroutines)

    implementation(DaggerHilt.hiltAndroid)
    ksp(DaggerHilt.hiltCompiler)
    ksp(DaggerHilt.hiltExtCompiler)

    testImplementation(Testing.junit4)
}
