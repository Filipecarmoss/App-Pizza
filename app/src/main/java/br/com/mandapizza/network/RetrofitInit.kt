package br.com.mandapizza.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

//COMPONENTES

//OBJETOS
private val gsonConverter: GsonConverterFactory = GsonConverterFactory.create()

//VARIAVEIS COMUNS


class RetrofitInit(url: String) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(OkHttpClient.Builder().apply {
            addInterceptor(ApiKeyInterceptor())
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
        }.build())
        .addConverterFactory(gsonConverter)
        .build()

    fun <T : Any> create(clazz: KClass<T>): T = retrofit.create(clazz.java)

}