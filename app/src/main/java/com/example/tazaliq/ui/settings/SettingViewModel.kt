package com.example.tazaliq.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.ProfileHelper
import com.example.tazaliq.data.model.User

class SettingViewModel(private var profileHelper: ProfileHelper): ViewModel() {
    private var _user: MutableLiveData<Resource<User>> = MutableLiveData()
    val user: LiveData<Resource<User>>
        get() = _user

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
}