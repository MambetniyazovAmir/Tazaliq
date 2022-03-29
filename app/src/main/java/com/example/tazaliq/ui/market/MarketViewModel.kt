package com.example.tazaliq.ui.market

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tazaliq.core.Resource
import com.example.tazaliq.data.firebase.MarketHelper
import com.example.tazaliq.data.model.Product

class MarketViewModel(private val marketHelper: MarketHelper) : ViewModel() {

    private var _products: MutableLiveData<Resource<List<Product>>> = MutableLiveData()
    val products: LiveData<Resource<List<Product>>>
        get() = _products

    fun getProducts() {
        _products.value = Resource.loading()
        marketHelper.getProducts(
            {
                _products.value = Resource.success(it)
            }, {
                _products.value = Resource.error(it)
            }
        )
    }
}