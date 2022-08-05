package com.leonel.appbside.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leonel.appbside.model.Contacto

@Entity(tableName = "contacto_table")
data class contactoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "apellidos") val apellidos: String,
    @ColumnInfo(name = "telefono") val telefono: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "direccion") val direccion: String
)
fun Contacto.toDataBase() = contactoEntity(nombre = nombre,apellidos=apellidos,telefono = telefono,email = email,direccion = direccion)
