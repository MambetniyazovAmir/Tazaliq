package com.example.tazaliq.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.data.dao.AboutDao
import com.example.tazaliq.data.model.AboutModel
import java.util.concurrent.Executor

class AboutViewModel(private val aboutDao: AboutDao, private val executors: Executor): ViewModel() {

    private val aboutListLiveData: MutableLiveData<List<AboutModel>> = MutableLiveData()
    val aboutList: LiveData<List<AboutModel>> = aboutListLiveData

    fun getAboutList() {
        executors.execute {
            aboutListLiveData.postValue(aboutDao.getAboutList())
        }
    }
}