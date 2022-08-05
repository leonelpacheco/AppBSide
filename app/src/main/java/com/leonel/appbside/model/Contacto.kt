package com.leonel.appbside.model

import com.google.gson.annotations.SerializedName
import com.leonel.appbside.database.entities.contactoEntity

data class Contacto(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("apellidos") val apellidos: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("email") val email: String,
    @SerializedName("direccion") val direccion: String
)
fun Contacto.add()=Contacto(id,nombre,apellidos,telefono,email,direccion)
fun contactoEntity.add()=Contacto(id,nombre,apellidos,telefono,email,direccion)