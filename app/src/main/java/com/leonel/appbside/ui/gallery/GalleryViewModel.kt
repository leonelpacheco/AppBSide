package com.leonel.appbside.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonel.appbside.database.entities.toDataBase
import com.leonel.appbside.model.Contacto
import com.leonel.appbside.repository.contactoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: contactoRepository): ViewModel() {

    val listcontactoModel = MutableLiveData<List<Contacto>>()
    val isLoading = MutableLiveData<Boolean>()

    fun consultarContactos(){

        viewModelScope.launch {
            isLoading.postValue(true)
            val result= invoke()
            if (!result.isNullOrEmpty()) {
                listcontactoModel.postValue(result!!)
                isLoading.postValue(false)
            }
            else
                isLoading.postValue(false)
        }

    }


    suspend operator fun invoke():List<Contacto>{

        return repository.getAllContactosFromDatabase()

    }
}