package br.com.compass.compassmart.ui.tela_detalhes

import java.io.Serializable

data class Produtos (
    val name: String,
    val valor: Int,
    val descricao: String,
    val imageResId: Int
) : Serializable