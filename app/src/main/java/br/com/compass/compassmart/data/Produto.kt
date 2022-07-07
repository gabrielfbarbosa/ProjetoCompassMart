package br.com.compass.compassmart.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Produto(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val pic: String,
): Serializable
