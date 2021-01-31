package com.example.tazaliq.di

import androidx.room.Room
import com.example.tazaliq.data.TazaliqDatabase
import com.example.tazaliq.data.firebase.AuthHelper
import com.example.tazaliq.data.firebase.CityHelper
import com.example.tazaliq.data.firebase.FAQHelper
import com.example.tazaliq.data.firebase.ProfileHelper
import com.example.tazaliq.ui.about.AboutViewModel
import com.example.tazaliq.ui.auth.login.LoginViewModel
import com.example.tazaliq.ui.auth.registration.RegistrationViewModel
import com.example.tazaliq.ui.edit_profile.EditProfileViewModel
import com.example.tazaliq.ui.faq.FAQViewModel
import com.example.tazaliq.ui.profile.ProfileViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val dataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TazaliqDatabase::class.java,
            "TazaliqDatabase"
        ).build()
    }
    single { get<TazaliqDatabase>().aboutDao() }
    single { AuthHelper(get()) }
    single { ProfileHelper(get(), get()) }
    single { CityHelper(get()) }
    single { FAQHelper(get()) }
}

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
}

val executorModule = module {
    single<Executor> { Executors.newSingleThreadExecutor() }
}

val viewModelModule = module {
    viewModel { AboutViewModel(get(), get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegistrationViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { EditProfileViewModel(get()) }
    viewModel { FAQViewModel(get()) }
}