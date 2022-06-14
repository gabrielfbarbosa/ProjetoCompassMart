package br.com.compass.compassmart.ui.fragment.carrinhocompras.model

import androidx.annotation.DrawableRes

data class Produtos(
    val descricao : String,
    val preco: String,
    @DrawableRes val drawableId: Int
)
