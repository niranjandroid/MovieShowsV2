object Retrofit {
    private const val version = "2.9.0"
    const val retrofitKotlinxSerializationJson = "1.0.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"

    const val kotlinSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitKotlinxSerializationJson"

    private const val okHttpVersion = "5.0.0-alpha.2"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}