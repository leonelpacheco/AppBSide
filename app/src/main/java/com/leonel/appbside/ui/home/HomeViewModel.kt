package com.leonel.appbside.ui.home

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
class HomeViewModel @Inject constructor(private val repository: contactoRepository): ViewModel() {

    val listcontactoModel = MutableLiveData<List<Contacto>>()
    val isLoading = MutableLiveData<Boolean>()
    val listcontactoeditModel = MutableLiveData<List<Contacto>>()

    fun insertarContacto(contactoinsert: Contacto){

        viewModelScope.launch {
            isLoading.postValue(true)
            val result= invoke(contactoinsert)
            if (!result.isNullOrEmpty()) {
                listcontactoModel.postValue(result!!)
                isLoading.postValue(false)
            }
            else
                isLoading.postValue(false)
        }

    }
    suspend operator fun invoke(contactoinsert : Contacto):List<Contacto>{

        repository.insertcontacto(contactoinsert.toDataBase())

        return repository.getAllContactosFromDatabase()

    }


    //-------------Consulta------------
    fun consultarContacto(idContacto: String){

        viewModelScope.launch {
            isLoading.postValue(true)
            val result= invokeconsulta(idContacto)
            if (!result.isNullOrEmpty()) {
                listcontactoeditModel.postValue(result!!)
                isLoading.postValue(false)
            }
            else
                isLoading.postValue(false)
        }

    }
    suspend fun invokeconsulta(idContacto: String):List<Contacto>{

        repository.getAllContactoById(idContacto)
        return repository.getAllContactosFromDatabase()

    }
    //----------------------------------
}