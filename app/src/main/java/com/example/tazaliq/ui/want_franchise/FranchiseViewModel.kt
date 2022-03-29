package com.example.tazaliq.ui.want_franchise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.CityHelper
import com.example.tazaliq.data.model.City

class FranchiseViewModel(private val cityHelper: CityHelper): ViewModel() {
    private var _cities: MutableLiveData<Resource<List<City?>>> = MutableLiveData()
    val cities: LiveData<Resource<List<City?>>>
        get() = _cities

    fun getAllCities() {
        cityHelper.getAllCities(
            {
                _cities.value = Resource.success(it)
            },
            {
                _cities.value = Resource.error(it)
            }
        )
    }
}