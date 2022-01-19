package com.ders.weather_json


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ders.weather_json.databinding.ActivityMainBinding
import com.ders.weather_json.viewmodel.MyViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding.imageButton.setOnClickListener {
            viewModel.getDataApi(binding.etcity.text.toString())
        }
        viewModel.weathers.observe(this){ weather ->
            binding.tvCity.text= weather.name
            binding.tvDegree.text = weather.main.temp.toInt().toString()
            binding.tvDescr.text  = weather.weather[0].description
            binding.tvHissedilen.text = weather.main.feels_like.toInt().toString()
            binding.tvMax.text = weather.main.temp_max.toInt().toString()
            binding.tvMin.text = weather.main.temp_min.toInt().toString()
            val imageUrl = "https://openweathermap.org/img/wn/" + weather.weather[0].icon + "@2x.png"
            Glide.with(this).load(imageUrl).into(binding.imageView)
        }


    }
}