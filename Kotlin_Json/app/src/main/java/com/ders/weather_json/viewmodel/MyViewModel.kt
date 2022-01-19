package com.ders.weather_json.viewmodel

import android.view.Display
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ders.weather_json.model.Model
import com.ders.weather_json.service.WeatherApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MyViewModel: ViewModel() {
    val weathers =MutableLiveData<Model>()
    private val weather = WeatherApi()
    private val disposable = CompositeDisposable()
    fun getDataApi(city:String){
        disposable.add(
            weather.getData(city)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Model>(){
                    override fun onSuccess(t: Model) {
                        weathers.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }
}