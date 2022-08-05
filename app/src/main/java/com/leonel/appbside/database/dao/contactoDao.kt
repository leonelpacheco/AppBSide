package com.leonel.appbside.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leonel.appbside.database.entities.contactoEntity

@Dao
interface contactoDao {
    @Query("SELECT * FROM contacto_table ORDER BY id DESC")
    suspend fun getAllcontactos():List<contactoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contacto: contactoEntity)

    @Query("DELETE FROM contacto_table")
    suspend fun deleteAllcontactos()

    @Query("SELECT * FROM contacto_table WHERE id= :idcontacto")
    suspend fun getAllContactoById(idcontacto:String):List<contactoEntity>
}