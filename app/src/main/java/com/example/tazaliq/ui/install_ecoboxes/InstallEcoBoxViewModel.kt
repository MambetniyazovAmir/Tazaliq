package com.example.tazaliq.ui.install_ecoboxes

import androidx.lifecycle.ViewModel
import com.example.tazaliq.data.firebase.EcoBoxHelper

class InstallEcoBoxViewModel(private var ecoBoxHelper: EcoBoxHelper) : ViewModel() {
    fun installEcoBox(
        companyName: String,
        name: String,
        phone: String,
        address: String,
        onSuccess: (msg: String) -> Unit,
        onFailure: (msg: String?) -> Unit
    ) {
        ecoBoxHelper.addEcoBox(companyName, name, phone, address, onSuccess, onFailure)
    }
}