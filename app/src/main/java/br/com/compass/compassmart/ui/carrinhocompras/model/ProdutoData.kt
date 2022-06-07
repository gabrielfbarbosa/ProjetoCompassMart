package br.com.compass.compassmart.ui.carrinhocompras.model

import androidx.annotation.DrawableRes

data class ProdutoData(
    @DrawableRes val drawableId: Int,
    val titulo: String,
    val qauntidade: Int
)
