package com.ders.weather_json.service

import com.ders.weather_json.model.Model
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WeatherApi {
    private val baseUrl = "https://api.openweathermap.org/data/2.5/"
    private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build().create(IService::class.java)
    fun getData(city:String):Single<Model>{
        return retrofit.getweather(city)
    }
}
