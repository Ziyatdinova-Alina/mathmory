package com.who.mathmory

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras

//class MainViewModel(val database : DerivativesRepository.DerivativesBase) : ViewModel() {
//
//    companion object{
//        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(
//                modelClass: Class<T>,
//                extras: CreationExtras): T {
//                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
//                return MainViewModel(database) as T
//            }
//        }
//    }
//}