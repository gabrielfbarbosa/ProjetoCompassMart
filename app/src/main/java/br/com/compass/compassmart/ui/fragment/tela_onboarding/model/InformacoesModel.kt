package br.com.compass.compassmart.ui.onboarding.model

import androidx.annotation.DrawableRes

data class InformacoesModel (
    val tiulo: String,
    val descricao : String,
    @DrawableRes val drawableId: Int
)