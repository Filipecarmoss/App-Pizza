package br.com.mandapizza.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor: Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val originalUrl: HttpUrl = originalRequest.url

        val requestBuilder: Request.Builder = originalRequest.newBuilder().url(originalUrl)

        val request: Request = requestBuilder.build()

        return chain.proceed(request)
    }

}