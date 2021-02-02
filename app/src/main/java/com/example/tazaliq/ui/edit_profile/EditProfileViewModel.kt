package com.example.tazaliq.ui.edit_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.CityHelper
import com.example.tazaliq.data.firebase.ProfileHelper
import com.example.tazaliq.data.model.City
import com.example.tazaliq.data.model.User

class EditProfileViewModel(private val profileHelper: ProfileHelper, private val cityHelper: CityHelper) : ViewModel() {
    private var _user: MutableLiveData<Resource<User>> = MutableLiveData()
    val user: LiveData<Resource<User>>
        get() = _user

    private var _cities: MutableLiveData<Resource<List<City?>>> = MutableLiveData()
    val cities: LiveData<Resource<List<City?>>>
        get() = _cities
    fun getUser() {
        _user.value = Resource.loading()
        profileHelper.getUser(
            {
                _user.value = Resource.success(it)
            },
            {
                _user.value = Resource.error(it)
            }
        )
    }

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

    fun editProfile(name: String, cityId: String, status: String, about: String, onSuccess: () -> Unit, onFailure: (msg: String?) -> Unit) {
        profileHelper.editProfile(name, cityId, status, about, onSuccess, onFailure)
    }
}