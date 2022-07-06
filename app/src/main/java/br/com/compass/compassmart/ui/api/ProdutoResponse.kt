package br.com.compass.compassmart.ui.api

import java.io.Serializable

data class ProdutoResponse (
    val id: String,
    val name: String,
    val price: Double,
    val pic: String?
): Serializable
