package com.leonel.appbside.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leonel.appbside.database.dao.contactoDao
import com.leonel.appbside.database.entities.contactoEntity

@Database(entities = [contactoEntity::class], version = 1)
abstract class appbsideDataBase : RoomDatabase() {

    abstract fun getContactoDao(): contactoDao


}