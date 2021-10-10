package com.example.habittracker.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query





// import kotlinx.coroutines.Deferred

private const val BASE_URL = "http://192.168.1.153:8080/"

var gson = GsonBuilder()
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .client(getHttpClient())
    .build()

interface AuthorizeApiService {
    @POST("user/register")
    fun getAuthorization(@Body registrationForm: RegistrationForm): Call<Void>

    @GET("user/login/?email?password")
    fun loginUser(@Query("email") email: String, @Query("password") password: String): Call<String>
}



object AuthorizeApi {
    val retrofitService: AuthorizeApiService by lazy {
        retrofit.create(AuthorizeApiService::class.java)
    }
}

data class RegistrationForm(
    val emailOrNumber: String,
    val firstName: String,
    val secondName: String,
    val birthdayDate: String,
    val password: String
)

private fun getHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.apply {
        logging.level = HttpLoggingInterceptor.Level.BODY
    }
    val httpClient = OkHttpClient.Builder().addInterceptor(logging)

    return httpClient.build()
}

data class Token(
    val token: String
)