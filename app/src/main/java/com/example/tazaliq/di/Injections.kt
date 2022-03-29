package com.example.tazaliq.di

import com.example.tazaliq.data.firebase.*
import com.example.tazaliq.ui.about.AboutViewModel
import com.example.tazaliq.ui.auth.login.LoginViewModel
import com.example.tazaliq.ui.auth.registration.RegistrationViewModel
import com.example.tazaliq.ui.edit_profile.EditProfileViewModel
import com.example.tazaliq.ui.faq.FAQViewModel
import com.example.tazaliq.ui.install_ecoboxes.InstallEcoBoxViewModel
import com.example.tazaliq.ui.market.MarketViewModel
import com.example.tazaliq.ui.profile.ProfileViewModel
import com.example.tazaliq.ui.rating.RatingViewModel
import com.example.tazaliq.ui.want_franchise.FranchiseViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val dataModule = module {
    single { AuthHelper(get()) }
    single { ProfileHelper(get(), get()) }
    single { CityHelper(get()) }
    single { FAQHelper(get()) }
    single { EcoBoxHelper(get()) }
    single { AboutHelper(get()) }
    single { RatingHelper(get()) }
    single { MarketHelper(get()) }
}

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
}

val executorModule = module {
    single<Executor> { Executors.newSingleThreadExecutor() }
}

val viewModelModule = module {
    viewModel { AboutViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegistrationViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { EditProfileViewModel(get(), get()) }
    viewModel { FAQViewModel(get()) }
    viewModel { InstallEcoBoxViewModel(get()) }
    viewModel { RatingViewModel(get(), get()) }
    viewModel { MarketViewModel(get()) }
    viewModel { FranchiseViewModel(get()) }
}
