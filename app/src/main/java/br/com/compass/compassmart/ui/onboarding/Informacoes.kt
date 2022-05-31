package br.com.compass.compassmart.ui.onboarding

import androidx.annotation.DrawableRes

data class Informacoes (
    val tiulo: String,
    val descricao : String,
    @DrawableRes val drawableId: Int
)
