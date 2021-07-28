package com.example.tazaliq.ui.qrcode_reader

import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.databinding.FragmentQrcodeReaderBinding
import com.google.zxing.BarcodeFormat

class QrcodeReaderFragment: BaseFragment(R.layout.fragment_qrcode_reader){

    private lateinit var binding: FragmentQrcodeReaderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}