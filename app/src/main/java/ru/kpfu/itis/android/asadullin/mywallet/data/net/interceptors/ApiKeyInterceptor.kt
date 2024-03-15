package ru.kpfu.itis.android.asadullin.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import ru.kpfu.itis.android.asadullin.utils.Keys

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                Keys.TINKOFF_INVEST_API_KEY
            )
            .build()

        return chain.proceed(request)
    }
}