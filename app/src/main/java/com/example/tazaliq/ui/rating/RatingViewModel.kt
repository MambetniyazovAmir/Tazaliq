package com.example.tazaliq.ui.rating

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.CityHelper
import com.example.tazaliq.data.firebase.RatingHelper
import com.example.tazaliq.data.model.City
import com.example.tazaliq.data.model.User

class RatingViewModel(private val ratingHelper: RatingHelper, private val cityHelper: CityHelper) :
    ViewModel() {
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

    private var _users: MutableLiveData<Resource<List<User>>> = MutableLiveData()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    fun getUsers() {
        _users.value = Resource.loading()
        ratingHelper.getChampionUsers(
            {
                _users.value = Resource.success(it)
            },
            {
                _users.value = Resource.error(it)
            }
        )
    }

}