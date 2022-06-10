package br.com.compass.compassmart.ui.tela_produtos

import androidx.annotation.DrawableRes

data class Produto (
    val modelo: String,
    val preco: String,
    @DrawableRes val drawableId: Int
)