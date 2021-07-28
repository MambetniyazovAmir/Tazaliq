package com.example.tazaliq.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.AboutHelper
import com.example.tazaliq.data.model.FAQ
import java.util.concurrent.Executor

class AboutViewModel(private val aboutHelper: AboutHelper): ViewModel() {

    private val aboutListLiveData: MutableLiveData<Resource<List<FAQ>>> = MutableLiveData()
    val aboutList: LiveData<Resource<List<FAQ>>> = aboutListLiveData

    fun getAboutList() {
       aboutHelper.getAboutQuestions(
            {
                aboutListLiveData.value = Resource.success(it)
            },
            {
                aboutListLiveData.value = Resource.error(it)
            }
        )

    }
}
