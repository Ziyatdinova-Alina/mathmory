package com.who.mathmory.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//class DerivativesViewModel(application: Application): AndroidViewModel(application) {
//
//    private val getAllImages: LiveData<List<Derivatives>>
//    private val repository: DerivativesRepository
//
//    init {
//        val derivativesDao = DerivativesDatabase.getDatabase(application).derivativesDao()
//        repository = DerivativesRepository(derivativesDao)
//        getAllImages = repository.readAllData
//    }
//
//    fun addDerivatives(derivatives: Derivatives){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addDerivatives(derivatives)
//        }
//    }
//
//}