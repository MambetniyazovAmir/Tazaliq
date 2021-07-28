package com.example.tazaliq.ui.faq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.FAQHelper
import com.example.tazaliq.data.model.FAQ

class FAQViewModel(private val helper: FAQHelper) : ViewModel() {
    private var _faq: MutableLiveData<Resource<List<FAQ?>>> = MutableLiveData()
    val faq: LiveData<Resource<List<FAQ?>>>
        get() = _faq

    fun getFAQ() {
        _faq.value = Resource.loading()
        helper.getFrequentQuestions(
            {
                _faq.value = Resource.success(it)
            },
            {
                _faq.value = Resource.error(it)
            }
        )
    }
}