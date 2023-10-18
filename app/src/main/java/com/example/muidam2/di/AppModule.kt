package com.example.muidam2.di

import com.example.apicompose.repository.Repository
import com.example.apicompose.repository.RepositoryImplementation
import com.example.muidam2.remote.ApiDetails
import com.example.muidam2.remote.ApiRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    //OKHttp Loggers -Interceptors - ....
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }


    //Retrofit Builder
    //Retrofit -Builder
    @Provides
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .client(client)
        .build()

    //API class
    @Provides
    fun provideApiCall(retrofit: Retrofit): ApiRequest = retrofit.create(ApiRequest::class.java)
    //Repository

    @Provides
    fun provideRepository(api: ApiRequest): Repository = RepositoryImplementation(api)
    //Appi class - Service

    //Repository

}