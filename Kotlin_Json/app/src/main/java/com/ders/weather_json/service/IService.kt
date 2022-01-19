package com.ders.weather_json.service

import com.ders.weather_json.model.Model
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IService {
    @GET("weather?,tr&appid=910e16fef36b07afbf5772fc7beaf68a&lang=tr&units=metric")
    fun getweather(@Query("q") city:String):Single<Model>
}