package br.com.compass.compassmart.ui.fragment.tela_produtos

import androidx.annotation.DrawableRes

data class Produto (
    val modelo: String,
    val preco: String,
    @DrawableRes val drawableId: Int
)