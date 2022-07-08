package br.com.compass.compassmart.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Produto::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
