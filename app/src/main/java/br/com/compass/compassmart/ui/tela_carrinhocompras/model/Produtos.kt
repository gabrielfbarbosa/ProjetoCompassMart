package br.com.compass.compassmart.ui.tela_carrinhocompras.model

import androidx.annotation.DrawableRes

data class Produtos(
    val descricao : String,
    val quantidade: String,
    val preco: String,
    @DrawableRes val drawableId: Int
)

