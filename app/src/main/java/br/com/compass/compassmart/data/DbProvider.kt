package br.com.compass.compassmart.data

import android.content.Context
import androidx.room.Room

object DbProvider {

    lateinit var applicationContext: Context

    val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    fun getCartDao(): CartDao = db.cartDao()
}