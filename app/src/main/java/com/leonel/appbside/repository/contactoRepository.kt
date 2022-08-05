package com.leonel.appbside.repository

import com.leonel.appbside.database.dao.contactoDao
import com.leonel.appbside.database.entities.contactoEntity
import com.leonel.appbside.model.Contacto
import com.leonel.appbside.model.add
import javax.inject.Inject

class contactoRepository @Inject constructor(private val contactodao: contactoDao) {

    suspend fun getAllContactosFromDatabase():List<Contacto>{
        val response: List<contactoEntity> = contactodao.getAllcontactos()
        return response.map { it.add() }
    }
    suspend fun insertcontacto(contacto:contactoEntity){
        contactodao.insertAll(contacto)
    }
    suspend fun clearcontactos(){
        contactodao.deleteAllcontactos()
    }

    suspend fun getAllContactoById(idContacto:String){
        contactodao.getAllContactoById(idContacto)
    }
}