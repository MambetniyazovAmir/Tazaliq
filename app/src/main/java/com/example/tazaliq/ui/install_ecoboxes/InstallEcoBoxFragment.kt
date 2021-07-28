package com.example.tazaliq.ui.install_ecoboxes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.databinding.FragmentInstallEcoboxBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class InstallEcoBoxFragment : BaseFragment(R.layout.fragment_install_ecobox) {

    private lateinit var binding: FragmentInstallEcoboxBinding
    private lateinit var navController: NavController
    private val viewModel: InstallEcoBoxViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInstallEcoboxBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.root_nav_host)
        binding.btnBack.onClick {
            navController.popBackStack()
        }
        binding.btnSend.onClick {
            viewModel.installEcoBox(
                binding.etCompanyName.text.toString(),
                binding.etName.text.toString(),
                binding.etPhone.text.toString(),
                binding.etAddress.text.toString(),
                onSuccess,
                onFailure
            )
        }
    }

    private val onSuccess: (msg: String) -> Unit = {
        toastSH(it)
    }

    private val onFailure: (msg: String?) -> Unit = {
        toastLN(it)
    }
}